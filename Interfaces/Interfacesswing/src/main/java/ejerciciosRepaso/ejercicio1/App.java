package ejerciciosRepaso.ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

	private JFrame frame;
	private JPanel pantalla1;

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
		pantalla1 = new Pantalla1(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(pantalla1);
	}
	
	public void abrirPantalla1(String x) {
		((Pantalla1) pantalla1).cambiarText(x);
		frame.setContentPane(pantalla1);
		frame.revalidate();
	
	}

}
