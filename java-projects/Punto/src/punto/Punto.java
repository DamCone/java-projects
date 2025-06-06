package punto;
import java.util.Scanner;
public class Punto {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Puntos p1 = new Puntos(5, 0);
        Puntos p2 = new Puntos(10, 10);
        Puntos p3 = new Puntos(-3, 7);
        
        System.out.println("Punto1");
        p1.imprime();
        System.out.println("Punto2");
        p2.imprime();
        System.out.println("Punto3");
        p3.imprime();
        
        System.out.print("Modifica la x del púnto nº1: ");
        int x = in.nextInt();
        System.out.print("Modifica la y del púnto nº1: ");
        int y = in.nextInt();
        p1.setXY(x,y);
        p1.imprime();
        
        System.out.print("Desplaza la x del punto nº2: ");
        int dx = in.nextInt();
        System.out.print("Desplaza la y del punto nº2: ");
        int dy = in.nextInt();
        p2.desplaza(dx,dy);
        
        System.out.println("La distancia ente el punto 2 y el 3 es: "+ p2.distancia(p3));
    }

}
