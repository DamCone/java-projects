package cuentasbancarias;
public class CuentaAhorro extends Cuenta {
    private int sueldoMinimo = 1000;

    public CuentaAhorro() {
    }

    public CuentaAhorro(String iban, float saldo) {
        super(iban, saldo);
    }
    
    public float calcularIntereses(){
        float interes = super.interesAnualBasico;
        if (super.saldo < sueldoMinimo) {
            interes = super.interesAnualBasico / 2;
        } else {
            interes = super.interesAnualBasico * 2;
        }
        saldo = saldo * interes;
        return saldo;
    }
    
}
