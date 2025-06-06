
package classes;

import javafx.beans.property.*;
import java.io.Serializable;

public abstract class User implements Serializable {
    private final StringProperty username; // Identificador para login
    private StringProperty password; // ¡Cuidado con almacenar passwords en texto plano!
    private StringProperty nombre;
    private StringProperty apellidos;
    private StringProperty email;
    private StringProperty dni;
    // Podrías añadir más: direccion, telefono, etc.

    public User(String username, String password, String nombre, String apellidos, String email, String dni) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password); // Considerar hashing
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.email = new SimpleStringProperty(email);
        this.dni = new SimpleStringProperty(dni);
    }

    // --- Getters y Setters (para valores y properties) ---
    public String getUsername() { return username.get(); }
    public StringProperty usernameProperty() { return username; }

    public String getPassword() { return password.get(); }
    public void setPassword(String password) { this.password.set(password); } // Considerar hashing al setear
    public StringProperty passwordProperty() { return password; }

    public String getNombre() { return nombre.get(); }
    public void setNombre(String nombre) { this.nombre.set(nombre); }
    public StringProperty nombreProperty() { return nombre; }

    public String getApellidos() { return apellidos.get(); }
    public void setApellidos(String apellidos) { this.apellidos.set(apellidos); }
    public StringProperty apellidosProperty() { return apellidos; }

    public String getEmail() { return email.get(); }
    public void setEmail(String email) { this.email.set(email); }
    public StringProperty emailProperty() { return email; }

    public String getDni() { return dni.get(); }
     // DNI no debería cambiar una vez creado, quizás hacerlo final
    public StringProperty dniProperty() { return dni; }


    @Override
    public String toString() {
        return "Username: " + getUsername() + ", Nombre: " + getNombre() + " " + getApellidos();
    }
}