package pedidopizza;
import java.util.ArrayList;
import java.util.Scanner;
public class PedidoPizza {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Scanner inS = new Scanner(System.in);
        ArrayList <Pedido> pedidos = new ArrayList<>();
        
        boolean seguir = true;
        System.out.println("Empecemos a realizar tu pedido.");
        while(seguir){
            try{
                Pedido p = new Pedido();
                System.out.print("Introduce tu nombre (no puede contener dígitos): ");
                p.setNombre(inS.nextLine());
                
                System.out.print("Introduce tus apellidos (no pueden contener dígitos): ");
                p.setApellidos(inS.nextLine());
                
                System.out.print("Introduce tu DNI: ");
                p.setDni(inS.nextLine());
                
                System.out.print("1.Provenzal \n2.Barbacoa \n3.Mediterránea \nElige pizza: ");
                p.setNombrePizza(in.nextInt());
                
                System.out.print("Introduce cantidad a pedir(del 1 al 10): ");
                p.setCantidad(in.nextInt());
                
                System.out.print("¿Quieres extras? s/n: ");
                String resp = inS.nextLine();
                if ("s".equalsIgnoreCase(resp)) {
                    int extras[] = new int[3];
                    for (int j = 0; j < extras.length; j++) {
                        System.out.print("Introduce la cantidad del ingrediente "+(j+1)+" (número entre 1 y 5): ");
                        int cantidadExtra = in.nextInt();
                        extras[j] = cantidadExtra;
                    }
                    p.setExtra(extras);
                }
                pedidos.add(p);
                
                System.out.print("¿Deseas añadir otro pedido? s/n: ");
                String respuesta = inS.nextLine();
                if(!"s".equalsIgnoreCase(respuesta)){
                    int s = 1;
                    for (Pedido x : pedidos) {
                        System.out.println("Información pedido "+s+": ");
                        x.imprimirPedido(x);
                        s++;
                    }
                    seguir = false;
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }   
    }
}
