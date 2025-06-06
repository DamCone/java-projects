package excepciones;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ej2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        try{
            System.out.print("Introduce el primer número: ");
            int num1 = in.nextInt();
            
            System.out.print("Introduce el segundo número: ");
            int num2 = in.nextInt();
            
            int res = num1/num2;
            
            System.out.println("La division entre num1 y num2 es: "+res);   
        }
        catch(InputMismatchException e){
            System.out.println("Al menos uno de los valores no era un número.");
            e.printStackTrace();
        }
        catch(ArithmeticException e){
            System.out.println("No se puede dividir entre 0.");
            e.printStackTrace();
        }
        finally{
            in.close();
        }
    }

}
