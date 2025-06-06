
package ejemploexa3aeva;

public class Articulo {
    private int id;
    private String nombre;
    private float precio;
    private String codigo;
    private int grupo; // ID del grupo

    // Constructor vacío (útil para algunas librerías o frameworks)
    public Articulo() {
    }

    // Constructor con todos los campos
    public Articulo(int id, String nombre, float precio, String codigo, int grupo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.grupo = grupo;
    }

    // Constructor sin ID (para nuevos artículos antes de insertarlos en la BBDD)
    public Articulo(String nombre, float precio, String codigo, int grupo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.grupo = grupo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getGrupo() {
        return grupo;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Articulo{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", precio=" + precio +
               ", codigo='" + codigo + '\'' +
               ", grupo=" + grupo +
               '}';
    }   
}
