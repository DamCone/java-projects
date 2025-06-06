
package modelo;

public class Portatil extends Ordenador{
    // Atributos
    private float peso;
    private float pulgadas;

    //Constructores
    public Portatil() {
        super();
        peso = 0;
        pulgadas = 0;
    }

    public Portatil(int num_serie, String marca, String modelo, String microprocesador, 
                    String memoria, boolean lectorDVD, float peso, float pulgadas) {
        super(num_serie, marca, modelo, microprocesador, memoria, lectorDVD);
        this.peso = peso;
        this.pulgadas = pulgadas;
    }
    
    // Métodos
    @Override
    public void muestra() {}

    public float getPeso() {
        return peso;
    }

    public float getPulgadas() {
        return pulgadas;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setPulgadas(float pulgadas) {
        this.pulgadas = pulgadas;
    }
    
    
}