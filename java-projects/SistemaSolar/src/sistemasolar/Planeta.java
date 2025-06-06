package sistemasolar;
import java.util.ArrayList;
import java.util.Iterator;
public class Planeta {
    private String nombre;
    private int masa;
    private int diametro;
    private int periodoRotacion;
    private int distanciaMedia;
    private ArrayList <Satelite> listaSatelites = new ArrayList();
    private Satelite x;

    public Planeta(String nombre, int masa, int diametro, int periodoRotacion, int distanciaMedia) {
        this.nombre = nombre;
        this.masa = masa;
        this.diametro = diametro;
        this.periodoRotacion = periodoRotacion;
        this.distanciaMedia = distanciaMedia;
    }

    public Planeta() {
    }

    public void setListaSatelites(ArrayList<Satelite> listaSatelites) {
        this.listaSatelites = listaSatelites;
    }
    
    public void imprimirP(){
        System.out.println("Nombre: "+nombre+"\nMasa: "+masa+"\nDiámetro"+diametro+"\nPeriodo de rotación: "+periodoRotacion+"\nDistancia media: "+distanciaMedia);
        if (listaSatelites.isEmpty()){
            System.out.println("No tiene satelites.");
        } else {
            Iterator it = listaSatelites.iterator();
            int i = 0;
            while(it.hasNext()){
                i++;
                x = (Satelite) it.next();
                System.out.println("Satelite "+x.getNombre()+": ");
                x.imprimir();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }
    
}
