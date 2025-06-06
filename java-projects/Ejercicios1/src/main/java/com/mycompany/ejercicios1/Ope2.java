package com.mycompany.ejercicios1;
import java.util.Scanner;
public class Ope2 {
    public static void main(String[] args) {
      
      Scanner in = new Scanner(System.in);
      int num1;
      int num2;
      
      System.out.println("Escribe el primer número:");
      num1 = in.nextInt();
      
      System.out.println("Escribe el primer número:");
      num2 = in.nextInt();
      
      int mayor = (num1>num2)?num1:num2;
      System.out.println("El mayor de los números es: " + mayor);
      
      in.close();
    } 
}
