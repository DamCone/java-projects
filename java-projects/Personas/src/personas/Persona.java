
package personas;
public class Persona {
    private String nombre;
    private int edad;
    private String dni;

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    
    public String toString(){
        return "Nombre: "+nombre+", Edad: "+edad+"Dni: "+dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
}
