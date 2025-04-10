public class PruebasCalculadora {  
    public static void main(String[] args) {  
        System.out.println("=== Pruebas Básicas ===");  
        probarOperacionesBasicas();  
        probarPotencia();  
        probarDivisionPorCero();  
    }  

    public static void probarOperacionesBasicas() {  
        CalculadoraSimple calculadora = new CalculadoraSimple("Pruebas");  
        System.out.println("2 + 3 = " + calculadora.calcular(2, 3, "Suma"));  
        System.out.println("2 - 3 = " + calculadora.calcular(2, 3, "Resta"));  
        System.out.println("2 * 3 = " + calculadora.calcular(2, 3, "Multiplicación"));  
        System.out.println("6 / 3 = " + calculadora.calcular(6, 3, "División"));  
    }  

    public static void probarPotencia() {  
        CalculadoraAvanzada calculadora = new CalculadoraAvanzada("Pruebas");  
        System.out.println("2 ^ 3 = " + calculadora.calcular(2, 3, "Potencia"));  
    }  

    public static void probarDivisionPorCero() {  
        CalculadoraSimple calculadora = new CalculadoraSimple("Pruebas");  
        try {  
            calculadora.calcular(6, 0, "División");  
        } catch (ArithmeticException e) {  
            System.out.println("Error esperado: " + e.getMessage());  
        }  
    }  
}  
