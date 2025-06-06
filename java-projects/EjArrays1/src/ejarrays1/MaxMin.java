
package ejarrays1;
import java.util.Scanner;
public class MaxMin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num[] = new int[10];
        
        for(int i =0; i < num.length; i++){
            System.out.println("Introduzca el numero en la posición: "+ i);
            num[i] = in.nextInt();
        }
        int max = num[0];
        int min = num[0];
        for (int e=0; e < num.length; e++){
            if(max < num[e]){
                max = num[e];
            }
            if(min > num[e]){
                min = num[e];
            }
        }
        System.out.println("El número máximo es: "+ max);
        System.out.println("El número mínimo es: "+ min);

    }
    
}
