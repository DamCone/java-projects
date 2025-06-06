package empleado;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner inI = new Scanner(System.in);
        Scanner inL = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList();
        boolean seguir = true;
        
        while(seguir){
            try{
                System.out.print("1.Crear Empleado por horas. \n2.Crear empleado asalariado.\n3.Crear empleado por comisión.\n4.Listar empleados.\n5.Salir.\nIntroduce un número: ");
                int num = inI.nextInt();
                switch(num){
                    case 1:
                        System.out.print("Introduce el nombre: ");
                        String nombre = inL.nextLine();
                        
                        System.out.print("Introduce el id: ");
                        String id = inL.nextLine();
                        
                        System.out.print("Introduce las horas trabajadas: ");
                        double horasTrabajadas = inI.nextDouble();
                        
                        System.out.print("Introduce la tarifa por hora: ");
                        double tarifaPorHora = inI.nextDouble();
                        EmpleadoPorHoras  eh = new EmpleadoPorHoras(horasTrabajadas, tarifaPorHora, nombre, id);
                        empleados.add(eh);
                        System.out.println("Empleado creado!");
                        break;
                    case 2:
                        System.out.print("Introduce el nombre: ");
                        nombre = inL.nextLine();
                        
                        System.out.print("Introduce el id: ");
                        id = inL.nextLine();
                        
                        System.out.print("Introduce el salario mensual: ");
                        double salarioMensual = inI.nextDouble();
                        
                        EmpleadoAsalariado ea = new EmpleadoAsalariado(salarioMensual, nombre, id);
                        empleados.add(ea);
                        System.out.println("Empleado creado!");
                        break;
                    case 3:
                        System.out.print("Introduce el nombre: ");
                        nombre = inL.nextLine();
                        
                        System.out.print("Introduce el id: ");
                        id = inL.nextLine();
                        
                        System.out.print("Introduce las ventas totales: ");
                        double ventasTotales = inI.nextDouble();
                        
                        System.out.print("Introduce el porcentaje de comisión: ");
                        double porcentajeComision = inI.nextDouble();
                        
                        EmpleadoPorComision ec = new EmpleadoPorComision(ventasTotales, porcentajeComision, nombre, id);
                        empleados.add(ec);
                        System.out.println("Empleado creado!");
                        break;
                    case 4:
                        for (Empleado emp : empleados) {
                            emp.mostrarDetalles();
                        }
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        seguir = false;
                        break;
                    default:
                        System.out.println("Número incorecto");
                }
            }
            catch(InputMismatchException e){
                    System.out.println("Te has equivocado de tipo de valor.");
                    System.out.println(e.getMessage());
                    inI.nextLine();
                }
            catch(NumberFormatException e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            finally{
                
            }
        }
    }

}
