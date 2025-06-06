package ejmetodos;
import java.util.Scanner;
public class Cinco2 {
    public static void main(String[] args) {
        int n = validar();
        primos(n);
    }
    public static int validar(){
        int n = 0;
        Scanner in = new Scanner(System.in);
        boolean validar = true;
        while (validar == true){
            System.out.print("Introduce el número n: ");
            n = in.nextInt();
            
            if (n < 1){
                System.out.println("El número no es valido");
            } else {validar = false;}
        }
        return n;
    }
    public static void primos(int a){
        int j = 1;
        for (int i = 1; i <= a; i++) {
            boolean primo = true;
            for (int k = 2; k < i; k++) {
                if (i % k == 0){
                    primo = false;
                }
            }
            if (primo){
                System.out.println(i+ " es un número primo.");
            }
        }     
    }
}
