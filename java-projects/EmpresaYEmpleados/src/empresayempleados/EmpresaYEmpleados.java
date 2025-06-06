package empresayempleados;
import java.util.ArrayList;

public class EmpresaYEmpleados {
    public static void main(String[] args) {
        Empresa e1 = new Empresa("e1", "CIF1", "244123890", "c/3 piso1");
        Empleado emp1 = new Empleado("Eugenia", "21394D", 1200);
        Empleado emp2 = new Empleado("Eugenio", "21394F", 1900);
        Empleado emp3 = new Empleado("Eustaquia", "21394W", 2500);
        
        ArrayList<Empleado> listaEmp = new ArrayList();
        listaEmp.add(emp1);
        listaEmp.add(emp2);
        listaEmp.add(emp3);
        listaEmp.remove(1);
        e1.setEmpleado(listaEmp);
        
        e1.mostrarInfoEmpleados();
        e1.mostrarSueldos();
        System.out.println("Sueldo bruto de todos los empleados: "+e1.totalBruto());
        System.out.println("Sueldo bruto de todos los empleados: "+e1.totalNeto());
    }

}
