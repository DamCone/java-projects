package ejarrays1;
import java.util.Scanner;
public class Media {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num[]= new int[20];
        int suma = 0;
        int media = 0;
        for (int i = 0; i < num.length; i++) {
            System.out.println("Introduce el número de la posición " + (i+1));
            num[i] = in.nextInt();
            suma += num[i];
        }
        media = suma/num.length;
        System.out.println("La media de los números es: "+ media);
    }
    
}
