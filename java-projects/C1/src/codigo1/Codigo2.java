/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codigo1;

/**
 *
 * @author Media
 */
public class Codigo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /* 
        FACTORIAL de n:  n! = n x (n-1) x (n-2) x ..... x 3 x 2 x 1

               ejemplo:  5! = 5 x 4 x 3 x 2 x 1 = 120
        */

        int limite=5;
        int factorial=1;

        for (int i=limite;i>0;i--){
            factorial*=i;
        }
    }
}
