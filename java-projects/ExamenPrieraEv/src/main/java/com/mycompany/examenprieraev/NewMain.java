
package com.mycompany.examenprieraev;
import java.util.Scanner;
public class NewMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = 0, num2 = 0, num3 = 0, cont = 1;
        System.out.print("Escribe el número al que buscar divisores: ");
        num1 = in.nextInt();
        System.out.print("Escribe el número menor del intervalo: ");
        num2 = in.nextInt();
        System.out.print("Escribe el número mayor del intervalo: ");
        num3 = in.nextInt();
        while (cont <= num3){
          if(num1 % cont == 0 && cont >= num2 && cont <= num3){
            System.out.println( cont + " es divisor de "+ num1 +" y está dentro del intervalo");
          }
          cont++;
        }
    }
    
}
