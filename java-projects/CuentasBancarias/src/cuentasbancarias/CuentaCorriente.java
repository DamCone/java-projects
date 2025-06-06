package cuentasbancarias;
public class CuentaCorriente extends Cuenta {

    public CuentaCorriente() {
    }

    public CuentaCorriente(String iban, float saldo) {
        super(iban, saldo);
    }
    
    public float calcularIntereses(){
        return super.saldo * super.interesAnualBasico;
    }
}
