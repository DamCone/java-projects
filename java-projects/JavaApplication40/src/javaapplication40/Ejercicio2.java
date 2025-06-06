
package Excepciones;

/**
 *
 * @author : EVA MARÍA GÓMEZ ABAD
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("Introduce el primer valor entero (num1): ");
            int num1 = entrada.nextInt(); // Solicita el primer número entero

            System.out.print("Introduce el segundo valor entero (num2): ");
            int num2 = entrada.nextInt(); // Solicita el segundo número entero

            int resultado = num1 / num2; // Realiza la división
            System.out.println("El resultado de " + num1 + " / " + num2 + " es: " + resultado);

        } catch (InputMismatchException e) {
            System.out.println("Error: Uno o ambos valores introducidos no son enteros.");
            e.printStackTrace(); // Muestra la pila de llamadas

        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero no permitida.");
            e.printStackTrace(); // Muestra la pila de llamadas

        } finally {
            entrada.close(); // Cierra el Scanner para liberar recursos
        }
    }
}
