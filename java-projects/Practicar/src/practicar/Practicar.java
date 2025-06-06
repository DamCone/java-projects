
package practicar;
import java.util.Scanner;
public class Practicar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cont2 = 1;
        int cont3 = 1000;
        for(int cont=1;cont <=5; cont++){
            System.out.println(cont);
        
        } while(cont2 <=5){
            System.out.println(cont2);
            cont2++;
        } do{
            System.out.println(cont3);
            cont3-=200;
        }while(cont3 >=0);
        
        
        
    }
    
}
