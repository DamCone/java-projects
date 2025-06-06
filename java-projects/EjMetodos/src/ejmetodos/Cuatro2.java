package ejmetodos;
import java.util.Scanner;
import java.util.Random;
public class Cuatro2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int acum1 = 0, acum2 = 0;
        System.out.print("Indica el número de lanzamientos: ");
        int nLanzamientos = in.nextInt();
            int[] dado1, dado2;
            dado1 = new int[nLanzamientos];
            dado2 = new int[nLanzamientos];
        for (int i = 0; i < nLanzamientos; i++) {
            
            dado1[i] = (int) (Math.random()*7 + 1);
            acum1 += dado1[i];
            dado2[i] = (int) (Math.random()*7 + 1);
            acum2 += dado2[i];
        }
        double media = (acum1 + acum2) / (nLanzamientos * 2);
        System.out.println(salida(dado1, dado2, media));
    }
    public static String salida(int a[], int b[], double media){
        String m = "La media de los resultados es de: "+ media; 
        return m;
    }
}
