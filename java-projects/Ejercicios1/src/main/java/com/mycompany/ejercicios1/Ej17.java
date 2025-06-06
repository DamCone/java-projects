package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Ej17 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num1;
    int num2;
    int num3;
    
    System.out.print("Introduce el primer numero:");
    num1 = in.nextInt();
    
    System.out.print("Introduce el segundo numero:");
    num2 = in.nextInt();
    
    System.out.print("Introduce el tercer numero:");
    num3 = in.nextInt();
    
    if(num1 == num2 && num1 == num3 && num2 == num3) {
    System.out.println("Los números tienen el mismo valor");
    } else if (num1 > num2 && num1 > num3){
    System.out.println(num1 + " es mayor que " + num2 + " y que " + num3);
    } else if (num2 > num3 && num2 > num3){
    System.out.println(num2 + " es mayor que " + num2 + " y que " + num3);
    }else {
    System.out.println(num3 + " es mayor que " + num1 + " y que " + num2);
    }
    in.close();
  }
    
}