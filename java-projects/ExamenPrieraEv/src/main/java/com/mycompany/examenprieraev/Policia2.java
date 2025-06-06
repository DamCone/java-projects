
package com.mycompany.examenprieraev;
import java.util.Scanner;
public class Policia2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int contA = 0, contB = 0, contC = 0, aProcesar, nPistas, cont = 1, cont1 = 1, cont2 = 1, sumPistas = 0, culpables = 0;
       
        String pista = ""; 
        String estatus = "";
        
        System.out.print("Introduzca el número de presos a procesar: ");
        aProcesar = in.nextInt();
        for (cont = 1;cont <= aProcesar; cont++){
            sumPistas = 0;
            System.out.print("Ingrese el número de pistas del preso "+cont+ ": ");
            nPistas = in.nextInt();
            
            for (cont1 = 1;cont1 <= nPistas; cont1++){
              
              in.nextLine();
              System.out.print("Escriba si la pista número "+ cont1 + " es de tipo A, B o C en mayusculas: ");
              pista = in.nextLine();
              if ("A".equals(pista)){
                sumPistas = sumPistas + 25;
                contA++;
              } else if ("B".equals(pista)){
                sumPistas = sumPistas + 15;
                contB++;
              }else if ("C".equals(pista)){
                sumPistas = sumPistas + 35;
                contC++;
              }
              
              if(cont1 < nPistas){
              System.out.print("Pulse enter");
              }
            }
            if (sumPistas < 65){
                estatus = "Sospechoso de bajo riesgo ";
              } else if (sumPistas >= 65 && sumPistas < 85){
                estatus = "Sospechoso de alto riesgo ";
              } else if (sumPistas >= 85){
                estatus = "Culpable ";
                culpables++;
              }
            System.out.print("El estatus del preso " +cont +" es "+ estatus+"\n"); 
            
            
        } 
      System.out.print("El número de culpables es de: " + culpables+"\n");
      if(contA > contB && contA > contC){
        System.out.println("El tipo de pista mas frecuente es A ");
      } else if(contB > contA && contB > contC){
        System.out.println("El tipo de pista mas frecuente es B");
      } else if(contC > contB && contC > contA){
        System.out.println("El tipo de pista mas frecuente es C");
      }
    }
    
    
}
