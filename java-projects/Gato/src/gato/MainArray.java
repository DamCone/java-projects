package gato;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MainArray {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        ArrayList <Gato> g = new ArrayList();
        
        int i = 0;
        
        System.out.println("Vamos a crear cinco gatos.");
        
        while(g.size() < 5){
            try{
                System.out.print("Introduce un nombre para el gato número "+(i+1)+": ");
                String n = in.nextLine();
                
                System.out.print("Introduce una edad para el gato número "+(i+1)+": ");
                int e = in.nextInt();
                in.nextLine();
                Gato gato = new Gato(n,e);
                g.add(gato);
                i++;
            }
            catch(InputMismatchException e){
                System.out.println("Hay un valor incorrecto.");
                System.out.println(e.getMessage());
                e.printStackTrace();
                in.nextLine();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            
        }
        for (Gato gato : g) {
            gato.imprimir();
        }
        
    }
}
