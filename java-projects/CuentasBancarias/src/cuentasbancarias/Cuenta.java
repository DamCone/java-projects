package cuentasbancarias;
public abstract class Cuenta extends ClienteBanca{
    public String iban;
    public float saldo;
    public float interesAnualBasico = 0.2f;
    
    public Cuenta() {
    }
    public Cuenta(String iban, float saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }
    public float getSaldo() {
        return saldo;
    }

    public String getIban() {
        return iban;
    }
    
    public void ingresar(float cantidad){
        saldo = saldo + cantidad;
    }
    public void retirar(float cantidad){
        saldo = saldo - cantidad;
    }
    public void traspasar(int cantidad,Cuenta c){
        saldo = saldo - cantidad;
        c.saldo = c.saldo + cantidad;
    }

    public void setInteresAnualBasico(float interesAnualBasico) {
        this.interesAnualBasico = interesAnualBasico;
    }
    
}
