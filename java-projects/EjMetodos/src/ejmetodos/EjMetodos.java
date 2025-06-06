package ejmetodos;
import java.util.Scanner;
public class EjMetodos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        
        System.out.print("Introduzca numero: ");
        i = in.nextInt();
        
        tabla(i);
    }
    public static int tabla(int x){
        for(int cont=1;cont<11;cont++){
            System.out.println(x +" x "+ cont + " = " + (x * cont));
        }
        return x;
    }
    
}
