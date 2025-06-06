// 10 intentos
// 4 combinaciones
// muertos y heridos

package ejarrays1;
import java.util.Scanner;
import java.util.Random;
public class Matriz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int matriz[][] = new int[5][5];
        int sumaFila[] = new int[5];
        int sumaColumna[] = new int[5];
        
        for(int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = r.nextInt(50);
                sumaFila[j] += matriz[i][j];
                sumaColumna[i] += matriz[i][j];
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println();
        }
        for (int i = 0; i < sumaFila.length; i++) {
            System.out.println("La suma de la fila "+ (i+1)+ " es: "+ sumaFila[i]);
        }
        for (int i = 0; i < sumaColumna.length; i++) {
            System.out.println("La suma de la columna "+ (i+1)+ " es: "+ sumaColumna[i]);
        }
    }
    
}
