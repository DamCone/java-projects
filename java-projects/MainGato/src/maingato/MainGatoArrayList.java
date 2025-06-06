package maingato;

/**
 *
 * @author : EVA MAR�A G�MEZ ABAD
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MainGatoArrayList {
   public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Gato> listaGatos = new ArrayList<>(); // Lista para almacenar objetos Gato

        System.out.println("Introduce los datos de 5 gatos.");

        while (listaGatos.size() < 5) { // Repetir hasta almacenar 5 gatos v�lidos
            try {
                // Pedir los datos del gato
                System.out.print("Introduce el nombre del gato: ");
                String nombre = entrada.nextLine();

                System.out.print("Introduce la edad del gato: ");
                int edad = entrada.nextInt();
                entrada.nextLine(); // Limpiar el buffer del Scanner

                // Intentar crear un objeto Gato
                Gato gato = new Gato(nombre, edad);

                // Si no hay excepciones, a�adir el gato a la lista
                listaGatos.add(gato);
                System.out.println("Gato a�adido correctamente.\n");

            } catch (Exception e) {
                // Manejar cualquier excepci�n lanzada por el constructor o setters
                System.out.println("Error al crear el gato: " + e.getMessage());
                e.printStackTrace();
                System.out.println("Por favor, introduce los datos nuevamente.\n");
            }
        }

        // Imprimir la informaci�n de los gatos almacenados en la lista
        System.out.println("\nInformaci�n de los gatos almacenados:");
        for (int i = 0; i < listaGatos.size(); i++) {
            System.out.print("Gato " + (i + 1) + ": ");
            listaGatos.get(i).imprimir();
        }

        entrada.close();
    }
}
