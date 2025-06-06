package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Producto {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num1;
    int num2;
    int producto;
    
    System.out.print("Introduce el primer número a mutiplicar:");
    num1 = in.nextInt();  
    System.out.print("Introduce el segundo número a mutiplicar:");
    num2 = in.nextInt();
    System.out.print("Introduce el producto de estos números:");
    producto = in.nextInt();
    
    if (num1 * num2 == producto) {
      System.out.println("El producto es correcto");
    } else {
      System.out.println("El producto es incorrecto");
    }

    in.close();
  }
    
}
