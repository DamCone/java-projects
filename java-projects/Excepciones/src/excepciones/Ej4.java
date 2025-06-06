package excepciones;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
public class Ej4 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        int longitud = r.nextInt(100)+1;
        int arr[] = new int[longitud];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10)+1;
        }
        
        int num = 0;
        while(num >= 0){
            try{
                System.out.print("Que posición quieres saber del vector: ");
                num = in.nextInt();
                System.out.println("El número que ocupa la posición es: "+ arr[num]);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("El número está fuera del rango del array. De 0 a "+ (longitud -1));
                e.printStackTrace();
            }
            catch(InputMismatchException e){
                System.out.println("Debe ser un número.");
                e.printStackTrace();
                in.next();
            }
        }
        System.out.println("Programa finalizado");
        in.close();
    }
}
