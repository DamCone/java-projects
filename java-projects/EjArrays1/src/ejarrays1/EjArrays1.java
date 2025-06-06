
package ejarrays1;
import java.util.Scanner;
public class EjArrays1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num[];
        num = new int[10];
        
        for(int i = 0; i< num.length; i++){
            System.out.println("Introduce el valor en: "+ i);
            num[i]= in.nextInt();
        }
        for(int e = 0; e < num.length; e++){
            System.out.println("En "+ e +" el valor es: "+ num[e]);
        }
        
    }
    
}
