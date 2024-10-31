package ejercicio12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PantallaInicio extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	private App app;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public PantallaInicio(App app) {
		this.app = app;
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido");
		lblNewLabel_1.setBounds(172, 107, 127, 14);
		add(lblNewLabel_1);
		
		String[] paginas = {"Página 1", "Página 2", "Página 3"};
		JComboBox<String> comboBox = new JComboBox<>(paginas);
		comboBox.setBounds(182, 134, 83, 22);
		add(comboBox);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(158, 186, 89, 23);
		add(btnNewButton);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtiene el elemento seleccionado en el JComboBox
		        String seleccionado = (String) comboBox.getSelectedItem();
		        
		        switch (seleccionado) {
		            case "Página 1":
		                app.abrirPantalla1(null);
		                break;
		            case "Página 2":
		                app.abrirPantalla2(null);
		                break;
		            case "Página 3":
		                app.abrirPantalla3(null);
		                break;
		        }
		    }
		});
		
	}

}
