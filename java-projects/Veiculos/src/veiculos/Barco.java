
package veiculos;


public class Barco extends Acuatico{
    private boolean motor;
    public Barco(String matricula, String modelo, int slora, boolean motor) {
        super(matricula, modelo, slora);
        this.motor = motor;
    }
    public void imprimir(){
        super.imprimir();
        if (motor) {
            System.out.println("Tiene motor.");
        } else{
            System.out.println("No tiene motor.");
        }
    }
}
