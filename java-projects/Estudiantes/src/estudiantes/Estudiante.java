package estudiantes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Estudiante extends Persona{
    private String matricula;
    private double notaMedia;

    public Estudiante(String matricula, double notaMedia, String nombre, int edad, String dni) throws Exception{
        super(nombre, edad, dni);
        this.matricula = matricula;
        this.notaMedia = notaMedia;
        Pattern p = Pattern.compile("[A-Za-z]{3,50}");
        Matcher m = p.matcher(nombre);
        if (!m.matches()) {
            throw new Exception("El nombre debe tener de 3 a 50 caracteres que no sean números.");
        }
        if (edad < 0 || edad > 100) {
            throw new Exception("La edad no puede ser menor a 0 o mayor a 100.");
        }
        Pattern pa = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
        Matcher ma = pa.matcher(dni);
        if (!ma.matches()) {
            throw new Exception("El DNI no es válido.");
        }
        if (notaMedia > 10 || notaMedia < 0) {
            throw new Exception("La nota media no puede seer inferior a 0 o superior a 10.");
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    @Override
    public String toString() {
        return super.toString() + ", matricula=" + matricula + ", notaMedia=" + notaMedia;
    }
    
}
