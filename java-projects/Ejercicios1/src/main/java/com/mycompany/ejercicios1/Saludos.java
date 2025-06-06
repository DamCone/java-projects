package com.mycompany.ejercicios1;

import java.util.Scanner;

public class Saludos {

    public static void main(String[] args) {
      String nombre = "";
      Scanner in = new Scanner(System.in);
      
      System.out.print("Escriba su nombre:");
      nombre = in.nextLine();
      
      System.out.println("Buenos dias \nSr/a. " + nombre + "\nQue tenga un buen día.");
    }
    
}
