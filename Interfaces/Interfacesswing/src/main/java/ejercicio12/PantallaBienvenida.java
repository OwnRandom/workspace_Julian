package ejercicio12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaBienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private App app;

	/**
	 * Create the frame.
	 */
	public PantallaBienvenida(App app) {
		
		this.app = app;
		setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setBounds(170, 50, 111, 67);
		contentPane.add(lblNewLabel);
		
		String[] paginas = {"Página 1", "Página 2", "Página 3"};
		JComboBox<String> cBox = new JComboBox<>(paginas);
		cBox.setBounds(152, 112, 99, 22);
		contentPane.add(cBox);
		
		JButton btnBoton = new JButton("Entrar");
		btnBoton.setBounds(162, 165, 89, 23);
		contentPane.add(btnBoton);
		
		btnBoton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtiene el elemento seleccionado en el JComboBox
		        String seleccionado = (String) cBox.getSelectedItem();
		        
		        switch (seleccionado) {
		            case "Página 1":
		                app.abrirPantalla1(null);
		                break;
		            case "Página 2":
		                app.abrirPantalla2("");
		                break;
		            case "Página 3":
		                app.abrirPantalla3(null);
		                break;
		        }

		        dispose();
		    }
		});
		
		
		
		
	}
}
