package ejmetodos;
import java.util.Scanner;
public class Tres2 {
    public static void main(String[] args) {
        int h = horas();
        int min = minutos();
        int sec = segundos();
        for (int i = 1; i <= 10; i++) {
            int[] b = mas1Sec(h,min,sec);
            System.out.println(i +" segundos despues son las "+ b[0]+":"+b[1]+":"+b[2]);
            
            h = b[0];
            min = b[1];
            sec  = b[2];
        }
    }
    public static int horas(){
        Scanner in = new Scanner(System.in);
        boolean repetir = true;
        int h = 0;
        
        while(repetir == true){
            System.out.print("Introduce las horas: ");
            h = in.nextInt();

            if (h >= 0 && h < 24){
                repetir = false;
                System.out.println("Las horas son correctas.");
            } else {
                System.out.println("Introduce correctamente las horas.");
            }
        }
        return h;
    }
    public static int minutos(){
        Scanner in = new Scanner(System.in);
        boolean repetir = true;
        int min = 0;
        
        while(repetir == true){
            System.out.print("Introduce los minutos: ");
            min = in.nextInt();

            if (min >= 0 && min < 60){
                repetir = false;
                System.out.println("Los minutos son correctos.");
            } else {
                System.out.println("Introduce correctamente los minutos.");
            }
        }
        return min;
    }
    public static int segundos(){
        Scanner in = new Scanner(System.in);
        boolean repetir = true;
        int sec = 0;
        
        while(repetir == true){
            System.out.print("Introduce los segundos: ");
            sec = in.nextInt();

            if (sec >= 0 && sec < 60){
                repetir = false;
                System.out.println("Los segundos son correctos.");
            } else {
                System.out.println("Introduce correctamente los segundos.");
            }
        }
        return sec;
    }
    public static int[] mas1Sec(int h, int min, int sec){
        sec ++;
        if (sec >= 60){
            sec = 00;
            min++;
            if (min >= 60) {
                min = 00;
                h++;
                if (h >= 24) {
                    h = 00;
                }
            }
        }
        int[] masUno = {h,min,sec};
        return masUno;
    }
}
