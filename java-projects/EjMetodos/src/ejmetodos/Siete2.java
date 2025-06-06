package ejmetodos;
import java.util.Scanner;
public class Siete2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean repetir = true;
        int num = 1;
        
        while(repetir){
            System.out.print("Introduce el número de serie o 0 para acabar: ");
            String serie = in.nextLine();
            
            if (!serie.isEmpty()){
            num = Integer.parseInt(serie);
            
                if(num == 0){
                    repetir = false;
                } else {
                    //programa
                    System.out.print("Introduce el número de autoverificación: ");
                    int verificador = in.nextInt();

                    int v = verificador(serie);

                    if (v == verificador) {
                        System.out.println("¡El verificador es correcto!");
                        repetir = true;
                    } else{
                        System.out.println("El verificador es incorrecto...");
                        repetir = true;
                    }
                    repetir = true;
                }
            }   
        }
    }
    public static int verificador (String a){
        int verificador = 0;
        int acum = 0;
        for (int i = 1; i < a.length(); i+=2) {
            char c = a.charAt(i);
            int porDos = Integer.parseInt(String.valueOf(c))*2;
            
            acum += porDos;
        }
        for (int i = 0; i < a.length(); i+=2) {
            char c = a.charAt(i);
            int noMult = Integer.parseInt(String.valueOf(c));
            
            acum += noMult;
        }
        int aRestar = acum;
        while (aRestar % 10 != 0){
            aRestar++;
        }
        verificador = aRestar - acum;
        return verificador;
    }
}
