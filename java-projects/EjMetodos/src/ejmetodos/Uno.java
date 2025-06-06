package ejmetodos;
import java.util.Scanner;
public class Uno {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Escribe el primer número: ");
        int num1 = in.nextInt();
        
        System.out.print("Escribe el segundo número: ");
        int num2 = in.nextInt();
        
        System.out.println(compara(num1, num2));
    }
    public static int compara(int a, int b){
        int c = 0;
        
        if(a > b){ c = 1;}
        else if(a < b){c = -1;}
        
        return c;
    }
}
