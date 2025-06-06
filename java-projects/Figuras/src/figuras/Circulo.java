package figuras;
public class Circulo {
    private double radio;
    
    public Circulo(){}
    
    public Circulo(double radio){
        this.radio = radio;
    }
    
    public Circulo(Circulo c){
        radio = c.radio;
    }

    /**
     * @return the radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }
    public double perimetro(){
        return (2 * Math.PI * getRadio());
    }
    public double area(){
        return Math.PI * (Math.pow (getRadio(), 2));
    }
}
