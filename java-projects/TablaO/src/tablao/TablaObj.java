package tablao;
import java.util.Scanner;
public class TablaObj {
    Scanner in = new Scanner(System.in);
    private int tablaDel;
    private int comparador;
    
    public int getTablaDel() {
        return tablaDel;
    }

    public void setTablaDel(int tablaDel) {
        this.tablaDel = tablaDel;
    }

    public int getComparador() {
        return comparador;
    }

    public void setComparador(int comparador) {
        this.comparador = comparador;
    }

    public TablaObj(){}
    
    public void comparar(){
        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduce la respuesta:");
            System.out.print(tablaDel+" x "+i+" = ");
            comparador = in.nextInt();
            if (comparador == (tablaDel * i)) {
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto...");
            }
        }
    }
    
    public void mostrar(){
        System.out.println("Esta es la tabla correcta del número elegido:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(tablaDel+" x "+i+" = "+(tablaDel * i));
        }
    }
}
