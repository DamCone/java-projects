//Damián Conejos Monzó
package com.mycompany.examenprieraev;
import java.util.Scanner;
public class Temperaturas1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dia = 1, suma = 0, mes, max = 0, min = 0;
        
        System.out.print("Introduce un mes del 1 al 12: ");
        mes = in.nextInt();
        
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
          while (dia <= 31){
              System.out.print("Introduce la temperatura máxima del dia " + dia+": ");
              max = in.nextInt();
              System.out.print("Introduce la temperatura mínima del dia " + dia+": ");
              min = in.nextInt();
              suma = suma + (max + min) / 2;
              dia++;}
          } else if (mes == 2){
          while (dia <= 28){
              System.out.print("Introduce la temperatura máxima del dia " + dia+": ");
              max = in.nextInt();
              System.out.print("Introduce la temperatura mínima del dia " + dia+": ");
              min = in.nextInt();
              suma = suma + (max + min) / 2;
              dia++;}
          } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
          while (dia <= 30){
              System.out.print("Introduce la temperatura máxima del dia " + dia+": ");
              max = in.nextInt();
              System.out.print("Introduce la temperatura mínima del dia " + dia+": ");
              min = in.nextInt();
              suma = suma + (max + min) / 2;
              dia++;}
            }else {
              System.out.print("Error el mes debe ser del 1 al 12");
                  }
            System.out.print("La media de temperatura de tu mes es de: "+ (suma / (dia - 1))+"º");
        
    }
}
