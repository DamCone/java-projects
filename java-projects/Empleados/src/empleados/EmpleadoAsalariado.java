package empleados;
public class EmpleadoAsalariado extends Empleado{
    private final double salarioMensual;

    public EmpleadoAsalariado(double salarioMensual, String nombre, String id) throws EmpleadoInvalidoException {
        super(nombre, id);
        this.salarioMensual = salarioMensual;
        
        if (salarioMensual < 0) {
            throw new EmpleadoInvalidoException("El salario debe ser mayor a 0");
        }
    }

    @Override
    public double calcularSalario() {
        return salarioMensual;
       }

    @Override
    public void mostrarDetalles() {
        System.out.println("EmpleadoAsalariado{" + "nombre="+ super.getNombre()+ ", id="+ super.getId()+ ", salario mensual=" + salarioMensual + ", salario=" + calcularSalario());
    }
}
