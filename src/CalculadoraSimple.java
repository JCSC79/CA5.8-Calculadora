/**
 * Clase que implementa una calculadora simple con operaciones básicas.
 * 
 * NOTA: Ahora incluye un método calcular() protegido para permitir
 * la sobrescritura en subclases (CA7.4)
 */
public class CalculadoraSimple extends CalculadoraBase {
    public CalculadoraSimple(String title) {
        super(title);

        String[] operacionesBasicas = { "Suma", "Resta", "Multiplicación", "División" };
        for (String operacion : operacionesBasicas) {
            operCombo.addItem(operacion);
        }

        calculateButton.addActionListener(e -> ejecutarCalculo());
        clearButton.addActionListener(e -> limpiar());
    }

    // Método clave para la herencia (protected)
    protected double calcular(double num1, double num2, String operacion) {
        return switch (operacion) {
            case "Suma" -> num1 + num2;
            case "Resta" -> num1 - num2;
            case "Multiplicación" -> num1 * num2;
            case "División" -> {
                if (num2 == 0) throw new ArithmeticException("División entre cero no permitida.");
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Operación no soportada");
        };
    }

    // Método encapsulado para manejar la lógica
    private void ejecutarCalculo() {
        try {
            double num1 = Double.parseDouble(textFieldNum1.getText());
            double num2 = Double.parseDouble(textFieldNum2.getText());
            String oper = (String) operCombo.getSelectedItem();
            
            double resultado = calcular(num1, num2, oper);
            
            resultLabel.setText("Resultado: " + resultado);
            historial.add(num1 + " " + oper + " " + num2 + " = " + resultado);
            historyArea.setText(String.join("\n", historial));

        } catch (Exception ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }
}
