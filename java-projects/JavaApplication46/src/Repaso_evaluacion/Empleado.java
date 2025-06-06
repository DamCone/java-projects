package Repaso_evaluacion;

/**
 *
 * @author : EVA MARÍA GÓMEZ ABAD
 */


// Clase abstracta Empleado
abstract class Empleado {
    protected String nombre;
    protected String id;

    //Null:Indica que la referencia no apunta a ningún objeto en memoria. Es decir, no hay un valor asignado 
    //a la variable.
    //isEmpty: Es un método de la clase String que verifica si la cadena está vacía,
    //es decir, si tiene una longitud (length) de 0.
    public Empleado(String nombre, String id) throws EmpleadoInvalidoException {
        if (nombre == null || nombre.isEmpty() || id == null || id.isEmpty()) {
            throw new EmpleadoInvalidoException("El nombre y el ID no pueden estar vacíos.");
        }
        this.nombre = nombre;
        this.id = id;
    }

    public abstract double calcularSalario();
    public abstract void mostrarDetalles();
}
