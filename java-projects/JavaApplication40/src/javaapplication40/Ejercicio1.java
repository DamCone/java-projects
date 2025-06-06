package Excepciones;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author : EVA MARÍA GÓMEZ ABAD
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("Introduce un valor entero: ");
            int num = entrada.nextInt(); // Solicita un número entero al usuario
            System.out.println("Valor introducido: " + num);
        } catch (InputMismatchException e) {
            System.out.println("Valor introducido incorrecto");
            e.printStackTrace(); // Muestra la pila de llamadas
        } finally {
            entrada.close(); // Cierra el Scanner para liberar recursos
        }
    }
}


