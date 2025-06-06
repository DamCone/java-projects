package ejmetodos;
import java.util.Scanner;
public class Uno2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduce el valor de un ángulo: ");
        double a = in.nextDouble();
        
        calcular(a);
    }
    public static void calcular(double a){
        double radianes = Math.toRadians(a);
        double s = Math.sin(radianes);
        double c = Math.cos(radianes);
        double t = Math.tan(radianes);
        
        System.out.println("Seno: "+ s);
        System.out.println("Coseno: "+ c);
        System.out.println("Tangente: "+ t);
    }
}
