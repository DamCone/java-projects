package excepciones;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ej3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num[] = new double[5];
        int j = 0;
            while (j < num.length) {
                try{
                System.out.print("Introduce el número "+(j +1)+": ");
                num[j] = in.nextDouble();
                j++;
                }
                catch(InputMismatchException e){
                    System.out.println("El valor no era un número.");
                    e.printStackTrace();
                        in.nextLine();
                }
            }
        for (int i = 0; i < num.length; i++) {
                    System.out.println("Valor "+(i+1)+": "+ num[i]);
        }
    }
}
