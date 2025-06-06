
package veiculos;


public class Avion extends Aereo{
    private int tiempoMax;
    public Avion(String matricula, String modelo, int asientos, int tiempoMax) {
        super(matricula, modelo, asientos);
        this.tiempoMax = tiempoMax;
    }
    public void imrimir(){
        super.imprimir();
        System.out.println("Tiempo máximo de vuelo: "+tiempoMax);
    }
}
