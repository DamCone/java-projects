package empleados;
public class EmpleadoPorHoras extends Empleado {
    private final double horasTrabajadas;
    private final double tarifaPorHora;

    public EmpleadoPorHoras(double horasTrabajadas, double tarifaPorHora, String nombre, String id) throws EmpleadoInvalidoException {
        super(nombre, id);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
        
        if(horasTrabajadas <= 0){
            throw new EmpleadoInvalidoException("Las horas trabajadas deben ser mayor a 0");
        }
        if(tarifaPorHora <= 0){
            throw new EmpleadoInvalidoException("La tarifa por hora debe ser mayor a 0");
        }
        
    }
    @Override
    public double calcularSalario(){
        return horasTrabajadas * tarifaPorHora;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("EmpleadoPorHoras{" + "nombre="+ super.getNombre()+ ", id="+ super.getId()+ ", horasTrabajadas=" + horasTrabajadas + ", tarifaPorHora=" + tarifaPorHora + ", salario=" + calcularSalario());
    }
    
    
}
