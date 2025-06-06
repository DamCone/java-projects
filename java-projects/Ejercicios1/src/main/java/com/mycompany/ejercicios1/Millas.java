package com.mycompany.ejercicios1;
import java.util.Scanner;
public class Millas{
  public static void main(String[] args){
    
    Scanner in = new Scanner(System.in);  
    
    System.out.print("Escribe las millas que quieres traducir a metros: ");
    double millas = in.nextDouble();
    
    double metros = (millas * 1609.34);
    System.out.println("Las millas introducidas (" + (millas) + ") se traducen a " + (metros) + " metros");
    
    in.close();
  }
}