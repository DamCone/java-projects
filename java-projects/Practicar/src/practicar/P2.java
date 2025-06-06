
package practicar;

public class P2 {
    public static void main(String[] args) {
        int cont2 = 1, a = 0, b = 1, c = 0, i = 0;
        
        do {if (i < 9){
            System.out.println(a+", ");
            c = a + b;
            
            a = b;
            
            b = c;
        } else{
            System.out.println(a);
        }
        }while(i < 10);
    }
    
}
