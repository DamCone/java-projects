
package classes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Accessories extends Article {
    private final StringProperty material;
    private final StringProperty marca;

    public Accessories(String id, String nombre, String descripcion, double precio, String material, String marca) {
        super(id, nombre, descripcion, precio);
        this.material = new SimpleStringProperty(material);
        this.marca = new SimpleStringProperty(marca);
    }

    public String getMaterial() { return material.get(); }
    public void setMaterial(String material) { this.material.set(material); }
    public StringProperty materialProperty() { return material; }

    public String getMarca() { return marca.get(); }
    public void setMarca(String marca) { this.marca.set(marca); }
    public StringProperty marcaProperty() { return marca; }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + getMaterial() + ", Marca: " + getMarca();
    }
}