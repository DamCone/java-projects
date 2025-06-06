package primoobj;
import java.util.Scanner;
public class PrimoO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrimoObj p = new PrimoObj();
        boolean seguir = true;
        
        while(seguir){
            System.out.print("Introduce el número para saber si es primo o 0 para salir: ");
            p.setNum(in.nextInt());
            
            if(p.getNum() == 0){
                seguir = false;
            } else{
                if(p.esPrimo()){
                    System.out.println("Es primo.");
                } else{
                    System.out.println("No es primo.");
                }
            }
        }
    }
}
