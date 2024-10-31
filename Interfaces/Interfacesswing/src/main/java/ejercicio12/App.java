package ejercicio12;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;

import practica.Login;

public class App {

	private JFrame frame;
	private JPanel pantalla1;
	private JPanel pantalla2;
	private JPanel pantalla3;
	private JPanel pantallaInicio;

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
		pantalla2 = new Pantalla2(this);
		pantalla3 = new Pantalla3(this);
		pantallaInicio = new PantallaInicio(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(pantallaInicio);
	}
	

	public void abrirPantalla1(String x) {
		((Pantalla1) pantalla1).cambiarText(x);
		frame.setContentPane(pantalla1);
		frame.revalidate();
	
	}
	public void abrirPantalla2(String x) {
		((Pantalla2) pantalla2).cambiarText(x);
		frame.setContentPane(pantalla2);
		frame.revalidate();
		
	}
	public void abrirPantalla3(String x) {
		((Pantalla3) pantalla3).cambiarText(x);
		frame.setContentPane(pantalla3);
		frame.revalidate();
		
	}

}
