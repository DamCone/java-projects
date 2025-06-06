package figuras;
public class Rectangulo {
    private double base;
    private double altura;
    
    public Rectangulo(){}
    
    public Rectangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    /**
     * @return the base
     */
    public double getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(double base) {
        this.base = base;
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
