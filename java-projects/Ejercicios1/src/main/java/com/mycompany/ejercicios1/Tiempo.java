package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Tiempo{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    double segundos;
    
    System.out.print("Introduce los segundos:");
    segundos = in.nextDouble();
    
    System.out.println("Los segundos introducidos equivalen a: " + (segundos / 60) + " Minutos");
    System.out.println("Los segundos introducidos equivalen a: " + ((segundos / 60) / 60) + " Horas");
    System.out.println("Los segundos introducidos equivalen a: " + (((segundos / 60) / 60) / 24) + " Segundos");
    
    in.close();
  }

}