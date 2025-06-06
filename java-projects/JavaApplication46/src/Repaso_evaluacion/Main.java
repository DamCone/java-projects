package Repaso_evaluacion;

/**
 *
 * @author : EVA MARÍA GÓMEZ ABAD
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    
    /**Cuando se combina static y final, se crea una constante de clase. Esto significa:

Constante única para toda la clase: La variable tiene un único valor compartido por todas las instancias.

Inmutabilidad: El valor no se puede modificar después de ser inicializado.

Acceso sin instanciar: Se puede acceder directamente desde la clase.
**/

    private static final Pattern TEXTO_VALIDO = Pattern.compile("^[a-zA-Z0-9 ]+?");
    private static final Scanner entrada = new Scanner(System.in);
    private static final ArrayList<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    crearEmpleadoPorHoras();
                    break;
                case 2:
                    crearEmpleadoAsalariado();
                    break;
                case 3:
                    crearEmpleadoPorComision();
                    break;
                case 4:
                    listarEmpleados();
                    break;
                case 5:
                    continuar = false;
                    salirDelPrograma();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Menú ===");
        System.out.println("1. Crear Empleado Por Horas");
        System.out.println("2. Crear Empleado Asalariado");
        System.out.println("3. Crear Empleado Por Comisión");
        System.out.println("4. Listar Empleados");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearEmpleadoPorHoras() {
        try {
            System.out.print("Introduce el nombre del empleado: ");
            String nombre = entrada.next();
            validarTexto(nombre);

            System.out.print("Introduce el ID del empleado: ");
            String id = entrada.next();
            validarTexto(id);

            System.out.print("Introduce las horas trabajadas: ");
            double horas = entrada.nextDouble();

            System.out.print("Introduce la tarifa por hora (?): ");
            double tarifa = entrada.nextDouble();

            empleados.add(new EmpleadoPorHoras(nombre, id, horas, tarifa));
            
            System.out.println("¡Empleado por horas creado correctamente!");
            
            //Ejemplo con catch separados y utilizando finally para limpiar el buffer
            //Hacemos excepciones desde la más explicita a la más general.
            //Siempre captura primero las excepciones más específicas y luego las más generales.  
            //Desde Java 7, es posible capturar múltiples excepciones en un solo bloque catch utilizando el operador |
            
        } catch (EmpleadoInvalidoException e) {
            System.out.println(e.getMessage()); 
        } catch (NumberFormatException e) {
            System.out.println("Error al crear el empleado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inexperado: " + e.getMessage());
                
        } finally {
            entrada.nextLine();
        } 
    }

    private static void crearEmpleadoAsalariado() {
        try {
            System.out.print("Introduce el nombre del empleado: ");
            String nombre = entrada.next();
            validarTexto(nombre);

            System.out.print("Introduce el ID del empleado: ");
            String id = entrada.next();
            validarTexto(id);

            System.out.print("Introduce el salario mensual (?): ");
            double salarioMensual = entrada.nextDouble();

            empleados.add(new EmpleadoAsalariado(nombre, id, salarioMensual));
            System.out.println("¡Empleado asalariado creado correctamente!");
        } catch (EmpleadoInvalidoException | NumberFormatException e) {
            System.out.println("Error al crear el empleado: " + e.getMessage());
        }
    }

    private static void crearEmpleadoPorComision() {
        try {
            System.out.print("Introduce el nombre del empleado: ");
            String nombre = entrada.next();
            validarTexto(nombre);

            System.out.print("Introduce el ID del empleado: ");
            String id = entrada.next();
            validarTexto(id);

            System.out.print("Introduce las ventas totales (?): ");
            double ventasTotales = entrada.nextDouble();

            System.out.print("Introduce el porcentaje de comisión (%): ");
            double porcentajeComision = entrada.nextDouble();

            empleados.add(new EmpleadoPorComision(nombre, id, ventasTotales, porcentajeComision));
            System.out.println("¡Empleado por comisión creado correctamente!");
        } catch (EmpleadoInvalidoException | NumberFormatException e) {
            System.out.println("Error al crear el empleado: " + e.getMessage());
        }
    }

    private static void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (int i = 0; i < empleados.size(); i++) { 
                empleados.get(i).mostrarDetalles();
            }
        }
    }

    private static void salirDelPrograma() {
        System.out.println("¡Saliendo del sistema!");
        entrada.close();
    }

    private static void validarTexto(String texto) throws NumberFormatException {
        if (!TEXTO_VALIDO.matcher(texto).matches()) {
            throw new NumberFormatException("El texto ingresado no es válido.");
        }
    }
}
