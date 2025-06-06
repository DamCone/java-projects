package figuras;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Figuras {
    public static void main(String[] args) {
       Scanner entrada = new Scanner(System.in);
        int cont, num;
        int x1, x2;
         Cuadrado cu;
         Rectangulo re;
         TrianguloEquilatero tr;
         Circulo ci;
         
         ArrayList<Cuadrado> misCuadrados = new ArrayList();
         ArrayList<Rectangulo> misRectangulos = new ArrayList();
         ArrayList<TrianguloEquilatero> misTriangulos = new ArrayList();
         ArrayList<Circulo> misCirculos = new ArrayList();
         Iterator it2;
         
        do {
         System.out.print("Número de elementos de cada tipo :");
         num = entrada.nextInt();
        if (num <= 0) {
         System.out.println("ERROR: el número debe ser positivo > 0");
        }
        } while (num <= 0);
        // para Cuadrados
        for (cont = 0; cont < num; cont++) {
        do {
         System.out.print("Valor del lado :");
         x1 = entrada.nextInt();
        if (x1 <= 0) {
         System.out.println("ERROR: el número debe ser positivo > 0");
        }
        } while (x1 <= 0);
         misCuadrados.add(new Cuadrado(x1));
        }
        for (cont = 0; cont < num; cont++) {
        do {
         System.out.print("Valor de la base :");
         x1 = entrada.nextInt();
        if (x1 <= 0) {
         System.out.println("ERROR: el número debe ser positivo > 0");
        }
        } while (x1 <= 0);
        do {
         System.out.print("Valor de la altura:");
         x2 = entrada.nextInt();
        if (x2 <= 0) {
         System.out.println("ERROR: el número debe ser positivo > 0");
        }
        } while (x2 <= 0);
         misRectangulos.add(new Rectangulo(x1, x2));
        }
        // lo mismo para triangulos y circulos
         System.out.println("");
         it2 = misCuadrados.iterator();
        while (it2.hasNext()) {
         cu = (Cuadrado) it2.next();
         System.out.println("Cuadrado");
         System.out.println("Lado :" + cu.getLado());
         System.out.println("Perimetro : " + cu.perimetro());
         System.out.println("Área : " + cu.area());
         System.out.println("");
        }

         it2 = misRectangulos.iterator();
        while (it2.hasNext()) {
         re = (Rectangulo) it2.next();
         System.out.println("Rectángulo");
         System.out.println("Base :" + re.getBase());
         System.out.println("Altura :" + re.getAltura());
         System.out.println("Perimetro : " + re.perimetro());
         System.out.println("Área : " + re.area());
         System.out.println("");
        }
        
        
    }

}
