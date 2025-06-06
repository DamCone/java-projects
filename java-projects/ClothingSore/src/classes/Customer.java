
package classes;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDate;
// Podría tener una lista de pedidos asociados

public class Customer extends User {
    private final ObjectProperty<LocalDate> fechaRegistro;

    public Customer(String username, String password, String nombre, String apellidos, String email, String dni) {
        super(username, password, nombre, apellidos, email, dni);
        this.fechaRegistro = new SimpleObjectProperty<>(LocalDate.now());
    }

    public LocalDate getFechaRegistro() { return fechaRegistro.get(); }
    public ObjectProperty<LocalDate> fechaRegistroProperty() { return fechaRegistro; }
    // No hay setter para fechaRegistro si es la fecha de creación
}