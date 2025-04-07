import javax.swing.SwingUtilities;
/**
 * Clase principal que implementa una calculadora avanzada con operaciones adicionales.
 */
public class Calculadora extends CalculadoraBase {
    public Calculadora(String title) {
        super(title);

        String[] operacionesAvanzadas = { "Suma", "Resta", "Multiplicación", "División", "Potencia" };
        for (String operacion : operacionesAvanzadas) {
            operCombo.addItem(operacion);
        }

        calculateButton.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(textFieldNum1.getText());
                double num2 = Double.parseDouble(textFieldNum2.getText());
                String oper = (String) operCombo.getSelectedItem();
                double resultado = 0;

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
                            throw new ArithmeticException("División entre cero no permitida.");
                        }
                        resultado = num1 / num2;
                        break;
                    case "Potencia":
                        resultado = Math.pow(num1, num2);
                        break;
                }

                resultLabel.setText("Resultado: " + resultado);
                historial.add(num1 + " " + oper + " " + num2 + " = " + resultado);
                historyArea.setText(String.join("\n", historial));

            } catch (Exception ex) {
                resultLabel.setText("Error: Entrada inválida.");
            }
        });

        clearButton.addActionListener(e -> limpiar());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora calculadoraAvanzada = new Calculadora("Calculadora Avanzada");
            calculadoraAvanzada.setVisible(true);
        });
    }
}
