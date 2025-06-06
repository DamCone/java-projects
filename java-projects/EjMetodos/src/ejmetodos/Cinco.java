package ejmetodos;
import java.util.Scanner;
public class Cinco {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean menu = true;
        while(menu){
            boolean s = false;
            System.out.print("1.- Calcular el factorial de un número. \n2.- Hallar si dos números son amigos. \n3.- Resolver ecuación de 2º grado. \n4.- Salir del programa. \nIntroduzca un número del menú: ");
            int m = in.nextInt();
            if (m == 1){
                while(s == false){
                    System.out.print("Introduce el número: ");
                    int f = in.nextInt();
                    System.out.println("Tu factorial es: "+ factorial(f));
                    in.nextLine();
                    System.out.println("Desea salir al menú principal? s/n");
                    String siNo = in.nextLine();
                    
                    s = salir(siNo);
                }
            }
            if (m == 2){
                while(s == false){
                    System.out.print("Introduce el número uno: ");
                    int amigo1 = in.nextInt();
                    
                    System.out.print("Introduce el número dos: ");
                    int amigo2 = in.nextInt();
                    
                    boolean esAmigo = amigos(amigo1, amigo2);
                    
                    if(esAmigo == true){
                        System.out.println("Son amigos!");
                    } else {
                        System.out.println("No lo son...");
                    }
                    in.nextLine();
                    System.out.println("Desea salir al menú principal? s/n");
                    String siNo = in.nextLine();
                    
                    s = salir(siNo);
                }
            }
            if (m == 3){
                while(s == false){
                    System.out.print("Escribe el valor de a: ");
                    int a = in.nextInt();
                    System.out.print("Escribe el valor de b: ");
                    int b = in.nextInt();
                    System.out.print("Escribe el valor de c: ");
                    int c = in.nextInt();
                    
                    ecuacion(a, b, c);
                    
                    in.nextLine();
                    System.out.println("Desea salir al menú principal? s/n");
                    String siNo = in.nextLine();
                    
                    s = salir(siNo);
                }
            }
            if (m == 4){
                menu = false;
            }
            else {
                System.out.println("Opción no válida, por favor seleccione una opción válida.");
            }
        }
    }
    
    public static boolean salir (String a){
        boolean salir = false;
        boolean i = false;
        while(i == false){
            if ("s".equals(a) || "S".equals(a)){
                i = true;
                salir = true;
            } else if ("n".equals(a) || "N".equals(a)){
                i = true;
                salir = false;
            } else{
                i = false;
                System.out.println("Error debes introducir s o n.");
            }
        }
        return salir;
    }
    
    public static int factorial(int a){
        int acum = 1;
        for (int i = 1; i <= a; i++) {
            acum = (acum * i);
        }
        return acum;
    }
    
    public static boolean amigos(int a, int b){
        boolean esAmigo = false;
        int acum1 = 0, acum2 = 0;
        for (int i = 1; i < a; i++) {
            if(a % i == 0){acum1 += i;}
        }
        for (int i = 1; i < b; i++) {
            if(b % i == 0){acum2 += i;}
        }
        if (acum1 == b && acum2 == a){esAmigo = true;}
        return esAmigo;
    } 
    
    public static void ecuacion (int a, int b, int c){
        double x1 = (-b+ Math.sqrt(b*b - 4*a*c))/(2*a);
        double x2 = (-b- Math.sqrt(b*b - 4*a*c))/(2*a);

        if (b*b -4*a*c > 0){
            System.out.println("x1 = "+ x1 + 
        " y x2= "+ x2);
        } else if (b*b -4*a*c == 0) {
            System.out.println("Raíces iguales x1 = "+ x1 +" y x2 = "+ x2);
        } else if (b*b -4*a*c < 0){
            System.out.println("Las dos raíces son complejas");
        }
    }
}
