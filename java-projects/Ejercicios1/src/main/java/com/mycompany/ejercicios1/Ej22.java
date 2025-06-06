package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Ej22 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double precio;
    
    System.out.print("Escribe el precio del producto:");
    precio = in.nextDouble();
    
    if (precio >= 6 && precio < 60) {
      precio = precio * 0.95;
    } else if (precio >= 60){
      precio = precio * 0.90;
    }
    System.out.println("El precio final es de: " + precio);
    in.close();
  }
    
}
