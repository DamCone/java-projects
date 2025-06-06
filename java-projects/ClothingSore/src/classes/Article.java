
package classes;
import javafx.beans.property.*;
import java.io.Serializable; // Importante para guardar/cargar objetos

public abstract class Article implements Serializable {
    // Usamos Properties para el binding con JavaFX
    private final StringProperty id; // Identificador único (ej: REF001)
    private final StringProperty nombre;
    private final StringProperty descripcion;
    private final DoubleProperty precio;
    private final BooleanProperty activo; // Para marcar como no activo (baja lógica)

    // Constructor
    public Article(String id, String nombre, String descripcion, double precio) {
        this.id = new SimpleStringProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.precio = new SimpleDoubleProperty(precio);
        this.activo = new SimpleBooleanProperty(true); // Por defecto activo
    }

    // --- Getters para los valores ---
    public String getId() { return id.get(); }
    public String getNombre() { return nombre.get(); }
    public String getDescripcion() { return descripcion.get(); }
    public double getPrecio() { return precio.get(); }
    public boolean isActivo() { return activo.get(); }

    // --- Setters (solo para propiedades modificables) ---
    public void setPrecio(double precio) { this.precio.set(precio); }
    public void setActivo(boolean activo) { this.activo.set(activo); }
    public void setNombre(String nombre) { this.nombre.set(nombre); }
    public void setDescripcion(String descripcion) { this.descripcion.set(descripcion); }


    // --- Getters para las Properties (necesarios para JavaFX TableView/Binding) ---
    public StringProperty idProperty() { return id; }
    public StringProperty nombreProperty() { return nombre; }
    public StringProperty descripcionProperty() { return descripcion; }
    public DoubleProperty precioProperty() { return precio; }
    public BooleanProperty activoProperty() { return activo; }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Nombre: " + getNombre() + ", Precio: " + getPrecio();
    }
}