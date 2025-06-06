package rectanguloo;
import java.util.Scanner;
public class RectanguloO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RectanguloObj r = new RectanguloObj();
        
        System.out.print("Introduce la base: ");
        r.setBase(in.nextInt());
        
        System.out.print("Introduce la altura: ");
        r.setAltura(in.nextInt());
        
        r.imprimir();
    }
}
