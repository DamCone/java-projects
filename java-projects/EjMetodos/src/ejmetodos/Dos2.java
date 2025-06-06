package ejmetodos;
import java.util.Scanner;
public class Dos2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean seguir = true;
        
        while(seguir == true){
            System.out.print("Introduce la nota del alumno: ");
            int nota = in.nextInt();
            
            calificacion(nota);
            
            in.nextLine();
            System.out.println("Desea continuar? s/n");
            String respuesta = in.nextLine();
            
            if ("n".equals(respuesta) || "N".equals(respuesta)){
                seguir = false;
            }
        }
    }
    public static void calificacion(int a){
        System.out.print("La nota es: ");
        if (a >= 0 && a < 3){
            System.out.println("Muy Deficiente.");
        } else if (a >= 3 && a < 5){
            System.out.println("Insuficiente.");
        } else if (a == 5){
            System.out.println("Suficiente.");
        } else if (a == 6){
            System.out.println("Bien.");
        } else if (a >= 7 && a < 9){
            System.out.println("Notable.");
        } else if (a >= 9 && a <= 10){
            System.out.println("Sobresaliente.");
        } else {
            System.out.println("Incorrecta.");
        }
    }
}
