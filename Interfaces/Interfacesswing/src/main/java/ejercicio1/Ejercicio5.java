package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class Ejercicio5 {

	private JFrame frame;
	private JTextField tfField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5 window = new Ejercicio5();
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
	public Ejercicio5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnSumar = new JButton("Sumar");

		btnSumar.setBounds(167, 139, 89, 23);
		frame.getContentPane().add(btnSumar);

		tfField = new JTextField();
		tfField.setText("");
		tfField.setBounds(170, 108, 86, 20);
		frame.getContentPane().add(tfField);
		tfField.setColumns(10);

		btnSumar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (tfField.getText().isBlank()) {
					tfField.setText("1");
				} else {
					try {
						int numeroActual = Integer.parseInt(tfField.getText());
						numeroActual++;
						tfField.setText(Integer.toString(numeroActual));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido", "Error",
								JOptionPane.ERROR_MESSAGE);
						tfField.setText("");
					}

				}

			}
		});
	}

}
