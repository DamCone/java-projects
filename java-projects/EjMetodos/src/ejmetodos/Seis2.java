package ejmetodos;
import java.util.Scanner;
public class Seis2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean repetir = true;
        while(repetir){
            System.out.print("Introduce el número para ver si es capicua o usa un número negativo para slir: ");
            String c = in.nextLine();
            
            int numero = Integer.parseInt(c);
            if(numero > 0){
                if (esCapicua(c)) {
                    System.out.println("Es capicua!");
                } else {
                    System.out.println("No es capicua.");
                }
            } else {
                System.out.println("Programa finalizado con exito.");
                repetir = false;
            }
        }
    }
    public static boolean esCapicua(String a){
        boolean esCapicua = true;
        int inicio = 0;
        int fin = a.length() -1;
        while(inicio < fin){
            if(a.charAt(inicio) != a.charAt(fin)){
                esCapicua = false;
            }
            inicio++;
            fin--;
        }
        return esCapicua;
    }
}
