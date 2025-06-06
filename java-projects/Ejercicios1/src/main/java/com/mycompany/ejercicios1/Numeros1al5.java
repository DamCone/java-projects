
package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Numeros1al5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        
        System.out.print("Escribe un número del 1 al 5:");
        num = in.nextInt();
        
        switch (num) {
        case 1: System.out.println("Uno");
        break;
        case 2: System.out.println("Dos");
        break;
        case 3: System.out.println("Tres");
        break;
        case 4: System.out.println("Cuatro");
        break;
        case 5: System.out.println("Cinco");
        break;
        default: System.out.println("Has hecho trampa, el numero debía ser entre el 1 y el 5");
        }
      in.close();
    }
    
}
