package com.mycompany.ejercicios1;
import java.util.Scanner;

public class Ej21 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double horas;
    double tarifa1;
    double salarioBruto = 0;
    double salarioNeto = 0;
    String nombre;
    
    System.out.print("Introduce tu nombre:");
    nombre = in.nextLine();
    
    System.out.print("Introduce las horas trabajadas:");
    horas = in.nextInt();
    
    System.out.print("Introduce la tarifa normal que cobra en bruto por hora:");
    tarifa1 = in.nextInt();
    
    double tarifa2 = tarifa1 * 1.5;
    
    if (horas > 0 && horas <= 35) {
      salarioBruto = horas * tarifa1;
    } else if (horas > 35) {   
      salarioBruto = ((horas -35) * (tarifa2)) + 35 * tarifa1;
    } else {
    System.out.println(nombre + " las horas trabajadas deben ser mayor a 0");
    }
    System.out.println(nombre + " tu salario en bruto es:" + salarioBruto);
    
    if (salarioBruto > 0 && salarioBruto <= 500) {
      salarioNeto = salarioBruto;
    } else if (salarioBruto > 500 && salarioBruto <= 900){
      salarioNeto = ((salarioBruto - 500) * 0.75) + 500;
    } else if (salarioBruto > 900) {
      salarioNeto =((salarioBruto - 900)* 0.65) + 800;
    }
    System.out.println(nombre + " tu salario en neto es:" + salarioNeto);
    
    in.close();
  }
    
}
