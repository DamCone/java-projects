/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Excepciones;

/**
 *
 * @author : EVA MARÍA GÓMEZ ABAD
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {

    // Función que imprime un número positivo y lanza una excepción si es negativo
    public static void imprimePositivo(int p) throws Exception {
        if (p < 0) {
            throw new Exception("Error: El valor " + p + " no es positivo.");
        }
        System.out.println("Valor positivo: " + p);
    }

    // Función que imprime un número negativo y lanza una excepción si es positivo o cero
    public static void imprimeNegativo(int n) throws Exception {
        if (n >= 0) {
            throw new Exception("Error: El valor " + n + " no es negativo.");
        }
        System.out.println("Valor negativo: " + n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("Introduce valores enteros. Se comprobará si son positivos o negativos.");
        System.out.println("Introduce un valor no entero para salir.");

        while (continuar) {
            try {
                System.out.print("Introduce un número entero: ");
                int valor = scanner.nextInt(); // Leer el valor introducido por el usuario

                // Llamar a las funciones según el signo del número
                if (valor >= 0) {
                    imprimePositivo(valor); // Llama a imprimePositivo si el valor es positivo o cero
                } else {
                    imprimeNegativo(valor); // Llama a imprimeNegativo si el valor es negativo
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Saliendo del programa...");
                continuar = false; // Salir del bucle si no se introduce un número entero

            } catch (Exception e) {
                System.out.println(e.getMessage()); // Imprimir el mensaje de la excepción lanzada
                e.printStackTrace(); // Mostrar la pila de llamadas para depuración
            } finally {
                scanner.nextLine(); // Limpiar el buffer del Scanner para evitar problemas en el bucle
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}

