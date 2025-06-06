package tablao;
import java.util.Scanner;
public class TablaO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TablaObj t = new TablaObj();
        boolean seguir = true;
        
        while(seguir){
            System.out.print("Introduce el número con el que quieras practicar su tabla de multiplicar o 0 para salir: ");
            t.setTablaDel(in.nextInt());
            if (t.getTablaDel() == 0) {
                System.out.println("Programa finalizado.");
                seguir = false;
            } else{
                t.comparar();
                t.mostrar();
            }
        }   
    }
}
