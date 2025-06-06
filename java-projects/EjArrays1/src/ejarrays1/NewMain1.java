package ejarrays1;

public class NewMain1 {
    public static void main(String[] args) {
        int num[][] = new int[3][3];
        
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = i+j;
                System.out.println("El valor de la fila "+ i +" + la columna "+ j +" = "+num[i][j]+ "\n");
            }
        }
        
    }

}
