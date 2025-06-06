package articulo;
import java.util.regex.*;
public class Articulos {
    private String nombre;
    private float precio;
    private final static float iva = 21;
    private int cuantosQuedan;
    
    public Articulos(String nombre,float precio,int cuantosQuedan){
        this.nombre = nombre;
        this.precio = (float) precio;
        this.cuantosQuedan = cuantosQuedan;
        Pattern p = Pattern.compile("[A-Za-z]{1,20}");
        Matcher mat = p.matcher(nombre);
        if(!mat.matches() || cuantosQuedan < 0 || precio < 0){
            System.out.println("Error. El nombre es incorrecto o el número de unidades o precio es menos a 0.");
        }
        System.out.println("Articulo: ");
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public static float getIva() {
        return iva;
    }

    public int getCuantosQuedan() {
        return cuantosQuedan;
    }

    public void setCuantosQuedan(int cuantosQuedan) {
        this.cuantosQuedan = cuantosQuedan;
    }
    
    public void imprimir(){
        System.out.println("Nombre: "+nombre+"\nPrecio venta al público: "+precio+"\nStock: "+cuantosQuedan);
    }
    
    public float getPVP(){
        precio = precio * 0.21f + precio;
        return precio;
    }
    
    public float getPVPDescuento(int dsct){
        precio = precio - (precio * dsct / 100);
        return precio;
    }
    
    public boolean vender(int cV){
        boolean p = true;
        if (cuantosQuedan - cV < 0) {
            p = false;
        } else{
            cuantosQuedan -= cV;
        }
        return p;
    }
    
    public boolean almacenar(int cA){
        boolean r = true;
        if(cA > 0){
            cuantosQuedan += cA;
        } else{
            r = false;
        }
        return r;
    }
}
