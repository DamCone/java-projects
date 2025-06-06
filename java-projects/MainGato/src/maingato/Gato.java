
package maingato;

/**
 *
 * @author : EVA MAR�A G�MEZ ABAD
 */
// Clase Gato
public class Gato {
    private String nombre;
    private int edad;

    // Constructor con par�metros
    public Gato(String nombre, int edad) throws Exception {
        setNombre(nombre); // Valida y asigna el nombre
        setEdad(edad);     // Valida y asigna la edad
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para el nombre con validaci�n
    public void setNombre(String nombre) throws Exception {
        if (nombre == null || nombre.length() < 3) {
            throw new Exception("Error: El nombre debe tener al menos 3 caracteres.");
        }
        this.nombre = nombre;
    }

    // Getter para la edad
    public int getEdad() {
        return edad;
    }

    // Setter para la edad con validaci�n
    public void setEdad(int edad) throws Exception {
        if (edad < 0) {
            throw new Exception("Error: La edad no puede ser negativa.");
        }
        this.edad = edad;
    }

    // M�todo imprimir() para mostrar los datos del gato
    public void imprimir() {
        System.out.println("Gato [Nombre: " + nombre + ", Edad: " + edad + "]");
    }
}
