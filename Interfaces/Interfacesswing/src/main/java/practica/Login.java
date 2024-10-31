package practica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;

	private App app;
	
	
	/**
	 * Create the panel.
	 */
	public Login(App app) {
		this.app = app;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(97, 71, 120, 14);
		add(lblNewLabel);
		
		JButton BtEntrar = new JButton("Entrar");
		BtEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				app.abrirBienvenida();
				
			}
		});
		BtEntrar.setBounds(128, 150, 89, 23);
		add(BtEntrar);

	}
}
