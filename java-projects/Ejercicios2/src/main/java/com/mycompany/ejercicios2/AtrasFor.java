package com.mycompany.ejercicios2;
import java.util.Scanner;

public class AtrasFor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, cont = 0;
        
        System.out.print("Introduzca número:");
        num = in.nextInt();
        
        for (cont=num;cont>0;cont--){
          System.out.println(cont);
        }
        
    }
    
}
