package com.mycompany.ejercicios1;
import java.util.Scanner;
public class Esfera {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in); 
    
    System.out.print("Introduce el radio de la circunferencia en metros: ");
    double radio = in.nextDouble();
    
    double longitud = (2 * radio * 3.14);
    double area = (4/3 * Math.PI * Math.pow(radio, 3));
    
    System.out.println("La longitud de la circunderencia es : " + longitud + "m");
    System.out.println("Y el área de la circunferencia que crea es: " + area + "m3");
    
    in.close();
    
  }
}