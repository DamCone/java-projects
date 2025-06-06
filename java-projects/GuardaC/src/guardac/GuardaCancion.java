package guardac;
import java.util.Scanner;
public class GuardaCancion {

    Scanner in = new Scanner(System.in);
    private String cliente;
    private String cancion;
    private String fecha;
    private float duracion = 3.00f;
    
    public GuardaCancion(){}
    public GuardaCancion(String cliente, String cancion, String fecha, float duracion){
        this.cliente = cliente;
        this.cancion = cancion;
        this.fecha = fecha;
    }
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCancion() {
        return cancion;
    }
    
    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    /**
     * @return the duracion
     */
    public float getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
}
