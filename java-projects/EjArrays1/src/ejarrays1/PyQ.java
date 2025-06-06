
package ejarrays1;

import java.util.Scanner;
public class PyQ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduce el valor P: ");
        int p = in.nextInt();
        System.out.print("Introduce el valor Q: ");
        int q = in.nextInt();
        
        int arr[] = new int[q - p + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = p + i;
        }
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println("En la posición "+ i + " el valor es "+ arr[i]);
        }
        
    }
    
}
