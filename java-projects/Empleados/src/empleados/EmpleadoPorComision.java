package empleados;
public class EmpleadoPorComision extends Empleado{
    private final double ventasTotales;
    private final double porcentajeComision;

    public EmpleadoPorComision(double ventasTotales, double porcentajeComision , String nombre, String id) throws EmpleadoInvalidoException {
        super(nombre, id);
        this.ventasTotales = ventasTotales;
        this.porcentajeComision = porcentajeComision;
        
        if (ventasTotales < 0) {
            throw new EmpleadoInvalidoException("Las ventas deben ser mayor o igual a 0");
        }
        if (porcentajeComision <= 0|| porcentajeComision > 100) {
            throw new EmpleadoInvalidoException("El porcentaje debe ser mayor a 0 y menor a 100");
        }
    }    
    
    @Override
    public double calcularSalario() {
        return ventasTotales * (porcentajeComision / 100);
       }

    @Override
    public void mostrarDetalles() {
        System.out.println("EmpleadoAsalariado{" + "nombre="+ super.getNombre()+ ", id="+ super.getId()+ ", ventas totales=" + ventasTotales + "porcentaje comisión=" + porcentajeComision + "salario=" + calcularSalario());
    }
}
