package ejercicio1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Swing1 {

	private JFrame frame;
	private int opcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing1 window = new Swing1();
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
	public Swing1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JButton btnNewButton_1 = new JButton("1");
		
		
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("2");
		
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("3");
		
		frame.getContentPane().add(btnNewButton);
		
		JLabel lbMostrar = new JLabel("Has hecho click en el boton");
		frame.getContentPane().add(lbMostrar);
		//3
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lbMostrar.setText("Has hecho click en el boton 3");
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(Color.pink);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton.setText(btnNewButton.getText() + "!");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(null);
			}
		});
		//2
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lbMostrar.setText("Has hecho click en el boton 2");

				
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(Color.pink);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_2.setText(btnNewButton_2.getText() + "!");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(null);
			}
		});
		
		//1
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lbMostrar.setText("Has hecho click en el boton 1");

				
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(Color.pink);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_1.setText(btnNewButton_1.getText() + "!");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(null);
			}
		});
		
		
	}
}
