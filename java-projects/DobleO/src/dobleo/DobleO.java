package dobleo;
import java.util.Scanner;
public class DobleO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean seguir = true;
        while(seguir){
            System.out.print("Introduce el número a duplicar o 0 para acabar: ");
            DobleObj d = new DobleObj(in.nextInt());
            
            if (d.getNum() == 0) {
                seguir = false;
            } else{
                System.out.println("El número duplicado es: "+d.getDoble());
            }
        }
    }
}
