
package javaapplication85;

public class persona extends humano {

    /**
     * @return the nombre
     */
    
    
    public persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "persona{" + '}';
    }

    
}
