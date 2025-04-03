import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculadora {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Calculadora Básica - 4 Operaciones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Centrar la ventana

        // Panel principal con BoxLayout vertical
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Panel de entrada: contiene dos campos para números y selección de la operación
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel labelNum1 = new JLabel("Número 1:");
        JTextField textFieldNum1 = new JTextField();
        JLabel labelNum2 = new JLabel("Número 2:");
        JTextField textFieldNum2 = new JTextField();
        JLabel labelOper = new JLabel("Operación:");
        // Opciones de operaciones disponibles
        String[] operaciones = { "Suma", "Resta", "Multiplicación", "División" };
        JComboBox<String> operCombo = new JComboBox<>(operaciones);

        inputPanel.add(labelNum1);
        inputPanel.add(textFieldNum1);
        inputPanel.add(labelNum2);
        inputPanel.add(textFieldNum2);
        inputPanel.add(labelOper);
        inputPanel.add(operCombo);

        // Panel de botones: "Calcular" y "Limpiar"
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton clearButton = new JButton("Limpiar");
        JButton calculateButton = new JButton("Calcular");
        buttonPanel.add(clearButton);
        buttonPanel.add(calculateButton);
        

        // Panel de salida: muestra el resultado de la operación
        JPanel outputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel resultLabel = new JLabel("Resultado: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        outputPanel.add(resultLabel);

        // Agregar los sub-paneles al panel principal
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado vertical
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado vertical
        mainPanel.add(outputPanel);

        // Agregar el panel principal a la ventana y hacerla visible
        frame.add(mainPanel);
        frame.setVisible(true);

        // Controlador de eventos para el botón "Calcular"
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener y convertir los números ingresados
                    double num1 = Double.parseDouble(textFieldNum1.getText());
                    double num2 = Double.parseDouble(textFieldNum2.getText());
                    String oper = (String) operCombo.getSelectedItem();
                    double resultado = 0;

                    // Realizar la operación según la selección del usuario
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
                            // Validar división por cero
                            if (num2 == 0) {
                                JOptionPane.showMessageDialog(frame, "Error: División entre cero no permitida.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            resultado = num1 / num2;
                            break;
                    }
                    // Mostrar el resultado en la etiqueta
                    resultLabel.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    // Manejo de error para entrada inválida
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese números válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Controlador de eventos para el botón "Limpiar"
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar los campos de texto, restablecer el JComboBox y la etiqueta de resultado
                textFieldNum1.setText("");
                textFieldNum2.setText("");
                operCombo.setSelectedIndex(0);
                resultLabel.setText("Resultado: ");
            }
        });
    }
}
