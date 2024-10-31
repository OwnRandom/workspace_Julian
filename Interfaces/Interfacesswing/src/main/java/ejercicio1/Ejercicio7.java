package ejercicio1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Ejercicio7 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio7 window = new Ejercicio7();
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
	public Ejercicio7() {
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
		
		textField = new JTextField();
		
		
		textField.setBounds(161, 62, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 93, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(161, 124, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(161, 155, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		//1
		
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				textField.setBackground(Color.GREEN);
			}
			@Override
			public void focusLost(FocusEvent e) {
				textField.setBackground(null);
			}
		});
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					textField_3.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					textField_1.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					textField_1.requestFocus();
				}
				
			}
		});
		//2
		
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				textField_1.setBackground(Color.GREEN);
			}
			@Override
			public void focusLost(FocusEvent e) {
				textField_1.setBackground(null);
			}
		});
		
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					textField.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					textField_2.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					textField_2.requestFocus();
				}
				
			}
		});
		//3
		
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				textField_2.setBackground(Color.GREEN);
			}
			@Override
			public void focusLost(FocusEvent e) {
				textField_2.setBackground(null);
			}
		});
		
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					textField_1.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					textField_3.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					textField_3.requestFocus();
				}
				
			}
		});
		//4
		
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				textField_3.setBackground(Color.GREEN);
			}
			@Override
			public void focusLost(FocusEvent e) {
				textField_3.setBackground(null);
			}
		});
		
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					textField_2.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					textField.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					textField.requestFocus();
				}
			}
		});
		
		
	}

}
