//Damián Conejos Monzó
package com.mycompany.examenprieraev;
import java.util.Scanner;
public class NewMain1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxDia, minDia, mediaDias = 0, mediaMes = 0, mes, cont = 1;
        
        System.out.println("Introduce el número del mes: ");
        mes = in.nextInt();
        
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            while(cont<=31){
              System.out.println("Introduce la temperatura máxima del día "+ cont+": ");
              maxDia = in.nextInt();
              System.out.println("Introduce la temperatura mínima del día "+ cont+": ");
              minDia = in.nextInt();
              mediaDias += (maxDia + minDia)/2;
              if (cont == 31){
                  mediaMes = mediaDias / 31;
              }
              cont++;
            }
            
        } else if (mes == 2){
            while(cont<=28){
              System.out.println("Introduce la temperatura máxima del día "+ cont+": ");
              maxDia = in.nextInt();
              System.out.println("Introduce la temperatura mínima del día "+ cont+": ");
              minDia = in.nextInt();
              mediaDias += (maxDia + minDia)/2;
              if (cont == 28){
                  mediaMes = mediaDias / 28;
              }
              cont++;
            } 
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
            while(cont<=30){
              System.out.println("Introduce la temperatura máxima del día "+ cont+": ");
              maxDia = in.nextInt();
              System.out.println("Introduce la temperatura mínima del día "+ cont+": ");
              minDia = in.nextInt();
              mediaDias += (maxDia + minDia)/2;
              if (cont == 30){
                  mediaMes = mediaDias / 30;
              }
              cont++;
            }
        }
        System.out.println("La temperatura media del mes introducido es de: "+ mediaMes +"ºC");
    }
    
}
