package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Ej20 {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int horas;
      int minutos;
      int segundos;     
      
      System.out.print("Introduce las horas (0-23):");
      horas = in.nextInt();
      
      System.out.print("Introduce los minutos (0-59):");
      minutos = in.nextInt();
      
      System.out.print("Introduce los segundos (0-59):");
      segundos = in.nextInt();
      
      segundos++;
      
      if (segundos == 60) {
          segundos = 0;
          minutos++;
        }

       if (minutos == 60) {
          minutos = 0;
          horas++;
        }

       if (horas == 24) {
          horas = 0;
        }
       if (horas > 24 || horas < 0) {
         System.out.println("Las horas deben estar comprendidas enre 0 y 23");
        }
       System.out.printf("La hora después de un segundo será: %02d:%02d:%02d\n", horas, minutos, segundos);
    }
    
}
