package stringo;
import java.util.Scanner;
public class StringObj {
    private String cadena = "";
    Scanner in = new Scanner(System.in);
    
    public StringObj(String cadena){
        this.cadena = cadena;
    }
    
    public StringObj(){}
    
    public int longitud(){
        return cadena.length();
    }
    
    public void caracter(){
        int num = 0;
        boolean seguir = true;
        while(seguir){
            System.out.println("Introduzca índice entre el 0 y el "+(cadena.length()-1)+": ");
            num = in.nextInt();
            if (num >= 0 && num < cadena.length()) {
                System.out.println("El carácter del índice introducido es: "+cadena.charAt(num));
                seguir = false;
            } else{
                System.out.print("Índice fuera de rango.");
            }
        } 
    }
    
    public int subcadena(String subC){
        return cadena.indexOf(subC);
    }
    // introducir valor e imprimir retorno
    public void caracterP(char caracter){
        boolean encontrado = false;
        
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == caracter) {
                System.out.println("Caracter "+cadena.charAt(i)+", posición: "+i);
                encontrado = true;
            }
        }
        if (!encontrado) {
                System.out.println("No está el carácter en la cadena.");
            }
    }
    
    public String mayusculas(){
        return cadena.toUpperCase();
    }
}