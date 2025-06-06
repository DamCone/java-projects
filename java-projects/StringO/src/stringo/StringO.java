package stringo;
import java.util.Scanner;
public class StringO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduzca la cadena de texto: ");
        StringObj s = new StringObj(in.nextLine());
        
        System.out.println("La longitud de la cadena es: "+s.longitud());
        
        s.caracter();
        
        System.out.print("Introduzca una subcadena: ");
        String subC = in.nextLine();
        
        if(s.subcadena(subC) == -1){
            System.out.println("La subcadena no existe dentro de la cadena.");
        } else{
            System.out.println("Se encuentra en la posición "+s.subcadena(subC)+" de la cadena original.");
        }
        
        System.out.print("Introduzca un carácter para mostrar los índices que ocupa en la cadena: ");
        char c = in.next().charAt(0);
        
        s.caracterP(c);
        
        System.out.println("Cadena introducida en mayusculas: "+s.mayusculas());
    }

}
