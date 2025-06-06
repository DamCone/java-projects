package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Ej16 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num1;
    int num2;
    
    System.out.print("Introduce el primer numero:");
    num1 = in.nextInt();
    
    System.out.print("Introduce el segundo numero:");
    num2 = in.nextInt();
    
    if(num1 == num2) {
    System.out.println("Los numeros tienen el mismo valor");
    } else if (num1 > num2){
    System.out.println(num1 + " es mayor que " + num2);
    } else {
    System.out.println(num2 + " es mayor que " + num1);
    }
    in.close();
  }
    
}