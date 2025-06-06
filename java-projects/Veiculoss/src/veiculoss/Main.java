package veiculoss;

/**
 *
 * @author : EVA MAR�A G�MEZ ABAD
 */
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Crear una lista de veh�culos
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        vehiculos.add(new Coche("1234ABC", "Toyota", 50));
        vehiculos.add(new Moto("5678DEF", "Yamaha", 40));
        vehiculos.add(new Bicicleta("0000XYZ", "Orbea", 10));

        // Mostrar informaci�n inicial de los veh�culos
        System.out.println("Informaci�n inicial de los veh�culos:");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println(vehiculos.get(i));
        }

        // Simular aceleraci�n para cada veh�culo
        System.out.println("\nSimulando aceleraci�n...");
        for (int i = 0; i < vehiculos.size(); i++) {
            vehiculos.get(i).acelerar();
            System.out.println(vehiculos.get(i));
        }

        // Simular frenado para cada veh�culo
        System.out.println("\nSimulando frenado...");
        for (int i = 0; i < vehiculos.size(); i++) {
            vehiculos.get(i).frenar();
            System.out.println(vehiculos.get(i));
        }
    }
}



