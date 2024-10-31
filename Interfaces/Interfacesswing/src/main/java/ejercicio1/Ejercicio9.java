package ejercicio1;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio9 {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JComboBox<String> comboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Ejercicio9 window = new Ejercicio9();
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
    public Ejercicio9() {
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

        // Crear los TextFields
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

        // Crear el ComboBox
        String[] colores = {"verde", "azul", "rojo"};
        comboBox = new JComboBox<>(colores);
        
        comboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String[] intSelectedIndex = colores;
        	}
        });
        
        comboBox.setBounds(27, 41, 86, 22);
        frame.getContentPane().add(comboBox);
        
        //Crear los RadioBoton
        JRadioButton rdVerde = new JRadioButton("verde");
        rdVerde.setBounds(27, 172, 109, 23);
        frame.getContentPane().add(rdVerde);
        
        JRadioButton rdRojo = new JRadioButton("rojo");
        rdRojo.setBounds(27, 198, 109, 23);
        frame.getContentPane().add(rdRojo);
        
        JRadioButton rdAzul = new JRadioButton("azul");
        rdAzul.setBounds(27, 224, 109, 23);
        frame.getContentPane().add(rdAzul);
        
        
        //Creamos un grupo para que los button solo pueda seleccionarse uno
        ButtonGroup group = new ButtonGroup();
        //Agregamos los buttons a el grupo
        group.add(rdVerde);
        group.add(rdRojo);
        group.add(rdAzul);

        // Arreglo de todos los campos de texto
        JTextField[] textFields = {textField, textField_1, textField_2, textField_3};

        // Agregar listeners a todos los TextFields
        for (int i = 0; i < textFields.length; i++) {
            final int index = i;
            // Agregar el único listener de foco
            textFields[i].addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    cambiarColor(textFields[index]);  // Cambiar el color cuando se gana el foco
                }

                @Override
                public void focusLost(FocusEvent e) {
                    textFields[index].setBackground(null);  // Volver al color original al perder el foco
                }
            });
            

            // Agregar el único listener de teclado
            textFields[i].addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    manejarTeclas(e, index, textFields);  // Manejar teclas arriba, abajo y enter
                }
            });
        }
    }

    // Método para cambiar el color según el valor seleccionado en el ComboBox
    private void cambiarColor(JTextField textField) {
        String colorSeleccionado = (String) comboBox.getSelectedItem();
        switch (colorSeleccionado) {
            case "verde":
                textField.setBackground(Color.GREEN);
                break;
            case "azul":
                textField.setBackground(Color.BLUE);
                break;
            case "rojo":
                textField.setBackground(Color.RED);
                break;
        }
    }

    private void manejarTeclas(KeyEvent e, int index, JTextField[] textFields) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            textFields[(index - 1 + textFields.length) % textFields.length].requestFocus();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
            textFields[(index + 1) % textFields.length].requestFocus();
        }
    }
    
    
    
    
}