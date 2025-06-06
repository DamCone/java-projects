package coche;
import java.util.Scanner;
public class Concesionario {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Coche c[] = new Coche[10];
        boolean salir = false;
        
        while(!salir){
            int numCoche = 0;
            System.out.println("Menú:\n1. Crea objeto.\n2. vende el coche.\n3. pinta el coche.\n4. muestra coche.\n5. salir.");
            int menu = in.nextInt();
            
            switch (menu) {
                case 1:
                    System.out.println("Hay 10 coches, introduce del 1 al 10 cual quieres crear.");
                    numCoche = in.nextInt()-1;
                    in.nextLine();
                    if (numCoche >= 0 && numCoche <=9 && c[numCoche] == null) {
                         if (c[numCoche] == null) {
                            c[numCoche] = new Coche();
                        }
                        System.out.print("Introduce la matrícula: ");
                        c[numCoche].setMatricula(in.nextLine());
                        
                        System.out.print("Introduce el color: ");
                        c[numCoche].setColor(in.nextLine());
                        
                        System.out.print("Introduce la cilindrada: ");
                        c[numCoche].setCilindrada(in.nextFloat());
                        
                        System.out.print("Introduce las plazas: ");
                        c[numCoche].setPlazas(in.nextInt());
                        in.nextLine();
                        System.out.print("Introduce el propietario: ");
                        c[numCoche].setPropietario(in.nextLine());
                        
                        System.out.println("Coche creado.");
                    } else{
                        System.out.println("El número de coche es incorrecto o ya existe.");
                    }   break;
                case 2:
                    System.out.print("Introduce el coche del 1 al 10 que quieres vender: ");
                    numCoche = in.nextInt()-1;
                    in.nextLine();
                    if (numCoche >= 0 && numCoche <=9 && c[numCoche] != null) {
                        c[numCoche] = null;
                        System.out.println("Coche vendido.");
                    } else{
                        System.out.println("El número de coche es incorrecto o el coche no existe.");
                    }   break;
                case 3:
                    System.out.print("Introduce el coche del 1 al 10 que quieres pintar: ");
                    numCoche = in.nextInt()-1;
                    in.nextLine();
                    if (numCoche >= 0 && numCoche <=9 && c[numCoche] != null) {
                        System.out.print("Introduce un color: ");
                        c[numCoche].setColor(in.nextLine());
                        System.out.println("Coche pintado");
                    } else{
                        System.out.println("El número de coche es incorrecto o el coche no existe.");
                    }   break;
                case 4:
                    System.out.print("Introduce el coche del 1 al 10 que quieres mostrar: ");
                    numCoche = in.nextInt()-1;
                    in.nextLine();
                    if (numCoche >= 0 && numCoche <=9 && c[numCoche] != null) {
                        System.out.println(c[numCoche].toString());
                        c[numCoche].visualiza();
                    } else{
                        System.out.println("El número de coche es incorrecto o todavía no existe.");
                    }   break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Numero incorrecto.");
                    break;
            }
        }
        
        
    }

}
