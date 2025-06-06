package gato;

public class Gato {
    private String nombre;
    private int edad;

    public Gato(String nombre, int edad) throws Exception {
        comprobarNombre(nombre);
        comprobarEdad(edad);
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) throws Exception {
        comprobarNombre(nombre);
        this.nombre = nombre;
    }

    public void setEdad(int edad) throws Exception {
        
        comprobarEdad(edad);
        this.edad = edad;
        
    }
    
    public void imprimir(){
        System.out.println("Nombre: "+nombre+"\nEdad: "+edad);
    }
    
    public void comprobarNombre(String nombre) throws Exception{
            if(nombre.length() < 3){
                throw new Exception("El nombre debe contener al menos tres caracteres.");
            }
            System.out.println("Nombre correcto.");
    }
    
    public void comprobarEdad(int edad)throws Exception{
            if (edad < 0) {
                throw new Exception("La edad no puede ser negativa.");
                
            }
            System.out.println("Edad correcta.");
    }
}
