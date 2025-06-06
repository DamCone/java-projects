package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Relacional{
  public static void main(String[] args){
  
    Scanner in = new Scanner(System.in);
    
    System.out.println("Escriba el primer número: ");
    int num1 = in.nextInt();
    
    System.out.println("Escriba el segundo número: ");
    int num2 = in.nextInt();
    
    if (num1 == num2){
      System.out.println("Los números introducidos tienen el mismo valor");
    } else if (num1 > num2){
      System.out.println("El primer número es mayor que el segundo");
    } else {
      System.out.println("El primer número es menor que el segundo");
    }
    in.close();
  }
}