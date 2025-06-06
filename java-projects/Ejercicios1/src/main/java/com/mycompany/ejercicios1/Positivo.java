package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Positivo {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num1;
    
    System.out.print("Introduce un número:");
    num1 = in.nextInt();
    
    if (num1 >= 0) {
      System.out.println("El número es positivo");
    } else {
      System.out.println("El número es negativo");
    }
    
    in.close();
  }
    
}
