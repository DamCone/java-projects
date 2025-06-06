package ejmetodos;
import java.util.Scanner;
public class Cuatro {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int año;
        
        System.out.print("Introduce el año: ");
        año = in.nextInt();
        
        System.out.println(domingo(año));
    }
    public static String domingo(int año){
        String dr = "";
        int b = 15 + ((19*(año % 19) + 24) % 30) + ((2*(año % 4)) + (4*(año % 7)) + (6*((19*(año % 19) + 24) % 30) + 5)) % 7;
        
        if (b > 31){
            dr = (b - 31) + " de abril";
        } else {
            dr = b + "de marzo";
        }
        return dr;
    }
}
