package ejmetodos;
import java.util.Scanner;
public class Fecha {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dia, mes, año;
        boolean validar = false;
        
        
        while(validar == false){
            System.out.println("Introduce la fecha en formato dd-mm-aaaa: ");
            System.out.print("Introduce el dia: ");
            dia = in.nextInt();

            System.out.print("Introduce el mes: ");
            mes = in.nextInt();

            System.out.print("Introduce el año: ");
            año = in.nextInt(); 
            validar = fechaValida(dia,mes,año);
            
            boolean vis = visiesto(año);
            
            if(vis == true){
                System.out.println("El año es bisiesto.");
            }
            if(validar == true){
                System.out.println("La fecha es valida.");
            }
            
            if (validar == false){
                System.out.println("Vuelve a introducir la fecha de forma correcta.");
            }
        }
    }
    public static boolean fechaValida(int a, int b, int c){
        boolean f = false;
        if ((a > 0 && a <= 31 && b > 0 && b <= 12 && c > 999 && c < 9999)){
            f = true;
        }
        return f;
    }
    public static boolean visiesto(int c){
        boolean v = false;
        if ((c % 4 == 0 && c % 100 != 0) || (c % 400 == 0)){
            v = true;
        }
        return v;
    }

}
