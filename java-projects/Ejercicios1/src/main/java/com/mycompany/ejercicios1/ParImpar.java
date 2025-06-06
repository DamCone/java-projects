package com.mycompany.ejercicios1;
import java.util.Scanner;

public class ParImpar {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int num;
      
      System.out.print("Introduce el número:");
      num = in.nextInt();
      
      if (num % 2 == 0) {
        System.out.println("El número es par");
      } else {
        System.out.println("El número es impar");
      }
      in.close();
    }
    
}
