package com.mycompany.ejercicios1;

import java.util.Scanner;

public class Opera{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    
    System.out.print("Introduce el primer número: ");
    int num1 = in.nextInt();
    
    System.out.print("Introduce el segundo número: ");
    int num2 = in.nextInt();
    
    System.out.println("Suma: " + (num1 + num2));
    System.out.println("Resta: " + (num1 - num2));
    System.out.println("Mutiplicación: " + (num1 / num2));
    
    if (num2 == 0){
        System.out.println("No se puede dividir entre 0");
    } else {
        System.out.println("División: " + (num1 / num2));
        System.out.println("Resto de la división: " + (num1 % num2));
    }
    
    System.out.println("Incremento del primer número: " + (++num1));
    System.out.println("Incremento del segundo número: " + (++num2));
    System.out.println("Decremento del primer número: " + (--num1));
    System.out.println("Decremento del segundo número: " + (--num2));
    
    in.close();
  }
}