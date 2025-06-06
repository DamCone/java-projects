
package com.mycompany.ejercicios2;
import java.util.Scanner;

public class Primo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, i = 2;
        
        System.out.print("Introduce el número: ");
        num = in.nextInt();
        
        boolean primo = true;
        if (num <=1) {
          primo = false;
        } else {
          while(i <= num / 2){
            if (num % i == 0){
                primo = false;
            } else{
                i++;}
                
          }
        }
        if(primo == true){
        System.out.println("Es un numero primo");
        } else if (primo == false){
        System.out.println("No es un numero primo");
        }
    }
    
}
