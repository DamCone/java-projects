package mastermind;
import java.util.Scanner;
import java.util.Random;
public class MASTERMIND {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int aComparar[] = new int[4];
        int elegidos[] = new int[4];
        
        //creamos números random
        for (int i = 0; i < 4; i++) {
                aComparar[i] = r.nextInt(7); 
            }
        /*
        for (int i = 0; i < 4; i++) {
                aComparar[i] = (i + 1); 
            }*/
        for (int g = 0; g < 10; g++) {
            int muertos = 0;
            int heridos = 0; 
            System.out.println("Este es el intento número "+ (g + 1));
            //preguntamos números al jugador
            System.out.println("Estos son los números asignados a cada colores: 1.ROJO, 2.AZUL, 3.VERDE, 4.AMARILLO, 5.NARANJA, 6.BLANCO");
            for (int i = 0; i < 4; i++) {
                System.out.print("Introduce el número del color "+ (i+1) +" : ");
                elegidos[i] = in.nextInt();
            }
            //comparamos aciertos
            for (int i = 0; i < 4; i++) {
                if(aComparar[i] == elegidos[i]){
                    muertos++;
                } else {
                    for (int j = 0; j < 4; j++) {
                        if (aComparar[i] == elegidos[j]) {
                            heridos++;
                        }
                    }
                }
            }
            //informar si ha ganado y mostrar colores
            String color[] = new String[4];
            if(muertos == 4){
                for (int i = 0; i < 4; i++) {
                    if (elegidos[i] == 1) {
                        color[i] = "ROJO";
                    }else if (elegidos[i] == 2) {
                        color[i] = "AZUL";
                    }else if (elegidos[i] == 3) {
                        color[i] = "VERDE";
                    }else if (elegidos[i] == 4) {
                        color[i] = "AMARILLO";
                    }else if (elegidos[i] == 5) {
                        color[i] = "NARANJA";
                    }else if (elegidos[i] == 6) {
                        color[i] = "BLANCO";
                    }else{
                        color[i] = "DESCONOCIDO";
                    }
                }
                System.out.println("¡Has ganado!");
                for (int i = 0; i < 4; i++) {
                    System.out.println("color número "+ (i+1)+": "+ color[i]);
                }
                g = 11;
            } else{
                System.out.println("El número de muertos es: "+muertos);
                System.out.println("El número de heridos es: "+heridos);
            }
            
        }
        
        
    }

}
