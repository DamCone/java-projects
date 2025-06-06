
package com.mycompany.ejercicios2;
import java.util.Scanner;

public class Contar2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1, num2, cont;
        
        System.out.print("Introduzca el primer número:");
        num1 = in.nextInt();
        
        System.out.print("Introduzca el segundo número:");
        num2 = in.nextInt();
        int menor = 0, mayor = 0;
        if(num1 < num2){
          menor = num1;
          mayor = num2;
        } else if(num2 < num1){
          menor = num2;
          mayor = num1;
        } else {
          System.out.println("Los números no pueden ser iguales");
        }
        
        for(cont=menor;cont<=mayor;cont++) {
          System.out.println("Número:" + cont);
        }
    }
    
}
