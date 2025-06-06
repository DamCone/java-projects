
package javaapplication85;


public class humano implements NewInterface {

    protected String nombre;
    protected String dni;
    protected int edad;

    public humano() {
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the dni
     */
    @Override
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the edad
     */
    @Override
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    @Override
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "humano{" + "nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + '}';
    }

}
