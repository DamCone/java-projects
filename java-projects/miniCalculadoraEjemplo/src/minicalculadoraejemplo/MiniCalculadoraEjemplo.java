
package minicalculadoraejemplo;

/**
 * La clase {@code OperacionesMatematicas} proporciona métodos estáticos
 * para realizar operaciones matemáticas básicas como valor absoluto,
 * raíz cuadrada, potenciación y redondeo hacia abajo.
 *
 * <p>Todos los métodos usan la biblioteca estándar {@code java.lang.Math}.
 */

public class MiniCalculadoraEjemplo {
    /**
 * Constructor por defecto. No realiza ninguna acción.
 */
public MiniCalculadoraEjemplo() {
}

    /**
    * Método principal para probar las operaciones matemáticas.
    *
    * @param args argumentos de la línea de comandos (no se utilizan)
    */
    public static void main(String[] args) {
        System.out.println("Abs(-5.7): " + valorAbsoluto(-5.7));
        System.out.println("Raíz(25): " + raizCuadrada(25));
        System.out.println("2^3: " + elevaBaseExponente(2, 3));
        System.out.println("Floor(3.9): " + enteroMenorOIgual(3.9));
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            // manejamos el error
        }
    
    }
    
    /**
    * Devuelve el valor absoluto del número.
    * @param num el número a evaluar
    * @return valor absoluto
    */
    public static double valorAbsoluto(double num){
        return Math.abs(num);
    }
    
    /**
    * Devuelve la raiz cuadrada del número.
    * @param num el número a evaluar
    * @return raiz cuadrada
    */
    public static double raizCuadrada(double num){
        return Math.sqrt(num);
    }
    
     /**
    * Eleva la base al exponente.
    * @param base el primer número a evaluar
    * @param exp el segundo número a evaluar
    * @return base elevado a exponente
    */
    public static double elevaBaseExponente(double base, double exp){
        return Math.pow(base, exp);
    }
    
    /**
    * Devuelve el número entero mas pequeño o igual aproximado.
    * @param num el número a evaluar
    * @return el número entero mas pequeño.
    */
    public static int enteroMenorOIgual(double num) {
        return (int) Math.floor(num);
    }
}
