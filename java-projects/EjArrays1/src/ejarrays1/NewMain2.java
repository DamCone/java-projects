package ejarrays1;



import java.util.Random;

import java.util.Scanner;





public class NewMain2 {



    public static void main(String[] args) {

        

      Random rand = new Random();



      int upperbound = 10;

      int matriz[][] = new int[5][5];

      

      int sumFil1 = 0;

      int sumFil2 = 0;

      int sumFil3 = 0;

      int sumFil4 = 0;

      int sumFil5 = 0;

      

      int sumCol1 = 0;

      int sumCol2 = 0;

      int sumCol3 = 0;

      int sumCol4 = 0;

      int sumCol5 = 0;

   

      

      for (int x=0; x < matriz.length; x++) {



        for (int y=0; y < matriz[x].length; y++) {

            

            matriz[x][y] = rand.nextInt(upperbound);



            sumFil1 = matriz[0][0] + matriz[0][1] + matriz[0][2] + matriz[0][3] + matriz[0][4];

            sumFil2 = matriz[1][0] + matriz[1][1] + matriz[1][2] + matriz[1][3] + matriz[1][4];

            sumFil3 = matriz[2][0] + matriz[2][1] + matriz[2][2] + matriz[2][3] + matriz[2][4];

            sumFil4 = matriz[3][0] + matriz[3][1] + matriz[3][2] + matriz[3][3] + matriz[3][4];

            sumFil5 = matriz[4][0] + matriz[4][1] + matriz[4][2] + matriz[4][3] + matriz[4][4];

            

            sumCol1 = matriz[0][0] + matriz[1][0] + matriz[2][0] + matriz[3][0] + matriz[4][0];

            sumCol2 = matriz[0][1] + matriz[1][1] + matriz[2][1] + matriz[3][1] + matriz[4][1];

            sumCol3 = matriz[0][2] + matriz[1][2] + matriz[2][2] + matriz[3][2] + matriz[4][2];

            sumCol4 = matriz[0][3] + matriz[1][3] + matriz[2][3] + matriz[3][3] + matriz[4][3];

            sumCol5 = matriz[0][4] + matriz[1][4] + matriz[2][4] + matriz[3][4] + matriz[4][4];

            

        }

    }

      



       for (int x=0; x < matriz.length; x++) {



        for (int y=0; y < matriz[x].length; y++) {



            System.out.print(matriz[x][y] + "  ");

              

            if ((x == 0) && (y == 4)) {

               

               System.out.println("  " + sumFil1);

               

           } else if ((x == 1) && (y == 4)) {

               

               System.out.println("  " + sumFil2);

               

           } else if ((x == 2) && (y == 4)) {

               

               System.out.println("  " + sumFil3);

               

           } else if ((x == 3) && (y == 4)) {

               

               System.out.println("  " + sumFil4);

               

           } else if ((x == 4) && (y == 4)) {

               

               System.out.println("  " + sumFil5);

               

           }

            

            

        }

    }

       

        System.out.println(" ");

        System.out.println(sumCol1 + " " + sumCol2 + " " + sumCol3 + " " + sumCol4 + " " + sumCol5);

            

    }

    

}

