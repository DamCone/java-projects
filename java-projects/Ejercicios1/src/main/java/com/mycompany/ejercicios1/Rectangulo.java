package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Rectangulo{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    
    System.out.print("Introduce la altura del rectángulo en metros: ");
    double alto = in.nextDouble();
    
    System.out.print("Introduce el ancho del rectángulo en metros: ");
    double ancho = in.nextDouble();
    
    double perimetro = 2*(alto + ancho);
    double area = alto * ancho;
    
    System.out.println("La altura del rectángulo es: " + (alto) + "m, el ancho del réctangulo es: " + (ancho) + "m , el perímetro del rectangulo es: " + (perimetro) + "m y el área es: " + (area) + "m2");
    
    
  }
}
