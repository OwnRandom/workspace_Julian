package practica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bienvenida extends JPanel {

	private static final long serialVersionUID = 1L;

	private App app;
	
	/**
	 * Create the panel.
	 */
	public Bienvenida(App app) {
		this.app = app;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setBounds(137, 42, 79, 14);
		add(lblNewLabel);
		
		JButton BtSalir = new JButton("Salir");
		BtSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirLogin();
			}
		});
		BtSalir.setBounds(98, 156, 89, 23);
		add(BtSalir);

	}
}
