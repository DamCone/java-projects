package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Ej5 {

    public static void imprimePositivo(int p) throws Exception{
        if(p < 0){
            throw new Exception("Error, el valor '+p+' no es positivo.");
        }
        System.out.println("Valor positivo: "+ p);
    }
    public static void imprimeNegativo(int n) throws Exception{
        if(n > 0){
            throw new Exception("Error, el valor '+p+' no es negativo.");
        }
        System.out.println("Valor negativo: "+ n);
    }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
        boolean seguir = true;
            System.out.println("Introduce valores enteros positivos y negativos o un valor no entero para salir.");
        while(seguir){
            try{
                System.out.println("Introduce un número.");
                int num = in.nextInt();
                
                if(num >= 0){
                    imprimePositivo(num);
                } else{
                    imprimeNegativo(num);
                }
                
            }
            catch(InputMismatchException e){
                System.out.println("El número no es entero.");
                seguir = false;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            finally{
            }
        }
        System.out.println("Programa finalizado.");
        in.close();
    }
}

