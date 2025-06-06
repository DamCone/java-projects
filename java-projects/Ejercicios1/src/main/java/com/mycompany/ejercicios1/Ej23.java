package com.mycompany.ejercicios1;
import java.util.Scanner;
public class Ej23 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int año;
    
    System.out.print("Introduce el año:");
    año = in.nextInt();
    
    if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
    System.out.println(año + " es un año bisiesto");
    } else {
      System.out.println(año + " no es un año bisiesto");
    }
    
  }
    
}
