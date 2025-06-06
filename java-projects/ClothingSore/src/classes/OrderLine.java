
package classes;

import javafx.beans.property.*;
import java.io.Serializable;

public class OrderLine implements Serializable {
    private final ObjectProperty<Article> articulo;
    private final IntegerProperty cantidad;
    private final DoubleProperty precioUnitarioEnPedido; // Precio al momento de añadir al carrito
    private final DoubleProperty precioTotalLinea;

    public OrderLine(Article articulo, int cantidad) {
        this.articulo = new SimpleObjectProperty<>(articulo);
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.precioUnitarioEnPedido = new SimpleDoubleProperty(articulo.getPrecio());
        this.precioTotalLinea = new SimpleDoubleProperty();
        // Calcular total linea y añadir listener a cantidad
        calcularTotalLinea();
        this.cantidad.addListener((obs, oldVal, newVal) -> calcularTotalLinea());
    }

    private void calcularTotalLinea() {
        this.precioTotalLinea.set(getPrecioUnitarioEnPedido() * getCantidad());
    }

    // --- Getters y Setters ---
    public Article getArticulo() { return articulo.get(); }
    public ObjectProperty<Article> articuloProperty() { return articulo; }

    public int getCantidad() { return cantidad.get(); }
    public void setCantidad(int cantidad) { this.cantidad.set(cantidad); }
    public IntegerProperty cantidadProperty() { return cantidad; }

    public double getPrecioUnitarioEnPedido() { return precioUnitarioEnPedido.get(); }
    public DoubleProperty precioUnitarioEnPedidoProperty() { return precioUnitarioEnPedido; }

    public double getPrecioTotalLinea() { return precioTotalLinea.get(); }
    public ReadOnlyDoubleProperty precioTotalLineaProperty() { return precioTotalLinea; } // ReadOnly
}