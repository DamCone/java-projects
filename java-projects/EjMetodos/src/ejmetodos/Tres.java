package ejmetodos;
import java.util.Scanner;
public class Tres {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int diasMes, diaSemana;
        System.out.print("Introduce el número de días que tiene el mes: ");
        diasMes = in.nextInt();
        
        System.out.print("Introduce el dia de la semana (del 1 al 7) en el que comienza el mes: ");
        diaSemana = in.nextInt();
            
        calendario(diasMes, diaSemana);
        
    }
    public static void calendario(int a, int b){
        int posicion = 1;
        System.out.println("Lun\t Mar\t Mie\t Jue\t Vie\t Sab\t Dom");
        for (int i = 1; i < b; i++) {
                    System.out.print(" \t ");
                    posicion ++;
                }
        for (int i = 1; i <= a; i++) {
            System.out.print(i+" \t ");
            posicion++;
            if(posicion > 7){
                System.out.println();
                posicion = 1;
            }
        }
        System.out.println();
    }
}
