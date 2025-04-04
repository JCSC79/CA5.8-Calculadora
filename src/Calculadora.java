import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Clase principal que implementa una calculadora gráfica avanzada.
 * Permite realizar operaciones matemáticas como suma, resta, multiplicación, división y potencia.
 * Además, incluye un historial de cálculos realizados.
 */
public class Calculadora {
    public static void main(String[] args) {
        // Crear la ventana principal de la aplicación
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al salir
        frame.setSize(500, 400); // Tamaño fijo de la ventana
        frame.setResizable(false); // Evitar que el usuario cambie el tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Panel principal: organiza los sub-paneles verticalmente
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Diseño vertical
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Márgenes internos

        /**
         * Panel de entrada:
         * Contiene dos campos de texto para ingresar números y un JComboBox para seleccionar la operación.
         */
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // Diseño en cuadrícula
        JLabel labelNum1 = new JLabel("Número 1:"); // Etiqueta para el primer número
        JTextField textFieldNum1 = new JTextField(); // Campo de texto para el primer número
        JLabel labelNum2 = new JLabel("Número 2:"); // Etiqueta para el segundo número
        JTextField textFieldNum2 = new JTextField(); // Campo de texto para el segundo número
        JLabel labelOper = new JLabel("Operación:"); // Etiqueta para seleccionar la operación

        // Lista desplegable con las operaciones disponibles (suma, resta, multiplicación, división y potencia)
        String[] operaciones = { "Suma", "Resta", "Multiplicación", "División", "Potencia" };
        JComboBox<String> operCombo = new JComboBox<>(operaciones);

        // Agregar los componentes al panel de entrada
        inputPanel.add(labelNum1);
        inputPanel.add(textFieldNum1);
        inputPanel.add(labelNum2);
        inputPanel.add(textFieldNum2);
        inputPanel.add(labelOper);
        inputPanel.add(operCombo);

        /**
         * Panel de botones:
         * Contiene los botones "Calcular" y "Limpiar".
         */
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Diseño centrado
        JButton calculateButton = new JButton("Calcular"); // Botón para realizar la operación seleccionada
        JButton clearButton = new JButton("Limpiar"); // Botón para limpiar los campos y restablecer valores
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        /**
         * Panel de salida:
         * Muestra el resultado de la operación seleccionada.
         */
        JPanel outputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Diseño centrado
        JLabel resultLabel = new JLabel("Resultado: "); // Etiqueta para mostrar el resultado
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente más grande y en negrita
        outputPanel.add(resultLabel);

        /**
         * Panel del historial:
         * Muestra un área de texto donde se guarda el historial de cálculos realizados.
         */
        JPanel historyPanel = new JPanel(new BorderLayout()); // Diseño con bordes (para organizar mejor)
        JLabel historyLabel = new JLabel("Historial:");
        JTextArea historyArea = new JTextArea(5, 40); // Área de texto para mostrar el historial
        historyArea.setEditable(false); // Solo lectura (el usuario no puede modificarlo directamente)
        
        JScrollPane scrollPane = new JScrollPane(historyArea); // Scroll para manejar muchos cálculos en el historial
        
        historyPanel.add(historyLabel, BorderLayout.NORTH); // Etiqueta en la parte superior del panel
        historyPanel.add(scrollPane, BorderLayout.CENTER); // Área de texto dentro del panel

        /**
         * Agregar todos los sub-paneles al panel principal:
         * Esto organiza visualmente los elementos en la ventana.
         */
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado vertical entre paneles
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado vertical entre paneles
        mainPanel.add(outputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado vertical entre paneles
        mainPanel.add(historyPanel);

        frame.add(mainPanel); // Agregar el panel principal a la ventana
        frame.setVisible(true); // Hacer visible la ventana

        /**
         * Lista para almacenar el historial de cálculos realizados.
         */
        ArrayList<String> historial = new ArrayList<>();

        /**
         * Controlador del botón "Calcular":
         * Realiza la operación seleccionada por el usuario y muestra el resultado.
         */
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(textFieldNum1.getText()); // Obtener primer número ingresado
                    double num2 = Double.parseDouble(textFieldNum2.getText()); // Obtener segundo número ingresado
                    String oper = (String) operCombo.getSelectedItem();       // Operación seleccionada por el usuario
                    
                    double resultado = 0;                                    // Variable para almacenar el resultado

                    /**
                     * Realizar la operación matemática según lo seleccionado por el usuario:
                     * - Validar división por cero en caso necesario.
                     */
                    switch (oper) {
                        case "Suma":
                            resultado = num1 + num2;
                            break;
                        case "Resta":
                            resultado = num1 - num2;
                            break;
                        case "Multiplicación":
                            resultado = num1 * num2;
                            break;
                        case "División":
                            if (num2 == 0) { 
                                JOptionPane.showMessageDialog(frame,
                                    "Error: División entre cero no permitida.",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                                return; 
                            }
                            resultado = num1 / num2;
                            break;
                        case "Potencia":
                            resultado = Math.pow(num1, num2); 
                            break;
                    }

                    resultLabel.setText("Resultado: " + resultado); 

                    /**
                     * Guardar el cálculo realizado en el historial.
                     */
                    historial.add(num1 + " " + oper + " " + num2 + " = " + resultado);
                    historyArea.setText(String.join("\n", historial)); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                        "Por favor, ingrese números válidos.",
                        "Error de entrada",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /**
         * Controlador del botón "Limpiar":
         * Restablece los campos de entrada y limpia los resultados mostrados.
         */
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNum1.setText(""); 
                textFieldNum2.setText(""); 
                operCombo.setSelectedIndex(0); 
                resultLabel.setText("Resultado: "); 
            }
        });
    }
}
