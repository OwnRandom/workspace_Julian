package ejerciciosRepaso.ejercicio1;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class Pantalla1 extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private App app;
	private JTextField textField;
	private JTextField tF1;

	/**
	 * Create the panel.
	 */
	public Pantalla1(App app) {
		this.app = app;
		setLayout(null);
		
		JLabel nL1 = new JLabel("Ingrese su edad");
		nL1.setBounds(168, 105, 86, 14);
		add(nL1);
		
		tF1 = new JTextField();
		tF1.setBounds(166, 130, 86, 20);
		add(tF1);
		tF1.setColumns(10);

	}

	public void cambiarText(String text) {
		textField.setText(text);
	}
	
	private void comprobar() {
		String texto = tF1.getText();
		if(texto.matches("\\d+")) {
			
		}
		
	}
	
	
	
	
}
