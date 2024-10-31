package interfazEjercicio5;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;

import service.UserService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private App app;
	private JTextField tFLogin;
	private JPasswordField pFPass;

	/**
	 * Create the panel.
	 */
	public Login(App app) {

		this.app = app;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username or email");
		lblNewLabel.setBounds(115, 82, 131, 14);
		add(lblNewLabel);
		
		tFLogin = new JTextField();
		tFLogin.setBounds(115, 107, 205, 20);
		add(tFLogin);
		tFLogin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(115, 138, 106, 14);
		add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.login();
			}
		});
		btnLogin.setBounds(174, 219, 89, 23);
		add(btnLogin);
		
		JButton btnRegistrarse = new JButton("Register");	
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.setRegister();
			}
		});
		btnRegistrarse.setBounds(231, 48, 89, 23);
		add(btnRegistrarse);
		
		pFPass = new JPasswordField();
		pFPass.setBounds(115, 163, 205, 20);
		add(pFPass);
		
		
		
		
	}
	
	
	
	public String getUsername() {
		return tFLogin.getText();
	}
	
	public String getPassword() {
			String pass = new String(pFPass.getPassword());
		
			return 	pass;
		}
}
