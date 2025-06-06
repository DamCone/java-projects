
package personas;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorEstudiantes {
    ArrayList <Estudiante> estudiantes = new ArrayList();
    public boolean agregarEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
        return estudiantes.contains(estudiante);
    }
    
    public Estudiante buscarEstudiante(String dni){
        Estudiante e = new Estudiante(null,0,null,0,null);
        Iterator it = estudiantes.iterator();
        while(it.hasNext()){
            Estudiante es = (Estudiante) it.next();
            if (es.getDni().equals(dni)) {
                e = es;
            }
        }
        return e;
    }
    public boolean eliminarEstudiantes(String dni){
        boolean x = false;
        
        Iterator it = estudiantes.iterator();
        while(it.hasNext()){
            Estudiante est = (Estudiante) it.next();
            if(est.getDni().equals(dni)){
                it.remove();
                x = true;
            }
            
        }
        return x;
    }
    public void mostrarEstudiantes(){
        int i = 1;
        for(Estudiante e : estudiantes){
            System.out.println("Estudiante "+(i)+": "+ e);
            i++;
        }
    }
    
}
