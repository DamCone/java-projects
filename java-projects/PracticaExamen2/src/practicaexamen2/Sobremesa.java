
package practicaexamen2;

public class Sobremesa extends Ordenador {
    // Atributos
    private int numUSB;
    private boolean tarjetaSonido;
    private String tamaño;
    
    // Constructores
    public Sobremesa() {
        super(); 
        numUSB = 0;
        tarjetaSonido = false;
        tamaño = "";
    }

    public Sobremesa(int num_serie, String marca, String modelo, String microprocesador, 
            String memoria, boolean lectorDVD, int numUSB, boolean tarjetaSonido, String tamaño) {
        super(num_serie, marca, modelo, microprocesador, memoria, lectorDVD);
        this.numUSB = numUSB;
        this.tarjetaSonido = tarjetaSonido;
        this.tamaño = tamaño;
    }
    
    // Métodos
    @Override
    public void muestra() {
    
    }

    public int getNumUSB() {
        return numUSB;
    }

    public boolean isTarjetaSonido() {
        return tarjetaSonido;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setNumUSB(int numUSB) {
        this.numUSB = numUSB;
    }

    public void setTarjetaSonido(boolean tarjetaSonido) {
        this.tarjetaSonido = tarjetaSonido;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
    
    
}
