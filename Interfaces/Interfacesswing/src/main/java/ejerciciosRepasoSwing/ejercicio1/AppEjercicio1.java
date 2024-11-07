package ejerciciosRepasoSwing.ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class AppEjercicio1 {

	private JFrame frame;
	private JPanel jpanel1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppEjercicio1 window = new AppEjercicio1();
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
	public AppEjercicio1() {
		jpanel1 = new Jpanel1(this);
		
		JCheckBox CHbox = new JCheckBox("Acepta los terminos");
		CHbox.setBounds(140, 166, 141, 23);
		jpanel1.add(CHbox);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(jpanel1);

	}
}
