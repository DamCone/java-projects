package cuentac;
import java.util.ArrayList;
import java.util.Scanner;
public class DawBank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CuentaBancaria c = new CuentaBancaria();
        
        boolean seguir = true;
        boolean seguir1 = true;
        while(seguir){
            System.out.print("Vamos a crear tu cuenta bancaria: \nIntroduce primero el IBAN: ");
            c.setIban(in.nextLine());
            System.out.print("Ahora introduce el nombre del titular: ");
            c.setTitular(in.nextLine());
            
            if (!c.crearCuenta()) {
                System.out.println("Error asegurate de cumplir estas condiciones:\nEl iban debe contener dos letras mayusculas al principio seguido de 22 números.\nY el nombre no debe contener dígitos o símbolos.");
            } else{
                System.out.println("Felcicidades, ¡tu cuenta ha sido creada!");
                seguir = false;
            }
        }
        
        while(seguir1){
            System.out.println("Menú:\n1.Datos de la cuenta.\n2.IBAN\n3.Titular\n4.Saldo\n5.Ingreso\n6.Retirada\n7.Movimientos\n8.Salir");
            int r = in.nextInt();
            
            if(r == 1){
                System.out.println("Datos de la cuenta:");
                System.out.println("IBAN: "+ c.getIban());
                System.out.println("Titular: "+ c.getTitular());
                System.out.println("Saldo: "+ c.getSaldo());
            } else if(r == 2){
                System.out.println("IBAN: "+ c.getIban());
            } else if(r == 3){
                System.out.println("Titular: "+ c.getTitular());
            } else if(r == 4){
                System.out.println("Saldo: "+ c.getSaldo());
            } else if(r == 5){
                System.out.print("Introduce la cantidad a ingresar: ");
                float cantIngreso = in.nextFloat();
                if (c.ingreso(cantIngreso)) {
                    System.out.println("Realizado el ingreso de: "+cantIngreso+" euros.");
                } else{
                    System.out.println("Error la cantidad a ingresar es negativa.");
                }
            } else if(r == 6){
                System.out.print("Introduce la cantidad a retirar: ");
                float cantRetirada = in.nextFloat();
                if (c.retirada(cantRetirada)) {
                    System.out.println("Realizada la retirada de: "+cantRetirada+" euros.");
                } else{
                    System.out.println("Error el saldo está por debajo de -50 euros o la cantidad a retirar es negativa.");
                }
            } else if(r == 7){
                System.out.println(c.getMovimientos());
            } else if(r == 8){
                seguir1 = false;
            } else {
                System.out.println("Numero incorrecto.");
            }
        }
    }
}
