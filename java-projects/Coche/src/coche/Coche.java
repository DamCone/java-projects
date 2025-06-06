package coche;
public class Coche {
    private String matricula;
    private String color;
    private float cilindrada;
    private int plazas;
    private String propietario;
    
    public Coche(){}
    public Coche(String matricula, String color, float cilindrada, int plazas, String propietario){
        this.matricula = matricula;
        this.color = color;
        this.cilindrada = cilindrada;
        this.plazas = plazas;
        this.propietario = propietario;
    }
    
    public String toString(){
        return "Matricula: "+matricula+ "\nColor: "+color+"\nPropietario: "+propietario;
    }
    
    public void visualiza(){
        System.out.println("Cilindrada: "+cilindrada+"\nPlazas: "+plazas);
    }
    
    
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(float cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
