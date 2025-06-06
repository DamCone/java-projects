
package veiculos;


public class Moto extends Terrestre{
    private String color;
    public Moto(String matricula, String modelo, int numeroRuedas, String color) {
        super(matricula, modelo, numeroRuedas);
        this.color = color;
    }
    public void imprimir(){
        super.imprimir();
        System.out.println("Color: "+color);
    }
}
