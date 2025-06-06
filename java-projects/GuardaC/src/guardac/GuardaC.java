package guardac;
import java.util.Scanner;
public class GuardaC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GuardaCancion g = new GuardaCancion();
        Album a = new Album();
        a.setId(123);
        a.setAnyo(1983);
        a.setTitulo("EsteEsElTitulo");
        a.setImagen("imagen");
        a.setPatrocinado(true);
        a.setLista("Cancion1, Cancion2, Cancion3");
        
        boolean seguir = true;
        
        while(seguir){
            System.out.print("0.Para salir.\n1.Para guardar una canción.\n2.Para añadir cancion a un album\n3.Para Modificar canción.\nIntroduce respuesta: ");
            int menu = in.nextInt();
            if(menu == 1){
                in.nextLine();
                System.out.print("Introduce tu nombre: ");
                g.setCliente(in.nextLine());
                
                System.out.print("Introduce el nombre de la canción: ");
                g.setCancion(in.nextLine());
                
                System.out.print("Introduce la fecha: ");
                g.setFecha(in.nextLine());
                
                System.out.println("Cancion guardada.\nCliente: "+g.getCliente()+"\nCanción: "+g.getCancion()+"\nFecha: "+g.getFecha());
            } else if (menu == 0) {
                System.out.println("Salimos.");
                seguir = false;
            } else if (menu == 2) {
                String can;
                in.nextLine();
                System.out.print("Introduce una nueva canción a la lista: ");
                can = in.nextLine();
                a.anyadirC(can);
                System.out.println("Cancion añadida: \n"+ a.getLista());
            } else if (menu == 3) {
                in.nextLine();
                System.out.print("Introduce el nombre de la canción a modificar: ");
                String t = in.nextLine();
                
                if(t.equals(g.getCancion())){
                    System.out.print("la duración de la canción selecionada es de: "+g.getDuracion()+"\nIntroduce la nueva duracion: ");
                    g.setDuracion(in.nextFloat());
                    
                    System.out.println("La nueva duración es de: "+ g.getDuracion());
                } else{
                    System.out.println("La canción introducida no existe.");
                }
                
            } else{
                System.out.println("El número introducido no es correcto.");
            }
        }
        
    }

}
