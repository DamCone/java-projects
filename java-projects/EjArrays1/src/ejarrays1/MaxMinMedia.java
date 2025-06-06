package ejarrays1;
import java.util.Scanner;
public class MaxMinMedia {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int e = 0;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        int suma = 0;
        int media = 0;

        System.out.print("Introduce el número de valores del vector: ");
        e = in.nextInt();
        
        int vector[] = new int[e];
        
        for(int i = 0; i < vector.length; i++){
            System.out.print("Introduce el valor número"+(i+1)+"del vector: ");
            vector[i] = in.nextInt();
        }
        for (int n = 0; n < vector.length; n++){
            if (vector[n] < min){
                min = vector[n];
            }
            if (vector[n] > max){
                max = vector[n];
            }
        }
        for (int m = 0; m < vector.length; m++) {
            suma += vector[m];
        }
        media = suma / vector.length;
        
        System.out.println("El valor máximo es: "+ max);
        System.out.println("El valor mínimo es: "+ min);
        System.out.println("La media de los valores es: "+ media);
    }
        
}
