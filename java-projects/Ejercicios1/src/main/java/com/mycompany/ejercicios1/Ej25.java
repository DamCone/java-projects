package com.mycompany.ejercicios1;
import java.util.Scanner;
public class Ej25 {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int num1;
      int num2;
      
      System.out.print("Escriba el primer numero:");
      num1 = in.nextInt();
      
      System.out.print("Escriba el segundo numero:");
      num2 = in.nextInt();
      
      if (num1 <= 0 || num2 <= 0){
      System.out.println("El numero debe ser positivo");
      return;
      } else if (num1 < num2 && num2 % num1 == 0) {
              System.out.println("El primer número es menor y es divisor del segundo");
      } else if (num1 < num2 && num2 % num1 != 0) {
              System.out.println("El primer número es menor y no es divisor del segundo");
      } else if (num1 > num2 && num2 % num1 == 0) {
              System.out.println("El segundo número es menor y es divisor del primero");
      } else {
              System.out.println("El segundo número es menor y no es divisor del segundo");        
      } 
      in.close();
    }
}
