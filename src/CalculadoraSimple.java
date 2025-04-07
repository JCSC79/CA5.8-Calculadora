/**
 * Clase que implementa una calculadora simple con operaciones básicas.
 */
public class CalculadoraSimple extends CalculadoraBase {
    public CalculadoraSimple(String title) {
        super(title);

        String[] operacionesBasicas = { "Suma", "Resta", "Multiplicación", "División" };
        for (String operacion : operacionesBasicas) {
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
}
