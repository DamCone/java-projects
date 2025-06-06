package com.mycompany.ejercicios1;
import java.util.Scanner;
public class Mes {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int mes;
      
      System.out.print("Escriba el número del 1 al 12 al que pertenece su mes:");
      mes = in.nextInt();
      
      switch (mes) {
        case 1: System.out.print("Enero");
        break;
        case 2: System.out.print("Febrero");
        break;
        case 3: System.out.print("Marzo");
        break;
        case 4: System.out.print("Abril");
        break;
        case 5: System.out.print("Mayo");
        break;
        case 6: System.out.print("Junio");
        break;
        case 7: System.out.print("Julio");
        break;
        case 8: System.out.print("Agosto");
        break;
        case 9: System.out.print("Septiembre");
        break;
        case 10: System.out.print("Octubre");
        break;
        case 11: System.out.print("Noviembre");
        break;
        case 12: System.out.print("Diciembre");
        break;
        default: System.out.print("Error, el número debe estar entre el 1 y el 12");     
      }      
      in.close();
    }
    
}
