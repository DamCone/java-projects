package com.mycompany.ejercicios1;
import java.util.Scanner;

public class ChatEj {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
    int num1, num2, num3;
    
    // Leer los números
    System.out.print("Introduzca el primer número: ");
    num1 = in.nextInt();
    System.out.print("Introduzca el segundo número: ");
    num2 = in.nextInt();
    System.out.print("Introduzca el tercer número: ");
    num3 = in.nextInt();
    
    // Intercambio para ordenar en orden ascendente
    if (num1 > num2) {
      int temp = num1;
      num1 = num2;
      num2 = temp;
    }
    if (num1 > num3) {
      int temp = num1;
      num1 = num3;
      num3 = temp;
    }
    if (num2 > num3) {
      int temp = num2;
      num2 = num3;
      num3 = temp;
    }
    
    // Mostrar el resultado ordenado
    System.out.println("El orden ascendente es: " + num1 + ", " + num2 + ", " + num3);
    
    in.close();
  }
}