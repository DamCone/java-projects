package articulo;
import java.util.Scanner;
public class Articulo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduce el nombre: ");
        String nombre= in.nextLine();
        
        System.out.print("Introduce el precio: ");
        float precio= in.nextFloat();
        
        System.out.print("Introduce la cantidad en stock: ");
        int cuantosQuedan = in.nextInt();
        
        Articulos a1 = new Articulos(nombre, precio, cuantosQuedan);
        
        a1.getPVP();
        
        a1.imprimir();
        
        System.out.print("Añada un descuento en porcentaje o 0 si no hay descuento: ");
        int desc = in.nextInt();
        
        System.out.println("Precio del artículo tras aplicar descuento: "+ a1.getPVPDescuento(desc));
        
        System.out.print("Cantidad a vender: ");
        boolean v = a1.vender(in.nextInt());
        
        if (!v){
            System.out.println("Has intentado vender mas productos de los que quedan, por lo que el stock no cambiará.");
        }
        
        System.out.print("Cantidad a almacenar: ");
        boolean a = a1.almacenar(in.nextInt());
        
        if (!a){
            System.out.println("La cantidad para almacenar debe ser mayor a 0, por lo que no has almacenado nada.");
        }
        System.out.println("Articulo tras los cambios:");
        a1.imprimir();
    }
}
