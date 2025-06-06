package classes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Clothes extends Article {
    private final StringProperty talla;
    private final StringProperty color;

    public Clothes(String id, String nombre, String descripcion, double precio, String talla, String color) {
        super(id, nombre, descripcion, precio);
        this.talla = new SimpleStringProperty(talla);
        this.color = new SimpleStringProperty(color);
    }

    public String getTalla() { return talla.get(); }
    public void setTalla(String talla) { this.talla.set(talla); }
    public StringProperty tallaProperty() { return talla; }

    public String getColor() { return color.get(); }
    public void setColor(String color) { this.color.set(color); }
    public StringProperty colorProperty() { return color; }

     @Override
    public String toString() {
         return super.toString() + ", Talla: " + getTalla() + ", Color: " + getColor();
     }
}