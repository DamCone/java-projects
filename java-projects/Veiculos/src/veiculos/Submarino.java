
package veiculos;


public class Submarino extends Acuatico{
    private int profundidadMax;
    public Submarino(String matricula, String modelo, int slora, int profundidadMax) {
        super(matricula, modelo, slora);
        this.profundidadMax = profundidadMax;
    }
    public void imprimir(){
        super.imprimir();
        System.out.println("Profundidad máxima: "+ profundidadMax);
    }
}
