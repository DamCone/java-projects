
package ejarrays1;
import java.util.Scanner;
public class Sumas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num[] = new int[20];
        int sumaN = 0;
        int sumaP = 0;        
        
        for (int i = 0; i < num.length; i++){
            System.out.println("Introduce el número de la posición "+ i);
            num[i] = in.nextInt();
            if (num[i] < 0){
                sumaN += num[i];
            } else {
                sumaP += num[i];
            }
        }
        System.out.println("La suma de los números negativos es: "+ sumaN);
        System.out.println("La suma de los números positivos es: "+ sumaP);
    }
    
}
