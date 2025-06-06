package com.mycompany.examenprieraev;
import java.util.Scanner;
public class Media {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double ej1, ej2, ej3, ej4, ej5, notaEx, suma, media;
        
        System.out.print("Introduce la nota del examen: ");
        notaEx = in.nextInt();
        if(notaEx >= 4){
        System.out.print("Nota del ejercicio 1: ");
        ej1 =  in.nextInt();
        System.out.print("Introduce la nota deñ ejercico 2: ");
        ej2 =  in.nextInt();
        System.out.print("Introduce la nota del ejercicio 3: ");
        ej3 =  in.nextInt();
        System.out.print("Introduce la nota del ejercicio 4: ");
        ej4 =  in.nextInt();
        System.out.print("Introduce la nota del ejercicio 5: ");
        ej5 =  in.nextInt();
        suma = ej1 + ej2 + ej3 + ej4 + ej5;
        media = suma / 5;
        System.out.println("La media de tus tareas es de: "+ media);
        } else {
            System.out.println("En el examen no tienes 4 puntos o más");
        }
    }
    
}
