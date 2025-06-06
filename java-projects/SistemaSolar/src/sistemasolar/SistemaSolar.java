package sistemasolar;
import java.util.Scanner;
import java.util.ArrayList;

public class SistemaSolar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <Planeta> listaPlanetas = new ArrayList();
        ArrayList <Satelite> listaSatelites = new ArrayList();
        ArrayList <Satelite> listaSatelites2 = new ArrayList();
        Planeta p1 = new Planeta("p1",1,2,3,4);
        Planeta p2 = new Planeta("p2",2,3,4,5);
        Planeta p3 = new Planeta("p3",3,4,5,6);
        Satelite s1 = new Satelite("s1",1,2,3,4,5);
        Satelite s2 = new Satelite("s2",2,3,4,5,6);
        Satelite s3 = new Satelite("s3",3,4,5,6,7);
        listaSatelites.add(s1);
        listaSatelites2.add(s2);
        listaSatelites2.add(s3);
        p1.setListaSatelites(listaSatelites2);
        p2.setListaSatelites(listaSatelites);
        listaPlanetas.add(p1);
        listaPlanetas.add(p2);
        listaPlanetas.add(p3);
        
        System.out.print("Introduce el nombre del planeta a consultar: ");
        String nombre = in.nextLine();
        boolean encontrado = false;
        for(Planeta x: listaPlanetas){
            if (x.getNombre().equals(nombre)){
                encontrado = true;
                x.imprimirP();
            }
        }
        if (encontrado == false){
            System.out.println("El planeta no existe.");
        }
        
        System.out.print("Introduce el nombre del satelite a consultar: ");
        nombre = in.nextLine();
        encontrado = false;
        for(Satelite x: listaSatelites){
            if (x.getNombre().equals(nombre)){
                encontrado = true;
                x.imprimir();
            }
        }
        if (encontrado == false){
            System.out.println("El Satelite no existe.");
        }
        
    }

}
