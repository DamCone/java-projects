package estudiantes;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner inS = new Scanner(System.in);
        Scanner inI = new Scanner(System.in);
        GestionEstudiantes ge = new GestionEstudiantes();
        
        boolean seguir = true;
            while (seguir) {
                try{
                    System.out.print("1.Agregar un estudiante.\n" +
                    "2.Eliminar un estudiante por DNI.\n" +
                    "3.Buscar un estudiante por DNI.\n" +
                    "4.Mostrar todos los estudiantes.\n" +
                    "5.Salir del programa.\n" + 
                    "Introduce número: ");
                    int menu = inI.nextInt();
                    switch(menu){
                        case 1:

                            System.out.print("Introduce DNI: ");
                            String dni = inS.nextLine();

                            System.out.print("Introduce Nombre: ");
                            String nombre = inS.nextLine();

                            System.out.print("Introduce Edad: ");
                            int edad = inI.nextInt();

                            System.out.print("Introduce Matricula: ");
                            String matricula = inS.nextLine();

                            System.out.print("Introduce notaMedia: ");
                            int notaMedia = inI.nextInt();

                            Estudiante e = new Estudiante(matricula, notaMedia, nombre, edad, dni);

                            ge.agregarEstudiante(e);
                            break;
                        case 2:
                            System.out.print("Introduce el DNI: ");
                            ge.eliminarEstudiante(inS.nextLine());
                            break;
                        case 3:
                            System.out.print("Introduce DNI: ");
                            ge.buscarEstudiante(inS.nextLine());
                            break;
                        case 4:
                            ge.mostrarEstudiantes();
                            break;
                        case 5:
                            seguir = false;
                            break;
                        default:
                            System.out.println("El número debe estar entre el 1 y el 5.");
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("Te has equivocado de tipo de valor.");
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();

                } finally {
                    inI.nextLine();
                }
            
        }
        
        
        
    }

}
