package figuras;
public class TrianguloEquilatero {
    private double base;
    private double altura;
    
    public TrianguloEquilatero(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    
    public double area(){
        return((getBase()* getAltura())/2);
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
        double lado = Math.sqrt(Math.pow(getBase()/2, 2) + Math.pow(getAltura(), 2));
        return (3*lado);
    }
}
