package empleado;

import java.util.regex.*;

public abstract class Empleado {
    private final String nombre;
    private final String id;

    public Empleado(String nombre, String id) throws EmpleadoInvalidoException {
        this.nombre = nombre;
        this.id = id;
        Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher m = p.matcher(nombre);
        if (!m.matches()) {
            throw new EmpleadoInvalidoException("Debe haber un nombre.");
        }
        m = p.matcher(id);
        if (!m.matches()) {
            throw new EmpleadoInvalidoException("Debe haber un id.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }
    
    public abstract double calcularSalario();
    
    public abstract void mostrarDetalles();
}
