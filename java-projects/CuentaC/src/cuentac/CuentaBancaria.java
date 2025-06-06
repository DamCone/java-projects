package cuentac;
import java.util.regex.*;
public class CuentaBancaria {

    private String iban;
    private String titular;
    private float saldo;
    private String movimientos;
    
    public CuentaBancaria(){
    }
    
    public boolean crearCuenta(){
        boolean c = true;
        Pattern ib = Pattern.compile("^[A-Z]{2}[0-9]{22}$");
        Matcher mi = ib.matcher(iban);
        Pattern ti = Pattern.compile("[A-Za-z]{1,50}");
        Matcher mt = ti.matcher(titular);
        
        if (mi.matches() && mt.matches()){
            saldo = 0;
            movimientos = "Cuenta creada.\n";
        } else{
            c = false;
        }
        return c;
    }

    public boolean ingreso(float cantIngreso){
        boolean b = true;
        if (cantIngreso > 0) {
            saldo += cantIngreso;
            if (saldo > 3000) {
                System.out.println("AVISO: Notificar a acienda.");
            }
            movimientos += "\n-Realizado ingreso de: "+ cantIngreso + " euros.";
        } else{
            b = false;
        }
        return b;
    }
    
    public boolean retirada(float cantRetirada){
        boolean b = true;
        if (cantRetirada > 0) {
            if (saldo - cantRetirada < -50) {
                b = false;
            } else if(saldo - cantRetirada < 0){
                saldo -= cantRetirada;
                System.out.println("AVISO: Saldo negativo.");
                movimientos += "\n-Realizada retirada de: "+ cantRetirada + " euros.";
            } else{
                saldo -= cantRetirada;
                movimientos += "\n-Realizada retirada de: "+ cantRetirada + " euros.";
            }
        } else{
            b = false;
        }
        return b;
    }
    
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    
    public String getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(String movimientos) {
        this.movimientos = movimientos;
    }
}
