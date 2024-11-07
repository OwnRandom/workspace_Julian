package ejerciciosRepasoSwing.ejercicio1;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfazEjercicio5.App;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Jpanel1 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tF;
	private App app;


	/**
	 * Create the panel.
	 */
	public Jpanel1(AppEjercicio1 appEjercicio1) {
		setLayout(null);
		
		JLabel lblEdad = new JLabel("Coloca tu edad");
		lblEdad.setBounds(163, 112, 84, 14);
		add(lblEdad);
		
		tF = new JTextField();

		tF.setBounds(163, 137, 86, 20);
		add(tF);
		tF.setColumns(10);

		
		
		
		tF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				
				int currentValue = Integer.parseInt(tF.getText());
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					tF.setText(String.valueOf(currentValue + 1));
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                	tF.setText(String.valueOf(currentValue - 1));
                }
				if(currentValue <= 1) {
                	tF.setText(String.valueOf(currentValue = 1));
                }
				
			}
		});
		
		
		
	}
}
