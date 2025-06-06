package figuras;
import java.util.Scanner;
public class Figuras {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean seguir = true;
        int i;
        
        while(seguir){
            System.out.println("Introduce \n1. Cuadrado\n" + "2. Rectángulo\n" + "3. Triángulo equilátero\n" + "4. Círculo\n" + "5. Salir");
            System.out.print("Seleccione una opción: ");
            i = in.nextInt();
            
            if(i == 1){
                Cuadrado [] c1 = new Cuadrado[3];
                int j = 0;
                
                while (j < c1.length) {
                    System.out.print("Introdice la longitud del lado del cuadrado "+(j+1)+": ");
                    Cuadrado c = new Cuadrado(in.nextDouble());

                    System.out.println("El perímetro es: "+ c.perimetro());
                    System.out.println("El área es: "+ c.area());
                    
                    j++;
                }
                System.out.print("Introdice la longitud del lado del cuadrado: ");
                Cuadrado c = new Cuadrado(in.nextDouble());
                
                System.out.println("El perímetro es: "+ c.perimetro());
                System.out.println("El área es: "+ c.area());
            }
            else if(i == 2){
                double base;
                double altura;
                
                System.out.print("Introduce la longitud de la base: ");
                base = in.nextDouble();
                System.out.print("Introduce la longitud de la altura: ");
                altura = in.nextDouble();
                
                Rectangulo r = new Rectangulo(base, altura);
                System.out.println("El perímetro es: "+ r.perimetro());
                System.out.println("El área es: "+ r.area());
            }
            else if(i == 3){
                double base, altura;
                
                System.out.print("Introduce la longitud de la base: ");
                base = in.nextDouble();
                System.out.print("Introduce la longitud de la altura: ");
                altura = in.nextDouble();
                
                TrianguloEquilatero t = new TrianguloEquilatero(base, altura);
                System.out.println("El perímetro es: "+ t.perimetro());
                System.out.println("El área es: "+ t.area());
            }
            else if(i == 4){
                System.out.print("Introduce la longitud del radio: ");
                Circulo c = new Circulo(in.nextDouble());
                
                System.out.println("El perímetro es: "+ c.perimetro());
                System.out.println("El área es: "+ c.area());
            }
            else if(i == 5){
                seguir = false;
            }
            else{
                System.out.println("Has introducido un número incorrecto.");
            }
        }
    }

}
