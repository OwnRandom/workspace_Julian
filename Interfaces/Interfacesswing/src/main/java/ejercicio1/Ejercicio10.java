package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio10 {

	private static final Color AZUL = Color.BLUE;
	private static final Color ROJO = Color.RED;
	private static final Color AMARILLO = Color.YELLOW;
	private static final Color VERDE = Color.GREEN;
	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JRadioButton NRBAmarillo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio10 window = new Ejercicio10();
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
	public Ejercicio10() {
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
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		textField1 = new JTextField();
		textField1.setBounds(94, 66, 96, 19);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(94, 106, 96, 19);
		frame.getContentPane().add(textField2);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(94, 154, 96, 19);
		frame.getContentPane().add(textField3);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(94, 195, 96, 19);
		
		frame.getContentPane().add(textField4);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(275, 66, 96, 21);
		frame.getContentPane().add(comboBox);
		
		 Map<String, Color> optionMap = new HashMap<>();
		 optionMap.put("VERDE", VERDE);
		 optionMap.put("AMARILLO", AMARILLO);
		 optionMap.put("AZUL", AZUL);
		 optionMap.put("ROJO", ROJO);
		 
		 
		
		comboBox.addItem("VERDE");
		comboBox.addItem("AMARILLO");
		comboBox.addItem("ROJO");
		comboBox.addItem("AZUL");
		comboBox.setFocusable(false);
		
		JRadioButton NRBVerde = new JRadioButton("VERDE");
		NRBVerde.setBounds(275, 130, 109, 23);
		frame.getContentPane().add(NRBVerde);
		NRBVerde.setFocusable(false);
		
		JRadioButton NRBRojo = new JRadioButton("ROJO");
		NRBRojo.setBounds(275, 153, 109, 23);
		frame.getContentPane().add(NRBRojo);
		NRBRojo.setFocusable(false);

		
		JRadioButton NRBAzul = new JRadioButton("AZUL");
		NRBAzul.setBounds(275, 179, 109, 23);
		frame.getContentPane().add(NRBAzul);
		NRBAzul.setFocusable(false);
		
		JRadioButton NRBAmarillo = new JRadioButton("AMARILLO");
		NRBAmarillo.setBounds(275, 205, 109, 23);
		frame.getContentPane().add(NRBAmarillo);
		NRBAmarillo.setFocusable(false);
		
		 ButtonGroup group = new ButtonGroup();
	        group.add(NRBRojo);
	        group.add(NRBAzul);   
	        group.add(NRBVerde);
	        group.add(NRBAmarillo);
	        
		ActionListener sincronice = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String color = (String) combo.getSelectedItem();
				
				for (Iterator iterator = group.getElements().asIterator(); iterator.hasNext();) {
					JRadioButton boton = (JRadioButton) iterator.next();
					if (boton.getText().equals(color)) {
						boton.setSelected(true);
					} 
				}
				
			}
		};
	        
		comboBox.addActionListener(sincronice);
		
		
		KeyListener keyListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				JTextField origen = (JTextField) e.getSource();
				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					origen.transferFocus();
				}
				else if (e.getKeyCode() == KeyEvent.VK_UP) {
					origen.transferFocusBackward();
				}
			}
		};
		
		
		
		textField1.addKeyListener(keyListener);
		textField2.addKeyListener(keyListener);
		textField3.addKeyListener(keyListener);
		textField4.addKeyListener(keyListener);
		
		
		
		FocusListener focusListener = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				JTextField origen = (JTextField) e.getSource();
				origen.setBackground(Color.WHITE);
			}
			
			@Override
			public void focusGained(FocusEvent e) { 
				JTextField origen = (JTextField) e.getSource();
				origen.setBackground(optionMap.get(comboBox.getSelectedItem()));
				
			}
		};
		
		textField1.addFocusListener(focusListener);
		textField2.addFocusListener(focusListener);
		textField3.addFocusListener(focusListener);
		textField4.addFocusListener(focusListener);
		
		
	}
}