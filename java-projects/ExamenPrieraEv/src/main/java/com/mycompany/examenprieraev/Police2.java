//Damián Conejos Monzó
package com.mycompany.examenprieraev;
import java.util.Scanner;
public class Police2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int contA = 0, culpables = 0, contB = 0, contC = 0, numPresos = 0, numPistas = 0, cont = 1, cont2 = 1, punt = 0;
        String pista;
        
        System.out.println("Introduce el número de presos: ");
        numPresos = in.nextInt();
        
        while(cont <= numPresos){
            System.out.println("Introduce el número de pistas hacia el preso nº"+ cont + ": ");
            numPistas = in.nextInt();
            in.nextLine();
            punt = 0;
            cont2 = 1;
            while(cont2 <= numPistas){
                
                System.out.println("Introduce en mayúsculas si la pista nº"+cont2+" es A, B o C: ");
                pista = in.nextLine();
                if ("A".equals(pista)){
                punt = punt +25;
                contA++;
                } if("B".equals(pista)){
                punt = punt +15;
                contB++;
                } if("C".equals(pista)){
                punt = punt +35;
                contC++;
                }            
                cont2++;
            }
        if(punt > 85){
            System.out.println("El preso número "+cont+" es Culpable");
            culpables++;
        }else if(punt <= 85 && punt >= 65){
            System.out.println("El preso número "+cont+" es Sospechoso de alto riesgo");
        }else if(punt < 65){
            System.out.println("El preso número "+cont+" es Sospechoso de bajo riesgo");
        }  
            cont++;
        }
        
        if ( contA > contB && contA > contC){
            System.out.println("La pista mas usual es A");
        } else if ( contB > contC && contB > contA){
            System.out.println("La pista mas usual es B");
        }else if ( contC > contB && contC > contA){
            System.out.println("La pista mas usual es C");
        }
        System.out.println("El número de culpables es de "+ culpables);
    }
    
}
