package ejmetodos;
import java.util.Scanner;
public class Descuento {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double tarifa, pagado;
        
        System.out.print("Introduce la tarifa del producto: ");
        tarifa = in.nextDouble();
        
        System.out.print("Introduce lo que has pagado: ");
        pagado = in.nextDouble();
        
        desc(tarifa, pagado);
    }
    public static double desc(double a, double b){
        double c = 100 - ((b/a) * 100);
        System.out.println("Eldescuento realizado es del "+ c +"%");
        return c;
    }
    
    
}
