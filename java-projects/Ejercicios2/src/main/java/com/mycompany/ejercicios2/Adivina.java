
package com.mycompany.ejercicios2;
import java.util.Scanner;

public class Adivina {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, adivinado = 50;
        String respuesta;
        System.out.print("Escriba un numero del 1 al 100: ");
        num = in.nextInt();
        in.nextLine();
        
        if(num < 1 || num > 100){
          System.out.print("El número debe estar entre 1 y 100");
          return;
        } else
        do {
          System.out.print("Mmmm... yo creo que es el..."+ adivinado + "Escribe si tu número es menor, mayor o igual al mio: ");
          respuesta = in.nextLine();
          if ("menor".equals(respuesta)){
            adivinado--;
          }else if ("mayor".equals(respuesta)){
            adivinado ++;
          }else if(!"igual".equals(respuesta))
            System.out.println("La respuesta debe ser menor, mayor o igual");
        }
        while (!"igual".equals(respuesta));
        
        System.out.println("¡Lo sabia! Tu numero es el "+ adivinado);

        
    }
    
}
