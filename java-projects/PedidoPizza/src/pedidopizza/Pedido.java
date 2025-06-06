
package pedidopizza;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pedido {
    private String nombre;
    private String apellidos;
    private String dni;
    private int nombrePizza;
    private int cantidad;
    private int extra[] = new int[3];

    public Pedido(String nombre, String apellidos, String dni, int cantidad, int nombrePizza) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.cantidad = cantidad;
        this.nombrePizza = nombrePizza;
    }

    public Pedido() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) throws Exception{
        Pattern pat = Pattern.compile("[a-zA-Z]{3,20}");
        Matcher mat = pat.matcher(nombre);
        if (!mat.matches()) {
            throw new Exception("El nombre no puede contener dígitos o ser menor a 3 carácteres.");
        }
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) throws Exception{
        Pattern pat = Pattern.compile("[a-zA-Z]{3,40}");
        Matcher mat = pat.matcher(nombre);
        if (!mat.matches()) {
            throw new Exception("Los apellidos no pueden contener dígitos o ser menor a 3 carácteres.");
        }
        this.apellidos = apellidos;
    }

    public void setDni(String dni) throws Exception{
        Pattern pat = Pattern.compile("^\\d{8}[A-HJ-NP-TV-Z]$");
        Matcher mat = pat.matcher(dni);
        if (!mat.matches()) {
            throw new Exception("El dni debe contener 8 dígitos y una letra mayuscula al final.");
        }   
        this.dni = dni;
    }

    public int getNombrePizza() {
        return nombrePizza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int[] getExtra() {
        return extra;
    }

    public void setNombrePizza(int nombre) throws Exception{
        if(nombre < 1 || nombre > 3){
            throw new Exception("Debes introducir 1, 2 o 3"); 
        }
        this.nombrePizza = nombre;
    }

    public void setCantidad(int cantidad) throws Exception{
        if (cantidad > 10 || cantidad < 1){
            throw new Exception("La cantidad mínima es 1 y la máxima 10.");
        }
        this.cantidad = cantidad;
    }

    public void setExtra(int[] extra) throws Exception{
        for (int i = 0; i < 3; i++) {
            if ((extra[i] < 1 || extra[i] > 5)) {
                throw new Exception("La cantidad de cada ingrediente debe ser mínimo 1 y máximo 5.");
            }
        }
        this.extra = extra;
    }
    
    public void imprimirPedido(Pedido p){
        System.out.println("Nombre: "+p.nombre);
        System.out.println("Apellidos: "+p.apellidos);
        System.out.println("Dni: "+p.dni);
        System.out.println("Nombre Pizza: "+p.nombrePizza);
        if (p.extra != null) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Ingredientes extra nº"+i+": "+p.extra[i]);
            }
        } else{
            System.out.println("No hay extras.");
        }
    }
}
