package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Edad{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int edad;
    
    System.out.print("¿Cuantos años tienes?:");
    edad = in.nextInt();
    
    if (edad >= 18){
        System.out.println("Eres mayor de edad");
    }else{
      System.out.println("Eres menor de edad");
    }
    
  }
}