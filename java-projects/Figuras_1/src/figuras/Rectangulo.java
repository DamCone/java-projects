package figuras;
public class Rectangulo extends Figura {
    private double base;
    private double altura;
    
    public Rectangulo(float base, float altura){
        super(base);
        this.altura = altura;
    }

    public double getBase() {
        return getDim();
    }
    public void setBase(float base) {
        setDim(base);
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double perimetro(){
        return (double) ((getBase()*2) + (getAltura()*2));
    }
    public double area(){
        return (double) (getBase() * getAltura());
    }
}
