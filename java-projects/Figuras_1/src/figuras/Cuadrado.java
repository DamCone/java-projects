package figuras;
public class Cuadrado extends Figura{
    private double lado;
    
    public Cuadrado(float base){
        super(base); 
    }

    /**
     * @return the lado
     */
    public double getLado() {
        return getDim();
    }

    /**
     * @param lado the lado to set
     */
    public void setLado(float lado) {
        setDim(lado);
    }
    public double perimetro(){
        return (double) ((getLado()*4));
    }
    public double area(){
        return (double) (getLado() * getLado());
    }
}
