
package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Opera2{
  public static void main(String args[]){
     
    Scanner in = new Scanner(System.in);
    
    System.out.print("Introduce el primer número:");
    float num1 = in.nextFloat();
    
    System.out.print("Introduce el segundo número:");
    float num2 = in.nextFloat();
    
    System.out.println("Suma: " + (num1 + num2));
    System.out.println("Resta: " + (num1 - num2));
    System.out.println("Mutiplicación: " + (num1 * num2));
    System.out.println("División: " + (num1 / num2));
    System.out.println("Resto de la división: " + (num1 % num2));
    System.out.println("Incremento unitario del primer número: " + (++num1));
    System.out.println("Incremento unitario del segundo número: " + (++num2));
    System.out.println("Decremento unitario del primer número" + (--num1));
    System.out.println("Decremento unitario del segundo número: " + (--num2));
    
    in.close();
  }
}


