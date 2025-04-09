import javax.swing.SwingUtilities;

/**
 * Punto de entrada principal del programa.
 * Crea y muestra la instancia de la calculadora avanzada.
 */
public class Calculadora {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Usa CalculadoraAvanzada (hereda de CalculadoraSimple)
            CalculadoraAvanzada calculadora = new CalculadoraAvanzada("Calculadora Avanzada");
            calculadora.setVisible(true);
        });
    }
}
