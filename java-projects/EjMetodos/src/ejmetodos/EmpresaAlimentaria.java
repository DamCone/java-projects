package ejmetodos;
import java.util.Scanner;
public class EmpresaAlimentaria {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean seguir = true;
        int cantidadN = 0, cantidadA = 0, valorProducNiños = 0, promedioVNiños = 0;
        
        while(seguir){
            int i = 1;
            
            String tipo = tipo();
            if ("Niños".equals(tipo)){
                cantidadN++;
            }else{
                cantidadA++;
            }
            
            int codigo = codigo();
            
            String variedad = variedad(codigo);
            
            
            System.out.print("Introduce el costo de fábrica: ");
            int costoF = in.nextInt();
            
            double valorProduc = valorProduc(tipo, variedad, costoF);
            
            if("Niños".equals(tipo)){
                valorProducNiños += valorProduc;
            }
            
            double precioVenta = precioVenta(tipo, variedad, costoF, valorProduc);
            
            System.out.println("El producto número "+ i +" tiene las siguientes características:\n"
                    + "Tipo: "+tipo+"\nCódigo: "+codigo+"\nVariedad: "+variedad+"\nCosto de fábrica: "+costoF+"\n"
                            + "Valor de producción: "+valorProduc+"\nPrecio de venta al público: "+precioVenta);
            in.nextLine();
            System.out.println("Desea seguir introduciendo productos? Pulse n/N para finalizar o otro valor para continuar.");
            String s = in.nextLine();
            
            if ("n".equals(s) || "N".equals(s)) {
                promedioVNiños = valorProducNiños / cantidadN;
                System.out.println("Se produjeron "+cantidadN+" productos para niños y "+cantidadA+" productos para adultos.");
                System.out.println("El total de los valores de producción de los productos para niños es "+valorProducNiños);
                System.out.println("El promedio de valores de producción de los productos para niños es "+promedioVNiños);
                if (cantidadN > cantidadA) {
                    System.out.println("Se produjeron mas productos para niños con una cantidad de "+cantidadN);
                } else if (cantidadN < cantidadA) {
                    System.out.println("Se produjeron mas productos para adultos con una cantidad de "+cantidadA);
                } else {
                    System.out.println("Se produjo la misma cantidad para niños y adultos.");
                }
                
                System.out.println("Programa finalizado.");
                seguir = false;
            }
            i++;
        }
    }
    public static String tipo(){
        Scanner in = new Scanner(System.in);
        boolean seguir = true;
        String t = "";
        while(seguir){
            System.out.print("Introduce el tipo de producto N (niños) A (adultos): ");
            String tipo = in.nextLine();
            if ("N".equals(tipo)) {
                t = "Niños";
                seguir = false;
            } else if ("A".equals(tipo)) {
                t = "Adultos";
                seguir = false;
            } else {
                System.out.println("Error, introduzca correctamente el valor N o A.");
            }
        }
        return t;
    }
    public static int codigo(){
        Scanner in = new Scanner(System.in);
        boolean seguir = true;
        int codigo = 0;
        while(seguir){
            System.out.print("Introduce el código del producto (del 1 al 20): ");
            codigo = in.nextInt();
            if (codigo >= 1 && codigo <= 10 ) {
                seguir = false;
            } else if (codigo > 10 && codigo <= 20) {
                seguir = false;
            } else {
                System.out.println("Error, introduzca correctamente el valor del 1 al 20.");
            }
        }
        return codigo;
    }
    public static String variedad(int codigo){
        String t = "";
            if (codigo >= 1 && codigo <= 10 ) {
                t = "Salados";
            } else {
                t = "Dulces";
            }
        return t;
    }
    public static double valorProduc(String tipo, String variedad, int costoF){
        double vP = 0;
        if("Niños".equals(tipo) && "Salados".equals(variedad)){
            vP = 2* costoF;
        } else if("Niños".equals(tipo) && "Dulces".equals(variedad)){
            vP = 4* costoF;
        } else if("Adultos".equals(tipo) && "Salados".equals(variedad)){
            vP = 4* costoF;
        } else if("Adultos".equals(tipo) && "Dulces".equals(variedad)){
            vP = 6* costoF;
        }
        return vP;
    }
    public static double precioVenta(String tipo, String variedad, int costoF, double valorProduc){
        double pV = 0;
        if("Niños".equals(tipo) && "Salados".equals(variedad)){
            pV = valorProduc + (costoF / 10);
        } else if("Niños".equals(tipo) && "Dulces".equals(variedad)){
            pV = valorProduc + (costoF / 10);
        } else if("Adultos".equals(tipo) && "Salados".equals(variedad)){
            pV = valorProduc + (costoF / 5);
        } else if("Adultos".equals(tipo) && "Dulces".equals(variedad)){
            pV = valorProduc + (costoF / 5);
        }
        return pV;
    }
}
