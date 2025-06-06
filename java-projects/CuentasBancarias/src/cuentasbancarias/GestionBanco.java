package cuentasbancarias;
import java.util.Scanner;
import java.util.ArrayList;

public class GestionBanco {
    public static void main(String[] args) {
        ArrayList<ClienteBanca> cli = new ArrayList();
        ArrayList<Cuenta> cuentas = new ArrayList();
        Scanner in = new Scanner(System.in);
        boolean seguir = true;
        
        while(seguir){
            System.out.println("1.Crear un cliente.\n" +
                "2.Abrir una cuenta corriente.\n" +
                "3.Abrir una cuenta de ahorro.\n" +
                "4.Listar clientes.\n" +
                "5.Listar Cuentas de un cliente.\n" +
                "6.Listar todas las cuentas bancarias\n" +
                "7.Modificar el porcentaje de intereses.\n" +
                "8.Cerrar cuenta. \n" +
                "9.Salir. ");
            int opcion = in.nextInt();
            in.nextLine();
            switch (opcion){
                case 1:
                    System.out.print("Introduce nombre: ");
                    String n = in.nextLine();
                    
                    System.out.print("Introduce dni: ");
                    String dni = in.nextLine();
                    
                    ClienteBanca cliente = new ClienteBanca(n,dni);
                    cli.add(cliente);
                    break;
                case 2:
                    System.out.println("Introduce el dni del titular de la cuenta: ");
                    dni = in.nextLine();
                    
                    boolean esCorrecto = false;
                    for(ClienteBanca x : cli){
                        if(x.getDni().equals(dni)){
                            x.obtenerCC();
                            esCorrecto = true;
                        } 
                    }
                    if (!esCorrecto) {
                        System.out.println("Dni incorrecto.");
                    }
                    break;
                case 3:
                    esCorrecto = false;
                    System.out.print("Introduce el dni del cliente: ");
                    dni = in.nextLine();
                    for(ClienteBanca x : cli){
                        if (x.getDni().equals(dni)) {
                            esCorrecto = true;
                            x.obtenerCA();
                        }
                    }
                    if (!esCorrecto) {
                        System.out.println("Dni incorrecto.");
                    }
                    break;
                case 4:
                    int i = 0;
                    for(ClienteBanca x : cli){
                        i++;
                        System.out.println("Cliente "+i+", Nombre: "+x.getNombre()+ ", DNI: "+x.getDni());
                    }
                    break;
                case 5:
                    esCorrecto = false;
                    System.out.print("Introduce el dni: ");
                    dni = in.nextLine();
                    
                    for(ClienteBanca x : cli){
                        if(x.getDni().equals(dni)){
                            esCorrecto = true;
                            for(Cuenta y : x.getCuentas()){
                                System.out.println("Iban: "+y.getIban()+ ", Saldo: "+ y.getSaldo());
                            }
                        }
                    }
                    if (!esCorrecto) {
                        System.out.println("Dni incorrecto.");
                    }
                    break;
                case 6:
                    for(ClienteBanca x : cli){
                        for(Cuenta y : x.getCuentas()){
                            System.out.println("Iban: "+y.getIban()+ ", Saldo: "+ y.getSaldo());
                        }
                    }
                    break;
                case 7:
                    esCorrecto = false;
                    System.out.print("Introduce el dni del cliente: ");
                    dni = in.nextLine();
                    System.out.print("Introduce el iban de la cuenta a la que cambiar los intereses: ");
                    String iban = in.nextLine();
                    System.out.print("Introduce el porcentaje de intereses base: ");
                    float intereses = in.nextFloat();
                    
                    for(ClienteBanca x : cli){
                        if (x.getDni().equals(dni)) {
                            for(Cuenta y : x.getCuentas()){
                                if (y.getIban().equals(iban)) {
                                    y.interesAnualBasico = intereses / 100;
                                    System.out.println("Ahora los intereses son: "+(intereses/100));
                                    esCorrecto = true;
                                }
                            }
                        }
                    }
                    if (!esCorrecto) {
                        System.out.println("Dni o iban incorrectos.");
                    }
                    break;
                case 8:
                    esCorrecto = false;
                    System.out.print("Introduce el dni del cliente: ");
                    dni = in.nextLine();
                    System.out.print("Introduce el iban: ");
                    iban = in.nextLine();
                    
                    for(ClienteBanca x : cli){
                        if (x.getDni().equals(dni)) {
                            for(Cuenta y : x.getCuentas()){
                                if (y.getIban().equals(iban)) {
                                    x.cerrarCuenta(y);
                                    esCorrecto = true;
                                }
                            }
                        }
                    }
                    if (!esCorrecto) {
                        System.out.println("Dni o iban incorrectos.");
                    }
                    break;
                case 9:
                    seguir = false;
                    break;
                default:
                    System.out.println("Numero incorrecto.");
            }
        }
        
    }

}
