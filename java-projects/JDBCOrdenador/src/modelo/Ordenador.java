
package modelo;

public abstract class Ordenador {
    // Atributos
    private int num_serie;
    private String marca;
    private String modelo;
    private String microprocesador;
    private String memoria;
    private boolean lectorDVD;

    // Constructores
    public Ordenador() {
        num_serie = 0;
        marca = "";
        modelo = "";
        microprocesador = "";
        memoria = "";
        lectorDVD = false;        
    }

    public Ordenador(int num_serie, String marca, String modelo, String microprocesador, 
                     String memoria, boolean lectorDVD) {
        this.num_serie = num_serie;
        this.marca = marca;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
        this.memoria = memoria;
        this.lectorDVD = lectorDVD;
    }

    // Métodos
    public abstract void muestra ();

    public int getNum_serie() {
        return num_serie;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMicroprocesador() {
        return microprocesador;
    }

    public String getMemoria() {
        return memoria;
    }

    public boolean isLectorDVD() {
        return lectorDVD;
    }

    public void setNum_serie(int num_serie) {
        this.num_serie = num_serie;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMicroprocesador(String microprocesador) {
        this.microprocesador = microprocesador;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public void setLectorDVD(boolean lectorDVD) {
        this.lectorDVD = lectorDVD;
    }
    
}