package ejmetodos;
import java.util.Scanner;
public class Millas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double millas;
        
        System.out.println("Introduce las millas: ");
        millas = in.nextDouble();
        
        conver(millas);
    }
    public static double conver(double a){
        double b = a * 1609.344;
        System.out.println(a +" millas es igual a "+ b +" metros");
        return a;
    }
}
