package com.mycompany.ejercicios2;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, cont, fact = 1;
        
        System.out.print("Escribe el número al que calcular su factorial o -1 si quieres salir: ");
        num = in.nextInt();
        
        if(num !=-1){
          for(cont=1;num>=cont; cont++){
            fact = (cont * fact);
          }
          System.out.println("El factorial de tu número es: "+ fact);
        }
    }
}
