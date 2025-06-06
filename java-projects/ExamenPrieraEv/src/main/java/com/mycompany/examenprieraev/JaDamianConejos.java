//Damián Conejos Monzó
package com.mycompany.examenprieraev;
import java.util.Scanner;
public class JaDamianConejos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int edad, aPagar = 0;
        String sexo;
        
        System.out.println("Introduzca su edad: ");
        edad = in.nextInt();
        in.nextLine();
        System.out.println("Introduzca su sexo Hombre o Mujer");
        sexo = in.nextLine();
        if ("Hombre".equals(sexo)) {
          if(edad > 0 && edad < 25){
            aPagar = 1000;
          } else if (edad >= 25){
            aPagar = 700;
          } else {
              System.out.println("La edad debe ser mayor a 0");
          }
        } else if ("Mujer".equals(sexo)){
          if(edad > 0 && edad < 21){
            aPagar = 800;
          } else if (edad >= 21){
            aPagar = 500;
          } else {
              System.out.println("La edad debe ser mayor a 0");
          }
        } else {
            System.out.println("El sexo debe ser Hombre o Mujer");
        }
   
        System.out.println("Debes pagar "+ aPagar+" euros");
    }
    
}
