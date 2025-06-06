package ejmetodos;
import java.util.Scanner;
public class Primo {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        boolean esprimo = false;
        
        System.out.print("Introduce el número: ");
        int num = in.nextInt();
        
        esprimo = comprobar(num);
        
        if (esprimo == true) {
            System.out.println("El número introducido es primo.");
        } else {
            System.out.println("El número no es primo.");
        }
        
    }
    public static boolean comprobar(int a){
        boolean esprimo = true;
        if (a == 1){
            esprimo = false;
        } else {
            for (int cont = 2; cont < a; cont++){
                if (a % cont == 0){
                    esprimo = false;
                }
            }
        }
        return esprimo;
    }  
}
