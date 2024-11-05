package interfazEjercicio5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.codec.digest.DigestUtils;

import modelo.User;
import service.AuthenticationException;
import service.UserService;

public class App {

	private JFrame frame;
	private JPanel login;
	private JPanel register;
	private JPanel profile;
	private JPanel changePass;
	private UserService userService;
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		userService = new UserService();
		login = new Login(this);
		register = new Register(this);
		profile = new Profile(this);
		changePass = new ChangePass(this);
		user = new User();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(login);

	}

	public void login() {

		try {
			user = userService.login(((Login) login).getUsername(), ((Login) login).getPassword());
			profile();
			setPanel(profile);

		} catch (AuthenticationException e) {
			JOptionPane.showMessageDialog(frame, "Login Failed: " + e.getMessage(), "Authentication Error",
					JOptionPane.ERROR_MESSAGE);

		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(frame, "An error occurred: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void register() {

		try {
			user.setUsername(((Register) register).getUsernameReg());
			user.setUserEmail(((Register) register).getEmailReg());
			user.setPassword(((Register) register).getPasswordReg());
			user = userService.register(user);
			profile();
			setPanel(profile);

		} catch (AuthenticationException e) {
			JOptionPane.showMessageDialog(frame, "Register Failed: " + e.getMessage(), "Authentication Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void profile() {
		try {
			user = userService.consultar(user.getUserId());

			((Profile) profile).setUsernamePr(user.getUsername());
			((Profile) profile).setEmailPr(user.getUserEmail());
			((Profile) profile).setLastLoginPr(user.getLastLoginAt());
			((Profile) profile).setCreatedAtPr(user.getCreatedAt());
			
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changePass() {
		try {
			user = userService.consultar(user.getUserId());
			String passCifrada = DigestUtils.sha256Hex(((ChangePass) changePass).getPassRec());
			if(!((ChangePass) changePass).getNewPassRec().equals(((ChangePass) changePass).getConfirmNewPassRec())){
				JOptionPane.showMessageDialog(frame, "Error: The new or the confirmation pass ", "Registration Error",
						JOptionPane.ERROR_MESSAGE);
			}
			if(((ChangePass) changePass).getNewPassRec().equals(((ChangePass) changePass).getConfirmNewPassRec())) {
				
				userService.changePass(user.getUserId(), ((ChangePass) changePass).getPassRec(), ((ChangePass) changePass).getNewPassRec());
				profile();
				setPanel(profile);
			}
			
			
			
		} catch (AuthenticationException e) {
			JOptionPane.showMessageDialog(frame, "Change Pasword Failed: " + e.getMessage(), "Authentication Error",
					JOptionPane.ERROR_MESSAGE);

		}

	}
	

	public void setLogin() {
		setPanel(login);
	}

	public void setRegister() {
		setPanel(register);
	}

	public void setProfile() {
		setPanel(login);
	}

	public void setChangePass() {
		setPanel(changePass);
	}

	private void setPanel(JPanel jpanel) {
		frame.setContentPane(jpanel);
		frame.revalidate();
	}

}
