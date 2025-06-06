
package personas;
public class Estudiante extends Persona{
    private String matricula;
    private double notaMedia;

    public Estudiante(String matricula, double notaMedia, String nombre, int edad, String dni) {
        super(nombre, edad, dni);
        this.matricula = matricula;
        this.notaMedia = notaMedia;
    }
    public String toString(){
        return super.toString() + ", Matricula: "+matricula+"Nota Media: "+notaMedia;
    }
    public String getDni() {
        return super.getDni();
    }
    public void setDni(String dni){
        super.setDni(dni);
    }
}
