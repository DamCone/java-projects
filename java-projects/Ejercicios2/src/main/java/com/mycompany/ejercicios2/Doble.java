package com.mycompany.ejercicios2;
import java.util.Scanner;

public class Doble{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int num;
        
        do{
          System.out.print("Introduzca un número a duplicar o 0 para acabar:");
          num = in.nextInt();
          System.out.println("El doble de tu número es:" + (num * 2));
        }
        while(num!=0);
    }
}