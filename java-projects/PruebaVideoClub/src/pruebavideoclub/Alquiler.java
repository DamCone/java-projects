package pruebavideoclub;
public class Alquiler {
    private String tiempo;

    public Alquiler(String tiempo) {
        this.tiempo = tiempo;
    }

    public Alquiler() {
    }

    public String getTiempo() {
        return tiempo;
    }

    public DVD getDVD(){
        DVD d = new DVD();
        return d;
    }
    
    public int getPrecio(){
        int precio = 0;
        DVD d = new DVD();
        if ("Normal".equals(d.getTipo())){
            precio = 2;
        } else if (" ".equals(d.getTipo())) {
            
        }
        return precio;
    }
    
    public int getPuntos(){
        int puntos = 0;
        return puntos;
    }
}
