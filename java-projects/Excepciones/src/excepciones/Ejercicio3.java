package Excepciones;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author : EVA MARÍA GÓMEZ ABAD
 */


public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double[] vector = new double[5]; // Crea un vector de tamaño 5
        int index = 0; // Índice para controlar la posición en el vector

        System.out.println("Introduce 5 valores tipo double para rellenar el vector:");

        while (index < vector.length) { // Sigue pidiendo valores hasta rellenar el vector
            try {
                System.out.print("Introduce un valor para la posición " + index + ": ");
                vector[index] = entrada.nextDouble(); // Intenta leer un número tipo double
                index++; // Avanza al siguiente índice si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Error: El valor introducido no es válido. Por favor, introduce un número tipo double.");
                e.printStackTrace(); // Muestra la pila de llamadas
                entrada.nextLine(); // Limpia el buffer del Scanner para evitar un bucle infinito
            }
        }

        entrada.close(); // Cierra el Scanner

        // Muestra los valores introducidos en el vector
        System.out.println("Vector rellenado con los siguientes valores:");
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Posición " + i + ": " + vector[i]);
        }
    }
}
