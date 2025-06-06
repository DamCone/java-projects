package ejmetodos;
import java.util.Scanner;
public class Dos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduce n: ");
        int n = in.nextInt();
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(amigos(i, j)){
                    System.out.println("Los números "+i+" y "+j+" son amigos.");
                }
            }
        }
        
    }
    public static boolean amigos(int a, int b){
        int acum1 = 0, acum2 = 0;
        boolean ami = false;
        for(int i = 1; i < a; i++){
            if(a % i == 0){
                acum1 += i;
            }
        }
        for(int i = 1; i < b; i++){
            if(b % i == 0){
                acum2 += i;
            } 
        }
        if (acum1 == b && acum2 == a){
            ami = true;
        }
        return ami;
    }
}
