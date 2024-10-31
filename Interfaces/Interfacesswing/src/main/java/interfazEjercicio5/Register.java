package interfazEjercicio5;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Register extends JPanel {

	private static final long serialVersionUID = 1L;
	private App app;
	private JTextField tFUsername;
	private JTextField tFEmail;
	private JPasswordField pFPass;
	private JPasswordField pFConfirmPass;
	/**
	 * Create the panel.
	 */
	public Register(App app) {
		this.app = app;
		setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(88, 25, 68, 14);
		add(lblUsername);
		
		tFUsername = new JTextField();
		tFUsername.setBounds(98, 50, 227, 20);
		add(tFUsername);
		tFUsername.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(88, 81, 46, 14);
		add(lblEmail);
		
		tFEmail = new JTextField();
		tFEmail.setBounds(98, 106, 227, 20);
		add(tFEmail);
		tFEmail.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Password");
		lblContraseña.setBounds(88, 137, 180, 14);
		add(lblContraseña);
		
		JLabel lblConfirmPass = new JLabel("Confirm your password");
		lblConfirmPass.setBounds(88, 193, 143, 14);
		add(lblConfirmPass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.register();
			}
		});
		btnRegister.setBounds(108, 249, 89, 23);
		add(btnRegister);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.setLogin();
			}
		});
		btnLogIn.setBounds(236, 249, 89, 23);
		add(btnLogIn);
		
		pFPass = new JPasswordField();
		pFPass.setBounds(98, 162, 227, 20);
		add(pFPass);
		
		pFConfirmPass = new JPasswordField();
		pFConfirmPass.setBounds(98, 218, 227, 20);
		add(pFConfirmPass);
		
		
	}
	
	public String getUsernameReg() {
		return tFUsername.getText();
	}
	public String getEmailReg() {
		return tFEmail.getText();
	}
	public String getPasswordReg() {
		String pass = new String(pFPass.getPassword());
		return 	pass;
	}
	public String getConfirmedPasswordReg() {
		String pass = new String(pFConfirmPass.getPassword());
		return 	pass;
	}
}
