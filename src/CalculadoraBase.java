import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Clase base para las calculadoras.
 * Define la estructura básica de la interfaz gráfica.
 */
public class CalculadoraBase extends JFrame {
    protected JPanel mainPanel, inputPanel, buttonPanel, outputPanel, historyPanel;
    protected JLabel labelNum1, labelNum2, labelOper, resultLabel, historyLabel;
    protected JTextField textFieldNum1, textFieldNum2;
    protected JComboBox<String> operCombo;
    protected JButton calculateButton, clearButton;
    protected JTextArea historyArea;
    protected JScrollPane scrollPane;
    protected ArrayList<String> historial;

    public CalculadoraBase(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        // Inicializar paneles y componentes comunes
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        outputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        historyPanel = new JPanel(new BorderLayout());

        labelNum1 = new JLabel("Número 1:");
        labelNum2 = new JLabel("Número 2:");
        labelOper = new JLabel("Operación:");
        resultLabel = new JLabel("Resultado: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        historyLabel = new JLabel("Historial:");

        textFieldNum1 = new JTextField();
        textFieldNum2 = new JTextField();

        operCombo = new JComboBox<>();

        calculateButton = new JButton("Calcular");
        clearButton = new JButton("Limpiar");

        historyArea = new JTextArea(5, 40);
        historyArea.setEditable(false);
        scrollPane = new JScrollPane(historyArea);

        historial = new ArrayList<>();

        // Configurar paneles
        inputPanel.add(labelNum1);
        inputPanel.add(textFieldNum1);
        inputPanel.add(labelNum2);
        inputPanel.add(textFieldNum2);
        inputPanel.add(labelOper);
        inputPanel.add(operCombo);

        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        outputPanel.add(resultLabel);

        historyPanel.add(historyLabel, BorderLayout.NORTH);
        historyPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(inputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(outputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(historyPanel);

        add(mainPanel);
    }

    public void limpiar() {
        textFieldNum1.setText("");
        textFieldNum2.setText("");
        operCombo.setSelectedIndex(0);
        resultLabel.setText("Resultado: ");
    }
}
