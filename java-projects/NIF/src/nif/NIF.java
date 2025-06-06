package nif;
import java.util.Scanner;
public class NIF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        NIFObj n = new NIFObj();
        String nif;
        System.out.println("Introduce un NIF: ");
        n.setValorNif(in.nextLine());
        
        if(n.comprobarNif()){
            System.out.println("jdnc");
        }
    }

}
