package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Ej18 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num1;
    
    System.out.print("Introduce la nota del alumno:");
    num1 = in.nextInt();
    
    if (num1 >= 0 && num1 < 3) {
      System.out.println("Muy deficiente");
    } else if (num1 >= 3 && num1 < 5) {
      System.out.println("Insuficiente");
    } else if (num1 >= 5 && num1 < 6) {
      System.out.println("Suficiente");
    } else if (num1 >= 6 && num1 < 7) {
      System.out.println("Bien");
    } else if (num1 >= 7 && num1 < 9) {
      System.out.println("Notable");
    } else if (num1 >= 9 && num1 <= 10 ) {
      System.out.println("Sobresaliente");
    } else {
      System.out.println("La nota debe ser de 0 a 10");
    }
    
    in.close();
  }
    
}
