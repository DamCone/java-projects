
package classes;

public class Administrator extends User {
    // Podría tener niveles de permiso u otros datos específicos
    public Administrator(String username, String password, String nombre, String apellidos, String email, String dni) {
        super(username, password, nombre, apellidos, email, dni);
    }
    // Atributos, getters, setters, properties específicos si los hay
}