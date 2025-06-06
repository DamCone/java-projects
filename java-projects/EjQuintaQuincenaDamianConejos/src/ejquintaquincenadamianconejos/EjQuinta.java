
//Damián Conejos Monzó 1º DAM :)

package ejquintaquincenadamianconejos;
import java.util.Scanner;

public class EjQuinta {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, c;
        boolean repetir = true;
        
        while (repetir == true){
          System.out.print("Escribe el valor de a: ");
          a = in.nextInt();
          System.out.print("Escribe el valor de b: ");
          b = in.nextInt();
          System.out.print("Escribe el valor de c: ");
          c = in.nextInt();
          in.nextLine();
          
          double x1 = (-b+ Math.sqrt(b*b - 4*a*c))/(2*a);
          double x2 = (-b- Math.sqrt(b*b - 4*a*c))/(2*a);
          
          if (b*b -4*a*c > 0){
            System.out.println("x1 = "+ x1 + 
            " y x2= "+ x2);
          } else if (b*b -4*a*c == 0) {
            System.out.println("Raíces iguales x1 = "+ x1 +" y x2 = "+ x2);
          } else if (b*b -4*a*c < 0){
            System.out.println("Las dos raíces son complejas");
          }
          boolean entradaValida = false; 
          String respuesta;
          
//He realizado este boolean y el siguiente bucle para el caso en el que no se escriba ni s/S ni n/N     

          while (entradaValida == false){
            System.out.print("¿Desea resolver otra ecución de 2º grado s/n?: ");
            respuesta = in.nextLine();
          
          if ("s".equals (respuesta) || "S".equals (respuesta)){
            System.out.println("\n");
            entradaValida = true;
          } else if ("n".equals (respuesta) || "N".equals (respuesta)){
            repetir = false;
            entradaValida = true;
          } else {
            System.out.print("Debe escribir s o n. \n");
          }
          }
        }
        System.out.println("Programa finalizado.");
    }
}
// ¡Gracias por corregir este trabajo!