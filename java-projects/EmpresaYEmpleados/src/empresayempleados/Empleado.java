package empresayempleados;
public class Empleado {
    private final String nombre;
    private final String dni;
    private float sueldo;
    private int edad;
    private String telefono;
    private String direccion;

    public Empleado(String nombre, String dni, float sueldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldo = sueldo;
    }
    public Empleado(String nombre, String dni, float sueldo, int edad, String telefono, String direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldo = sueldo;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public void imprimir(){
        System.out.println("Nombre: "+nombre+"\nDNI: "+dni+"\nSueldo: "+sueldo);
        if (edad != 0){
            System.out.println("Edad: "+edad+"\nTelefono: "+telefono+"\nDirección: "+direccion);
        }
    }
    public float calcularNeto (){
        float sb = sueldo * 12;
        float neto = 0;
        if (sb < 12000) {
            neto = sb * 0.80f;
        } else if (sb >= 12000 && sb <= 25000) {
            neto = sb * 0.70f;
        } else {
            neto = sb * 0.60f;
        }
        return neto / 12;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public float getSueldo() {
        return sueldo;
    }
    
}
