package cuentasbancarias;
import java.util.Scanner;
import java.util.ArrayList;

public class ClienteBanca {
    private String nombre;
    private String dni;
    private ArrayList<Cuenta> cuentas = new ArrayList();
    Scanner in = new Scanner(System.in);

    public ClienteBanca(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public ClienteBanca() {
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void aniadirCC(CuentaCorriente cc){
        cuentas.add(cc);
    }
    public void obtenerCC(){
        in.nextLine();
        System.out.print("Introduce un IBAN: ");
        String iban = in.nextLine();
        
        System.out.print("Introduce un SALDO: ");
        float saldo = in.nextFloat();
        
        CuentaCorriente cuenta = new CuentaCorriente(iban, saldo);
        cuentas.add(cuenta);
    }
    public void aniadirCA(CuentaAhorro ca){
        cuentas.add(ca);
    }
    public void obtenerCA(){
        in.nextLine();
        System.out.print("Introduce un IBAN: ");
        String iban = in.nextLine();
        
        System.out.print("Introduce un SALDO: ");
        float saldo = in.nextFloat();
        
        CuentaAhorro cuenta = new CuentaAhorro(iban, saldo);
        cuentas.add(cuenta);
    }
    public void cerrarCuenta(Cuenta c){
        cuentas.remove(c);
    }
}
