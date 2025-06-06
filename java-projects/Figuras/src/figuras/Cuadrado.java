package figuras;
public class Cuadrado {
    private double lado;
    
    public Cuadrado(){}
    
    public Cuadrado(double lado){
        this.lado = lado; 
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    public double perimetro(){
        return (double) ((getLado()*4));
    }
    public double area(){
        return (double) (getLado() * getLado());
    }
}
