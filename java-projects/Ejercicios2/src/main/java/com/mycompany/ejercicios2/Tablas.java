package com.mycompany.ejercicios2;
import java.util.Scanner;

class Tablas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, cont, resultado, aciertos = 0;
        
        System.out.print("Escriba el número a multiplicar: ");
        num = in.nextInt();
        
        for(cont = 1;cont<=10;cont++){
          System.out.print("Cuanto es "+ num + " por "+ cont +": ");
          resultado = in.nextInt();
        
          if(resultado == num * cont){
            System.out.print("¡Genial has acertado! \n");
            aciertos++;
          } else {
            System.out.println("El número es incorrecto... la respuesta correcta es: "+ (num * cont)+"\n");
          }
        }
        System.out.println("Tu número de aciertos es: "+ aciertos);
    }
    
}
