package ejercicio12;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class Pantalla1 extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private App app;
	private JTextField textField;
	

	/**
	 * Create the panel.
	 */
	public Pantalla1(App app) {
		this.app = app;
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(175, 111, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton Bt1 = new JButton("Pagina1");
		Bt1.setEnabled(false);
		Bt1.setBounds(36, 187, 89, 23);
		add(Bt1);
		
		JButton Bt2 = new JButton("Pantalla2");
		Bt2.setBounds(178, 187, 89, 23);
		add(Bt2);
		
		JButton Bt3 = new JButton("Pantalla3");
		Bt3.setBounds(322, 187, 89, 23);
		add(Bt3);
		
		JLabel lblNewLabel = new JLabel("PANTALLA1");
		lblNewLabel.setBounds(175, 49, 73, 14);
		add(lblNewLabel);
		
		String[] paginas = {"Página 1", "Página 2", "Página 3"};
		
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Copiar");
		chckbxNewCheckBox.setBounds(175, 138, 97, 23);
		add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setBounds(351, 11, 89, 23);
		add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int respuesta = JOptionPane.showConfirmDialog(null,
				            "¿Está seguro de que desea salir?",
				            "Confirmación de salida",
				            JOptionPane.YES_NO_OPTION,
				            JOptionPane.QUESTION_MESSAGE);

				        if (respuesta == JOptionPane.YES_OPTION) {
				            System.exit(0);
				        }
			}
		});
		
		
		Bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected() == true) {
				app.abrirPantalla2(textField.getText());
				}else {
					app.abrirPantalla2(null);
				}
			}
		});
		Bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected() == true) {
					app.abrirPantalla3(textField.getText());
					}else {
						app.abrirPantalla3(null);
					}
				
			}
		});

	}
	
	public void cambiarText(String text) {
		textField.setText(text);
	}
}
