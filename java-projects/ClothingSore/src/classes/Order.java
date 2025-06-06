
package classes;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable {
    private final IntegerProperty id; // Autogenerado o gestionado externamente
    private final ObjectProperty<Customer> cliente;
    private final ObjectProperty<LocalDate> fecha;
    // Usamos ListProperty con ObservableList para la tabla/binding
    private final ListProperty<OrderLine> lineasPedido;
    private final DoubleProperty subtotal; // Suma de lineas
    private final DoubleProperty totalPedido; // Podría incluir IVA, descuentos, etc.
    private final StringProperty estado; // Ej: "Pendiente", "Enviado", "Entregado"

    public Order(int id, Customer cliente) {
        this.id = new SimpleIntegerProperty(id);
        this.cliente = new SimpleObjectProperty<>(cliente);
        this.fecha = new SimpleObjectProperty<>(LocalDate.now());
        // Inicializar la ListProperty con una ObservableList
        this.lineasPedido = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.subtotal = new SimpleDoubleProperty(0);
        this.totalPedido = new SimpleDoubleProperty(0);
        this.estado = new SimpleStringProperty("Pending");

        // Listener para recalcular totales cuando cambian las líneas
        this.lineasPedido.addListener((ListChangeListener<OrderLine>) c -> calcularTotales());
    }

    public void anadirLinea(OrderLine linea) {
        lineasPedido.add(linea);
        // El listener recalculará
    }

     public void eliminarLinea(OrderLine linea) {
         lineasPedido.remove(linea);
         // El listener recalculará
     }


    private void calcularTotales() {
        double sub = 0;
        for (OrderLine linea : lineasPedido) {
            sub += linea.getPrecioTotalLinea();
        }
        this.subtotal.set(sub);
        // Aquí podrías añadir lógica de IVA, descuentos...
        this.totalPedido.set(sub); // Simplificado por ahora
    }

    // --- Getters y Setters ---
    public int getId() { return id.get(); }
    public IntegerProperty idProperty() { return id; }

    public Customer getCliente() { return cliente.get(); }
    public ObjectProperty<Customer> clienteProperty() { return cliente; }

    public LocalDate getFecha() { return fecha.get(); }
    public ObjectProperty<LocalDate> fechaProperty() { return fecha; }

    // Para obtener la lista observable directamente
    public ObservableList<OrderLine> getLineasPedido() { return lineasPedido.get(); }
    public ListProperty<OrderLine> lineasPedidoProperty() { return lineasPedido; }

    public double getSubtotal() { return subtotal.get(); }
    public ReadOnlyDoubleProperty subtotalProperty() { return subtotal; } // ReadOnly

    public double getTotalPedido() { return totalPedido.get(); }
    public ReadOnlyDoubleProperty totalPedidoProperty() { return totalPedido; } // ReadOnly

    public String getEstado() { return estado.get(); }
    public void setEstado(String estado) { this.estado.set(estado); }
    public StringProperty estadoProperty() { return estado; }
}