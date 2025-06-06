package com.mycompany.ejercicios2;
import java.util.Scanner;
public class AtrasDo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.print("Introduce un número:");
        num = in.nextInt();
        
        do{
        System.out.println(num);
        num--;
        }
        while(num > 0);
    in.close();
    }
    
}
