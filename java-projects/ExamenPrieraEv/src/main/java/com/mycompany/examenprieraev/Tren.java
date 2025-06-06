//Damián Conejos Monzó :)
package com.mycompany.examenprieraev;
import java.util.Scanner;
public class Tren {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int menu, num;
        String familiar;
        
        System.out.print("Introduzca el número del menú al que quiera acceder: 1 Rago, 2 Billetes de tren, 3 Salir: ");
        menu = in.nextInt();
        
        if(menu == 1){
            System.out.print("Escriba su número: ");
            num = in.nextInt();
            if (num < 50){
                System.out.println("El número es menor que 50");
            } else if(num >= 50 && num <=100){
                System.out.println("El número está entre 50 y 100");
            } else{
                System.out.println("El número es mayor que 100");
            } 
            
        } 
            double suma = 0;
            if (menu == 2){
            boolean repetir = true;
            while(repetir == true){
                in.nextLine();
                System.out.print("Ingrese el nombre del familiar:");
                familiar = in.nextLine();
            System.out.print("Ingrese su edad: ");
            int edad = in.nextInt();
            if(edad >= 65){
                System.out.println("El coste de "+ familiar+ " es de 42,30 euros");
                suma = suma + 42.30;
            } else if(edad >= 12 && edad <= 15){
                System.out.println("El coste de "+ familiar+ " es de 35 euros");
                suma = suma + 35;
            } else if (edad >= 4 && edad <= 11){
                System.out.println("El coste de "+ familiar+ " es de 32,20 euros");
                suma = suma + 32.20;
            } else if (edad < 4){
                System.out.println(familiar+" puede pasar gratis");
            } else {
                System.out.println("El coste de "+ familiar+ "es de 60 euros");
                suma = suma + 60;
            }   System.out.println("Si quiere introducir otro familiar pulse 1 si no pulse otro digito");
                int digito = in.nextInt();
                if (digito != 1){
                repetir = false;
                } 
            }
                System.out.println("El total a pagar de todos los familiares es: "+suma);
        } else if (menu == 3){
          System.out.println("Saliendo del programa...");
        } else{
            System.out.println("El número debe ser 1, 2 o 3");
        }
        
        
    }
    
}
