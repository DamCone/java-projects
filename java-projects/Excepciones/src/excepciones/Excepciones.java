package excepciones;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Excepciones {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int num = 0;
        String respuesta;
        try{    
            System.out.print("Introduce un número: ");
            num = in.nextInt();
            
            respuesta = String.valueOf(num);
            
            System.out.println("Valor introducido: "+ respuesta);
        }
        catch(InputMismatchException e){
            System.out.println("Valor introducido incorrecto.");
            e.printStackTrace();
        } finally{
            in.close();
        }
    }

}
