package ejmetodos;
import java.util.Scanner;
public class Ocho2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduce un número: ");
        int num = in.nextInt();
        
        int suma = suma(num);
        
        System.out.println("La suma de los dígitos es: "+suma);
    }
    public static int suma(int a){
        String s = Integer.toString(a);
        int acum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            acum += Integer.parseInt(String.valueOf(c));
            
        }
        return acum;
    }
}
