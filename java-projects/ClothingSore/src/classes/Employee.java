
package classes;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
 import javafx.beans.property.SimpleStringProperty;
 import javafx.beans.property.StringProperty;

public class Employee extends User {
    private final StringProperty departamento; // Ej: "Ventas", "Almacén"
    private BooleanProperty activo; // Para la baja de empleados

    public Employee(String username, String password, String nombre, String apellidos, String email, String dni, String departamento) {
        super(username, password, nombre, apellidos, email, dni);
        this.departamento = new SimpleStringProperty(departamento);
        this.activo = new SimpleBooleanProperty(true);
    }

    public String getDepartamento() { return departamento.get(); }
    public void setDepartamento(String departamento) { this.departamento.set(departamento); }
    public StringProperty departamentoProperty() { return departamento; }

    public boolean isActivo() { return activo.get(); }
    public void setActivo(boolean activo) { this.activo.set(activo); }
    public BooleanProperty activoProperty() { return activo; }
}