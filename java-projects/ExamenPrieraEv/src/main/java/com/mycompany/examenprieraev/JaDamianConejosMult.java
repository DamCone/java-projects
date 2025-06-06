//Damián Conejos Monzó
package com.mycompany.examenprieraev;
import java.util.Scanner;
public class JaDamianConejosMult {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = 0, num2 = 0, suma, mult;
        
        System.out.println("Introduce el primer número: ");
        num1 = in.nextInt();
        System.out.println("Introduce el segundo número");
        num2 = in.nextInt();
        suma = num1 + num2;
        mult = num1 * num2;
        if (suma > mult){
            System.out.println("La suma de los números es mayor que la multiplicación.");
        } else if (mult > suma) {
            System.out.println("La multiplicación de los numeros es mayor que la suma.");
        } else {
            System.out.println("La suma y la multiplicación de los números dan el mismo resultado.");
        }
    }
    
}
