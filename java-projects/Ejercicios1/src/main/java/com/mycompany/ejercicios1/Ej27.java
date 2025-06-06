package com.mycompany.ejercicios1;
import java.util.Scanner;
public class Ej27 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
    int num1;
    int num2;
    int num3;
    
    System.out.print("Introduzca el primer número:");
    num1 = in.nextInt();
    System.out.print("Introduzca el segundo número:");
    num2 = in.nextInt();
    System.out.print("Introduzca el tercer número:");
    num3 = in.nextInt();
    
    if (num1 < num2 && num2 < num3 || num1 < num2 && num2 == num3 || num1 == num2 && num1 < num3) {
      System.out.println("El orden ascendente es de " + num1 + ", " + num2 + ", " + num3);
    } else if (num1 < num3 && num3 < num2 || num1 == num3 && num1 < num2) {
      System.out.println("El orden ascendente es de " + num1 + ", " + num3 + ", " + num2);
    } else if (num2 < num1 && num1 < num3 || num2 < num1 && num1 == num3) {
      System.out.println("El orden ascendente es de " + num2 + ", " + num1 + ", " + num3);
    } else if (num2 < num3 && num3 < num1 || num2 == num3 && num2 < num1) {
      System.out.println("El orden ascendente es de " + num2 + ", " + num3 + ", " + num1);
    } else if (num3 < num1 && num1 < num2 || num3 < num1 && num1 == num2) {
      System.out.println("El orden ascendente es de " + num3 + ", " + num1 + ", " + num2);
    } else if (num3 < num2 && num2 < num1) {
      System.out.println("El orden ascendente es de " + num3 + ", " + num2 + ", " + num1);
    } else if (num1 == num2 && num1 == num3) {
      System.out.println("Todos los numeros son iguales");
    }
    
    in.close();
  }
    
}
