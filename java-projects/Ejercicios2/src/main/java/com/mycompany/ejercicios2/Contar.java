
package com.mycompany.ejercicios2;
import java.util.Scanner;
public class Contar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTope, cont;
        
        System.out.print("Introduzca el numero tope:");
        numTope = in.nextInt();
        
        for(cont=1;cont<=numTope;cont++){
            System.out.println("Número :"+ cont);
    }
    }
    
}
