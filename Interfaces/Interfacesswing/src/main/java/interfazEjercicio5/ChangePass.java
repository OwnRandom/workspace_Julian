package interfazEjercicio5;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePass extends JPanel {

	private static final long serialVersionUID = 1L;
	private App app;
	private JPasswordField pFPass;
	private JPasswordField pFNewPass;
	private JPasswordField pFConfirmNewPass;
	/**
	 * Create the panel.
	 */
	public ChangePass(App app) {
		this.app = app;
		setLayout(null);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setBounds(126, 67, 57, 14);
		add(lblPass);
		
		JLabel lblNewPass = new JLabel("New Password");
		lblNewPass.setBounds(126, 123, 78, 14);
		add(lblNewPass);
		
		JLabel lblConfirmNewPass = new JLabel("Confirm new password");
		lblConfirmNewPass.setBounds(126, 179, 116, 14);
		add(lblConfirmNewPass);
		
		pFPass = new JPasswordField();
		pFPass.setBounds(123, 92, 208, 20);
		add(pFPass);
		
		pFNewPass = new JPasswordField();
		pFNewPass.setBounds(123, 148, 211, 20);
		add(pFNewPass);
		
		pFConfirmNewPass = new JPasswordField();
		pFConfirmNewPass.setBounds(126, 204, 208, 20);
		add(pFConfirmNewPass);
		
		JButton btnAceptar = new JButton("Accept");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.changePass();
				app.setLogin();
			}
		});
		btnAceptar.setBounds(126, 246, 89, 23);
		add(btnAceptar);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.setProfile();
			}
		});
		btnBack.setBounds(242, 246, 89, 23);
		add(btnBack);
		
	}
	
	
	public String getPassRec() {
		String pass = new String(pFPass.getPassword());
		return 	pass;
	}
	public String getNewPassRec() {
		String pass = new String(pFNewPass.getPassword());
		return 	pass;
	}
	public String getConfirmNewPassRec() {
		String pass = new String(pFConfirmNewPass.getPassword());
		return 	pass;
	}
}
