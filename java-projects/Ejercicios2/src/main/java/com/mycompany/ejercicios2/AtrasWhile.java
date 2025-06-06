package com.mycompany.ejercicios2;
import java.util.Scanner;

public class AtrasWhile {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int num;
    
    System.out.print("Introduzca un número:");
    num = in.nextInt();
    
    while(num > 0){
      System.out.println(num);
      num--;
    }
  }
}