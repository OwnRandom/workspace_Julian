package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.time.LocalDate;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dao.UserDao;
import modelo.User;

public class UserService extends Service {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	private UserDao userdao;

	public UserService() {
		this.userdao = new UserDao();
	}

	;

	public static boolean validarCorreo(String correo) {
		String PATRON_CORREO = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		return Pattern.matches(PATRON_CORREO, correo);
	}

	public User login(String login, String pass) throws AuthenticationException {
	    try (Connection conn = abrirConexion()) {
	        User user;
	        String passCifrada = DigestUtils.sha256Hex(pass);  // Cifrar la contraseña antes de la comparación

	        if (validarCorreo(login)) {
	            logger.debug("Attempting login with email: ", login);
	            user = userdao.consultEmail(conn, login);  // Buscar usuario por email
	        } else {
	            logger.debug("Attempting login with username: ", login);
	            user = userdao.consultUsername(conn, login);  // Buscar usuario por nombre de usuario
	        }

	        if (user != null) {
	            if (user.getPassword().equals(passCifrada)) {  // Verificar si la contraseña cifrada coincide
	                user.setLastLoginAt(LocalDate.now());
	                userdao.update(conn, user);  // Actualizar la fecha del último inicio de sesión
	                logger.debug("Access granted with: ", login);
	                return user;
	            } else {
	                logger.error("Failed login attempt: incorrect password for user: ", login);
	                throw new AuthenticationException("Incorrect password for user: " + login);
	            }
	        } else {
	            logger.error("Failed login attempt: " + login + " not found");
	            throw new AuthenticationException("User not found: " + login);
	        }
	    } catch (AuthenticationException ae) {
	        logger.error("Authentication failed: ", ae.getMessage());
	        throw ae;
	    } catch (SQLException sql) {
	        logger.error("Database error during login attempt for user: ", login, sql.getMessage());
	        throw new RuntimeException("Database error occurred", sql);
	    } catch (Exception e) {
	        logger.error("Unexpected error during login attempt for user: ", login, e.getMessage());
	        throw new RuntimeException("Unexpected error occurred", e);
	    }
	}


	public User register(User user) throws AuthenticationException {

		try (Connection conn = abrirConexion()) {
			String passCifrada = DigestUtils.sha256Hex(user.getPassword());
			user.setPassword(passCifrada);
			user.setLastLoginAt(LocalDate.now());
			user.setCreatedAt(LocalDate.now());
			logger.debug("Attempting to register with the username: ", user);
			if (userdao.consultUsername(conn, user.getUsername()) != null) {
				logger.error("Failed register attempt: Duplicated names not permited: ", user.getUsername());
				throw new AuthenticationException("Duplicated names not permited: " + user.getUsername());
			}
			if (userdao.consultEmail(conn, user.getUserEmail()) != null) {
				logger.error("Failed register attempt: Duplicated email not permited: ", user.getUserEmail());
				throw new AuthenticationException("Duplicated email not permited: " + user.getUserEmail());
			}
			if (validarCorreo(user.getUserEmail()) == false) {
				logger.error("Failed register attempt: Email format not permited: ", user.getUserEmail());
				throw new AuthenticationException("Email format not permited: " + user.getUserEmail());
			}

			user.setUserId(userdao.insert(conn, user));
			logger.debug("Access granted with: ", user);
			return user;
			
			

		} catch (AuthenticationException ae) {
			logger.error("Registering failed: ", ae.getMessage());
			throw ae;
		} catch (SQLException sql) {
			logger.error("Database error during registering attempt for user: ", user, sql.getMessage());
			throw new RuntimeException("Database error occurred", sql);
		} catch (Exception e) {
			logger.error("Unexpected error during registering attempt for user: ", user, e.getMessage());
			throw new RuntimeException("Unexpected error occurred", e);
		}
	}

	public User consultar(Long id) throws AuthenticationException {
		try (Connection conn = abrirConexion()) {
			User user = userdao.consultId(conn, id);
			logger.debug("Attempting to consulting with the id: ", id);
			if (user != null) {
				logger.debug("Access granted with id: ", id);
				return user;
			} else {
				logger.error("Failed consulting attempt: " + id + " not found");
				throw new AuthenticationException("User not found with id : " + id);
			}
		} catch (AuthenticationException ae) {
			logger.error("Consultation failed: ", ae.getMessage());
			throw ae;
		} catch (SQLException sql) {
			logger.error("Database error during the consultation attempt for ID: ", id, sql.getMessage());
			throw new RuntimeException("Database error occurred", sql);
		} catch (Exception e) {
			logger.error("Unexpected error during the consultation attempt for ID: ", id, e.getMessage());
			throw new RuntimeException("Unexpected error occurred", e);
		}
	}

	public void changePass(Long user_id, String pass, String newPass) throws AuthenticationException {
		try (Connection conn = abrirConexion()) {
			
			User user = userdao.consultId(conn, user_id);

			String passCifrada = DigestUtils.sha256Hex(pass);
			String passCifradaNueva = DigestUtils.sha256Hex(newPass);
			logger.debug("Attempting to consulting with the id: ", user_id);

			if (user == null) {
	            logger.error("User with ID not found", user_id);
	            throw new AuthenticationException("User not found with ID: " + user_id);
	        }
			
			if (!user.getPassword().equals(passCifrada)) {
	            logger.error("Incorrect current password for user with ID: "  , user_id);
	            throw new AuthenticationException("Incorrect current password for user with ID: " + user_id);
	        }
			
			if (passCifrada.equals(passCifradaNueva)) {
	            logger.error("Same passwords not permitted : ", user_id);
	            throw new AuthenticationException("Same passwords not permitted : " + user_id);
	        }
			
			
			user.setPassword(passCifradaNueva);
	        userdao.update(conn, user);
	        logger.debug("Password successfully changed for user with ID: {}", user_id);

		} catch (AuthenticationException ae) {
			logger.error("Password change failed: ", ae.getMessage());
			throw ae;
		} catch (SQLException sql) {
			logger.error("Database error during the password change attempt for ID: ", user_id, sql.getMessage());
			throw new RuntimeException("Database error occurred", sql);
		} catch (Exception e) {
			logger.error("Unexpected error during the password change attempt for ID: ", user_id, e.getMessage());
			throw new RuntimeException("Unexpected error occurred", e);
		}
	}

}
