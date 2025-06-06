package sistemasolar;

import java.util.Iterator;

public class Satelite extends Planeta {
    private String nombre;
    private int masa;
    private int diametro;
    private int periodoRotacion;
    private int periodoTraslacion;
    private int distanciaMedia;

    public Satelite(String nombre, int masa, int diametro, int periodoRotacion, int periodoTraslacion, int distanciaMedia) {
        this.nombre = nombre;
        this.masa = masa;
        this.diametro = diametro;
        this.periodoRotacion = periodoRotacion;
        this.periodoTraslacion = periodoTraslacion;
        this.distanciaMedia = distanciaMedia;
    }

    public Satelite() {
    }
    
    public void imprimir(){
        System.out.println("Nombre: "+nombre+"\nMasa: "+masa+"\nDiámetro"+diametro+"\nPeriodo de rotación: "+periodoRotacion+"\nPeriodo Traslación: "
                +periodoTraslacion+"\nDistancia media: "+distanciaMedia);
    }

    public String getNombre() {
        return nombre;
    }
    
}
