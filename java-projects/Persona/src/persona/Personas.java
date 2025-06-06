package persona;
public class Personas {
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    
    public Personas(String dni, String nombre, String apellidos, int edad){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void imprime(){
        System.out.println("Dni: "+dni+"\nNombre: "+nombre+"\nApellidos: "+apellidos+"\nEdad: "+edad);
    }
    
    public boolean esMayorEdad(){
        boolean m = true;
        if(edad < 18){
            m = false;
        }
        return m;
    }
    
    public boolean esJubilado(){
        boolean j = true;
        if(edad < 65){
            j = false;
        }
        return j;
    }
    
    public int diferenciaEdad(Personas p){
        return this.edad - p.edad;
    }
}
