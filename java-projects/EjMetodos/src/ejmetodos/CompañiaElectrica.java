package ejmetodos;
import java.util.Scanner;
import java.util.regex.*;
public class CompañiaElectrica {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean seguir = true;
        while(seguir){
            double totalAPagar = 0;

            String numContrato = numContrato(in);

            System.out.print("Introduzca su nombre: ");
            String nombre = in.nextLine();

            String potContratada = potContratada(in);

            double kWConsumidos = kWConsumidos(in);

            double calculaImporte = calculaImporte(in, potContratada, kWConsumidos);

            double calculaIncremento = calculaIncremento(calculaImporte, kWConsumidos);
            totalAPagar = calculaImporte + calculaIncremento;

            informe(numContrato, nombre, potContratada, kWConsumidos, 
                    calculaImporte, calculaIncremento, totalAPagar);
            System.out.println("Desea consultar otra vez? s/n");
            String r = in.nextLine();
            if("n".equals(r) || "N".equals(r)){seguir = false;}
        }
        
    }
    public static String numContrato(Scanner in){
        String nC = "";
        boolean seguir = true;
        while(seguir){
            System.out.print("Introduce el número del contrato(ejemplo: 543-2111): ");
            nC = in.nextLine();
            Pattern p = Pattern.compile("\\d\\d\\d-\\d\\d\\d\\d");
            Matcher m = p.matcher(nC);
            if (m.matches()) {
                seguir= false;
            } else  {
                System.out.println("Introduce correctamente el número. ");
            }
        }
        return nC;
    }
    public static String potContratada(Scanner in){
        String pC = "";
        boolean seguir = true;
        while(seguir){
            System.out.print("Introduce la potencia contratada(2,30/3,45/4,60/5,75/6,90/8,05): ");
            pC = in.nextLine();
            Pattern p = Pattern.compile("2,30|3,45|4,60|5,75|6,90|8,05");
            Matcher m = p.matcher(pC);
            if (m.matches()) {    
                seguir= false;
            } else  {
                System.out.println("Introduce correctamente la potencia. ");
            }
        }
        return pC;
    }
    public static double kWConsumidos(Scanner in){
        double kW = 0;
        double lAnterior = 0;
        double lActual = 0;
        
        System.out.print("Introduce la lectura anterior del contador: ");
        lAnterior = in.nextDouble();
        
        System.out.print("Introduce la lectura actual del contador: ");
        lActual = in.nextDouble();
        
        kW = lActual - lAnterior;
        return kW;
    }
    public static double calculaImporte(Scanner in, String pC, double kWConsumidos){
        double aPagar = 0;
        switch(pC){
                    case "2,30":
                        aPagar = 7.29;
                        break;
                    case "3,45":
                        aPagar = 10.94;
                        break;
                    case "4,60":
                        aPagar = 14.58;
                        break;
                    case "5,75":
                        aPagar = 18.23;
                        break;
                    case "6,90":
                        aPagar = 21.87;
                        break;
                    case "8,05":
                        aPagar = 25.52;
                        break;
                } 
        aPagar = (kWConsumidos * 0.37204)+ aPagar;
        return aPagar;
    }
    public static double calculaIncremento(double calculaImporte, double kWConsumidos){
        double incremento = calculaImporte;
        if(kWConsumidos > 150 && kWConsumidos <= 300){
            incremento += (calculaImporte * 0.05);
        } else if(kWConsumidos > 300 && kWConsumidos <= 400){
            incremento +=(calculaImporte * 0.08);
        } else if(kWConsumidos > 400){
            incremento = (calculaImporte * 0.12);
        }
        return incremento;
    }
    public static void informe(String numContrato, String nombre, String potContratada, 
    double kWConsumidos, double calculaImporte, double calculaIncremento, double totalAPagar){
        System.out.println("Nº contrato y nombre: "+numContrato+" - "+nombre);
        System.out.println("Total kW consumidos: "+kWConsumidos);
        System.out.println("Potencia contratada: "+potContratada);
        System.out.println("Importe sin incremento: "+calculaImporte);
        System.out.println("Incremento a pagar: "+calculaIncremento);
        System.out.println("Total importe facturado: "+totalAPagar);
    }
}
