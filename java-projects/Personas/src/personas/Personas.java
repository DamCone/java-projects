package personas;
import java.util.Scanner;
public class Personas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean seguir = true;
        GestorEstudiantes ge = new GestorEstudiantes();
        
        while(seguir){
            System.out.print("1.Agregar un estudiante.\n" +
                "2.Eliminar un estudiante por DNI.\n" +
                "3.Buscar un estudiante por DNI.\n" +
                "4.Mostrar todos los estudiantes.\n" +
                "5.Salir del programa.\nIntroduce un número para continuar: ");
            int num = in.nextInt();
            
            switch(num){
                case 1:
                    in.nextLine();
                    System.out.print("Introduce el nombre del estudiante: ");
                    String nombre = in.nextLine();
                    
                    System.out.print("Introduce la edad del estudiante: ");
                    int edad = in.nextInt();
                    in.nextLine();
                    System.out.print("Introduce el dni del estudiante: ");
                    String dni = in.nextLine();
                    
                    System.out.print("Introduce la matricula del estudiante: ");
                    String matricula = in.nextLine();
                    
                    System.out.print("Introduce la nota media del estudiante: ");
                    double nm = in.nextDouble();
                    Estudiante estudiante1 = new Estudiante(matricula, nm, nombre, edad, dni);
                    boolean aniadido = ge.agregarEstudiante(estudiante1);
                    if (aniadido) {
                        System.out.println("");
                        System.out.println("Estudiante añadido.");
                        System.out.println("");
                    }
                    break;
                case 2:
                    in.nextLine();
                    System.out.print("Introduce el DNI: ");
                    dni = in.nextLine();
                    
                    boolean eliminado = ge.eliminarEstudiantes(dni);
                    if (eliminado) {
                        System.out.println("");
                        System.out.println("Estudiante eliminado.");
                        System.out.println("");
                    } else{
                        System.out.println("");
                        System.out.println("DNI no coincide.");
                        System.out.println("");
                    }
                    break;
                case 3:
                    in.nextLine();
                    System.out.print("Introduce el DNI: ");
                    dni = in.nextLine();
                    System.out.println("");
                    Estudiante estudiante2 = new Estudiante(null,0,null,0,null);
                    
                    estudiante2 = ge.buscarEstudiante(dni);
                    if (estudiante2.getDni() != null) {
                        System.out.println("");
                        System.out.println("Estos son los datos de tu estudiante: ");
                        System.out.println("");
                        System.out.println(estudiante2.toString());
                    } else{
                        System.out.println("No existe.");
                    }
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Estos son todos los estudiantes: ");
                    System.out.println("");
                    ge.mostrarEstudiantes();
                    break;
                case 5:
                    seguir = false;
                    break;
                default:
                    System.out.println("El número es incorrecto");
                    break;
            }
        }
        
    }

}
