package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Ej26 {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int dia;
      int mes;
      int año;
      int diaN;
      int mesN;
      int añoN;
      
      System.out.print("Escribe cual fué el día de tu nacimiento:");
      diaN = in.nextInt();
      System.out.print("Escribe cual fué el mes de tu nacimiento:");
      mesN = in.nextInt();
      System.out.print("Escribe cual fué el año de tu nacimiento:");
      añoN = in.nextInt();
      
      
      System.out.print("Escribe que día es hoy (del 1 al 31):");
      dia = in.nextInt();
      System.out.print("Escribe a que mes estamos (del 1 al 12):");
      mes = in.nextInt();
      System.out.print("Escribe a que año estamos:");
      año = in.nextInt();
      
      int edad = año - añoN;
      
      if (mes < mesN || mes == mesN && dia < diaN) {
        edad--;
      }
      if (edad < 0) {
        System.out.println("La fecha es invalida.");
      } else {
      System.out.println("Tu edad es de: " + edad + " Años.");
      }
      
      in.close();
    }
    
}
