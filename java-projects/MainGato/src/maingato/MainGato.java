
package maingato;

/**
 *
 * @author : EVA MAR�A G�MEZ ABAD
 */

import java.util.Scanner;

public class MainGato {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            // Crear objetos Gato v�lidos
            Gato gato1 = new Gato("Milo", 2);
            Gato gato2 = new Gato("Luna", 5);

            // Imprimir los datos de los gatos creados
            gato1.imprimir();
            gato2.imprimir();

            // Probar setters con valores v�lidos e inv�lidos
            System.out.println("\nActualizando datos del gato1...");
            gato1.setNombre("Simba");
            gato1.setEdad(3);
            gato1.imprimir();

            System.out.println("\nIntentando asignar valores inv�lidos...");
            try {
                gato1.setNombre("Pepe"); // Nombre inv�lido (menos de 3 caracteres)
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            try {
                gato1.setEdad(-1); // Edad inv�lida (negativa)
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            // Crear un objeto Gato con valores inv�lidos (se lanza excepci�n en el constructor)
            System.out.println("\nIntentando crear un gato con valores inv�lidos...");
            try {
                Gato gatoInvalido = new Gato("Mi", -2);//Aqui pongo nombre y edad invalidos
                gatoInvalido.imprimir();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("Error al crear o modificar un objeto Gato: " + e.getMessage());
        } finally {
            entrada.close();
        }

        System.out.println("\nPrograma finalizado.");
    }
}
