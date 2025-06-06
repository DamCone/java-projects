
package ejarrays1;
import java.util.Scanner;
public class Suma {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num[] = new int[10];
        int suma = 0;
        
        for(int i = 0; i < num.length; i++){
            System.out.println("Introduzca el numero en la posición "+ i);
            num[i] = in.nextInt();
        }
        for(int e=0; e < num.length; e++){
            suma += num[e];
        }
        System.out.println("La suma de los valores es: "+ suma);

    }
    
}
