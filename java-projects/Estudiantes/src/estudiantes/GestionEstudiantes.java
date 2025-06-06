package estudiantes;
import java.util.ArrayList;
public class GestionEstudiantes {
    ArrayList <Estudiante> estudiantes = new ArrayList();
    
    public boolean agregarEstudiante(Estudiante e){
        return estudiantes.add(e);
    }
    
    public boolean eliminarEstudiante(String dni) throws Exception{
        boolean eliminado = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDni().equals(dni)) {
                estudiantes.remove(estudiante);
                eliminado = true;
                System.out.println("Estudiante eliminado.");
            } 
        }
        if (!eliminado) {
                throw new Exception("El dni no coincide. No se pudo eliminar.");
            }
        return eliminado;
    }
    
    public void buscarEstudiante(String dni) throws Exception{
        boolean encontrado = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDni().equals(dni)) {
                System.out.println(estudiante);
                encontrado = true;
            } 
        }
        if (!encontrado) {
                throw new Exception("El dni no coincide. No se pudo encontrar.");
            }
    }
    
    public void mostrarEstudiantes(){
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
}
