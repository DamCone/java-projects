package ejarrays1;
import java.util.Scanner;

public class TablaSumas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Introduce el tamaño de la tabla cuadrada: ");
        int n = in.nextInt();
        
        int matriz[][] = new int[n][n];
        
        // Rellenar la matriz con las sumas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = i + j;
            }
        }

        // Mostrar la tabla formateada (similar a la tabla de la imagen)
         // Imprimir la cabecera
        System.out.print("  + ");
        for(int i = 0; i < n; i++){
          System.out.printf("%2d ",i);
        }
        System.out.println();

        System.out.println();
        // Imprimir la matriz
        for (int i = 0; i < matriz.length; i++) {
           System.out.printf("%2d |", i);
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%2d ", matriz[i][j]);
            }
            System.out.println();
        }
         in.close();
    }
}