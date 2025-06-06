package com.mycompany.ejercicios2;
import java.util.Scanner;

public class Tabla{
    public static void main (String args[]){
      Scanner in = new Scanner(System.in);
      int num, resultado, cont;
      
      System.out.print("Introduce el número:");
      num = in.nextInt();
      
      
      for(cont=1;cont<=10;cont++){
          resultado = (num * cont);
        System.out.println(num +" * "+cont+"="+ resultado);
      }
    }
    
    
    
}