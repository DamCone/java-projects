package libroo;
import java.util.Scanner;
public class LibroO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LibroObj [] l1 = new LibroObj[2];
        for (int i = 0; i < 2; i++) {
            l1[i] = new LibroObj();
            System.out.print("Introduce el titulo del libro "+(i+1)+": ");
            l1[i].setTitulo(in.nextLine());
            System.out.print("Introduce el autor del libro "+(i+1)+": ");
            l1[i].setAutor(in.nextLine());
            System.out.print("Introduce el año de publicación del libro "+(i+1)+": ");
            l1[i].setAño(in.nextLine());
            System.out.print("Introduce la editorial del libro "+(i+1)+": ");
            l1[i].setEditorial(in.nextLine());
        }
            for (int i = 0; i < 2; i++) {
            System.out.println("Resumen del libro"+(i+1)+": ");
            l1[i].imprime();
        }
    }

}
