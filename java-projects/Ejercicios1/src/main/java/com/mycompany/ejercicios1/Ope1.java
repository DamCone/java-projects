package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Ope1{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    
    int num1;
    int num2;
    
    System.out.print("Escribe el primer número:");
    num1 = in.nextInt();
    
    System.out.print("Escribe el segundo número:");
    num2 = in.nextInt();
    
    System.out.println("El valor de la suma de los números es: " + (num1 + num2));
    System.out.println("El valor de la resta de los números es: " + (num1 - num2));
    System.out.println("El valor de la mutiplicación de los números es: " + (num1 * num2));
    if (num2 == 0){
    System.out.println("No se puede dividir entre 0");
    }else {

    System.out.println("El valor de la división de los números es: " + (num1 / num2));
    System.out.println("El valor del producto de la división de los números es: " + (num1 % num2));    
    }
  }
}
