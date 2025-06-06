package com.mycompany.ejercicios2;
import java.util.Scanner;

public class ParImpar{
   public static void main(String args[]){
     Scanner in = new Scanner(System.in);
     int num, pares = 0, impares = 0, cont;
     
     for(cont=1;cont<=15;cont++){
       System.out.print("Introduce un número:");
       num = in.nextInt();
     
       if (num % 2 == 0){
         pares++;
       } else {
         impares++;
       }
     }
     System.out.println("La cantidad de numeros pares es de:"+ pares);
     System.out.println("La cantidad de numeros impares es de:"+ impares);

   }
}