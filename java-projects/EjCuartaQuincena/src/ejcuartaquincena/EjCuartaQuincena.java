
import java.util.Scanner;


public class EjCuartaQuincena {
  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    int dia;
    int mes;
    int año;
    
    System.out.print("Escribe el día (del 1 al 31):");
    dia = in.nextInt();
    
    System.out.print("Escribe el mes (del 1 al 12):");
    mes = in.nextInt();
    
    System.out.print("Escribe el año:");
    año = in.nextInt();
    
    if (dia < 1 || dia > 31 || mes <1 || mes > 12 || año < 1000 || año >9999 || (mes == 2 && dia > 28) || 
    ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30)){
      System.out.println("Esta fecha es incorrecta");
      return;
    }
    
    dia = dia + 7;
    if (mes == 2 && dia > 28){
      dia = dia - 28;
      mes++;
    } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30){
      dia = dia -30;
      mes++;
    } else if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && dia > 31){
      dia = dia - 31;
      mes++;
    }
    if (mes >12){
      mes = 1;
      año++;
    }
    System.out.println("Pasados siete días la fecha será: " + dia + "/" + mes + "/" + año);
    in.close();
    
  }
}// Gracias por corregir este trabajo :)

