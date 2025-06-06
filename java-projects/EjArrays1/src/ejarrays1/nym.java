package ejarrays1;
import java.util.Arrays;
import java.util.Scanner;
public class nym {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduce el valor de N: ");
        int n= in.nextInt();
        System.out.print("Introduce el valor de M: ");
        int m= in.nextInt();
        
        int arr[] = new int[n];
        Arrays.fill(arr, m);
        for (int i = 0; i < arr.length; i++) {
            
            System.out.println("La posición número "+ (i+1)+ " de N, es "+arr[i]);
        }
        
    }
    
}
