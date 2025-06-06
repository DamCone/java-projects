
package Excepciones;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author : EVA MARÍA GÓMEZ ABAD
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner entrada = new Scanner(System.in);

        // Generar un tamaño aleatorio para el vector entre 1 y 100
        int N = random.nextInt(100) + 1;
        int[] vector = new int[N];

        // Rellenar el vector con valores aleatorios entre 1 y 10
        for (int i = 0; i < N; i++) {
            vector[i] = random.nextInt(10) + 1;
        }

        System.out.println("Se ha creado un vector de tamaño " + N + " con valores aleatorios entre 1 y 10.");
        System.out.println("Introduce la posición del vector que quieres mostrar (introduce un valor negativo para salir):");

        boolean continuar = true; // Variable de control para el bucle

        while (continuar) {
            try {
                System.out.print("Posición: ");
                int posicion = entrada.nextInt(); // Leer la posición introducida por el usuario

                if (posicion < 0) { // Salir si el usuario introduce un valor negativo
                    System.out.println("Saliendo del programa...");
                    continuar = false; // Cambiar la variable de control para salir del bucle
                } else {
                    // Mostrar el valor en la posición indicada
                    System.out.println("El valor en la posición " + posicion + " es: " + vector[posicion]);
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: La posición introducida está fuera del rango del vector (0 a " + (N - 1) + ").");
                e.printStackTrace(); // Mostrar la pila de llamadas

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero.");
                e.printStackTrace(); // Mostrar la pila de llamadas
                entrada.nextLine(); // Limpiar el buffer del Scanner para evitar bucles infinitos
            }
        }

        entrada.close(); // Cerrar el Scanner
    }
}
