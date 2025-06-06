package empresayempleados;
import java.util.ArrayList;
import java.util.Iterator;
public class Empresa {
    private final String nombre;
    private final String cif;
    private String telefono;
    private String direccion;
    private ArrayList<Empleado> empleado = new ArrayList();
    Empleado x = null;

    public Empresa(String nombre , String cif , String telefono, String direccion) {
        this.nombre = nombre;
        this.cif = cif;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public void mostrarInfoEmpleados(){
        Iterator it = empleado.iterator();
        while(it.hasNext()){
            x = (Empleado) it.next();
            x.imprimir();
        }
    }
    public void mostrarSueldos(){
        Iterator it = empleado.iterator();
        while(it.hasNext()){
            x = (Empleado) it.next();
            System.out.println("Dni: "+x.getDni()+", Sueldo bruto: "+x.getSueldo()+", Sueldo neto: "+x.calcularNeto());
        }    
    }
    public long totalBruto(){
        Iterator it = empleado.iterator();
        long tB = 0;
        while(it.hasNext()){
            x = (Empleado) it.next();
            tB += x.getSueldo();
        }
        return tB;
    }
    public long totalNeto(){
        Iterator it = empleado.iterator();
        long tN = 0;
        while(it.hasNext()){
            x = (Empleado) it.next();
            tN += x.calcularNeto();
        }
        return tN;
    }

    public void setEmpleado(ArrayList<Empleado> empleado) {
        this.empleado = empleado;
    }
    
}
