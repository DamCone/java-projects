
package veiculos;


public class Helicoptero extends Aereo{
    private int numeroHelices;
    public Helicoptero(String matricula, String modelo, int asientos, int numeroHelices) {
        super(matricula, modelo, asientos);
        this.numeroHelices = numeroHelices;
    }
    public void imprimir(){
        super.imprimir();
        System.out.println("Número de helices: "+numeroHelices);
    }
}
