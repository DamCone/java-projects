package com.mycompany.ejercicios2;
import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String eleccion;
        int num1, num2;
        
        do{
        System.out.print("Escribe si quieres hacer una suma, resta, multiplicación, división o salir: ");
        eleccion = in.nextLine();
        
        if (!"salir".equals(eleccion)){
          System.out.print("Escribe el primer número con el que operar: ");
          num1= in.nextInt();
          System.out.print("Escribe el segundo número con el que operar: ");
          num2= in.nextInt();
          in.nextLine();
          if("suma".equals(eleccion)){
          System.out.println("La suma de tus números es:"+ (num1 + num2));
          } else if ("resta".equals(eleccion)){
          System.out.println("La resta de tus números es:"+ (num1 - num2));
          } else if ("multiplicación".equals(eleccion)){
          System.out.println("La resta de tus números es:"+ (num1 * num2));
          } else if ("división".equals(eleccion)){
          System.out.println("La resta de tus números es:"+ (num1 / num2));
          } else if (!"salir".equals(eleccion)){
          System.out.println("El valor introducido no es suma, resta, multiplicación, división o salir");
          }
        }
        } while (!"salir".equals(eleccion));
    }
    
}
