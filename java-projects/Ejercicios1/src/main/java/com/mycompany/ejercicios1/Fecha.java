
package com.mycompany.ejercicios1;
import java.util.Scanner;
public class Fecha {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dia;
        int mes;
        int año;
        
        System.out.print("Introduce el dia:");
        dia = in.nextInt();
        System.out.print("Introduce el mes:");
        mes = in.nextInt();
        System.out.print("Introduce el año:");
        año = in.nextInt();
        
        if (mes == 2 && año % 4 == 0 && año % 100 != 0 
        || año % 400 == 0)  {
        if ((dia > 31 || dia < 1 || mes > 12 || mes < 1 || (mes == 4 || mes == 6 || mes == 9 || 
          mes == 11) && dia > 30) || año > 9999 || año < 1000 || mes == 2 && dia > 29) {
            System.out.println("La fecha es incorrecta");
          } else {
            System.out.println("La fecha es correcta");
        }
        } else {
          if ((dia > 31 || dia < 1 || mes > 12 || mes < 1 || (mes == 4 || mes == 6 || mes == 9 || 
          mes == 11) && dia > 30) || año > 9999 || año < 1000 || mes == 2 && dia > 28) {
            System.out.println("La fecha es incorrecta");
          } else {
            System.out.println("La fecha es correcta");
        }
        }
        in.close();
    }
    
}
