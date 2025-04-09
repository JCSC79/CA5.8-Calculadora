public class CalculadoraAvanzada extends CalculadoraSimple {  

    public CalculadoraAvanzada(String title) {  
        super(title);  
        operCombo.addItem("Potencia"); // Añade operación avanzada  
    }  

    @Override  
    protected double calcular(double num1, double num2, String operacion) {  
        if ("Potencia".equals(operacion)) {  
            return Math.pow(num1, num2);  
        }  
        // Delega operaciones básicas a CalculadoraSimple  
        return super.calcular(num1, num2, operacion);  
    }  
}  
