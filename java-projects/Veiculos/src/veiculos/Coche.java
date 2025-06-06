package veiculos;
public class Coche extends Terrestre{
    private boolean aireAcondicionado;
    
    public Coche(String matricula, String modelo, int numeroRuedas, boolean aireAcondicionado) {
        super(matricula, modelo, numeroRuedas);
        this.aireAcondicionado = aireAcondicionado;
    }
    public void imprimir(){
        super.imprimir();
        if (aireAcondicionado) {
            System.out.println("Tiene aire acondicionado.");   
        } else {
            System.out.println("No tiene aire acondicionado.");
        }
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }
    
}
