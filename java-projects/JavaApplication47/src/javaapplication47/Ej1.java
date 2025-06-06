package javaapplication47;
import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Ej1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce la ruta: ");
        String ruta = in.nextLine();
        File f = new File(ruta);
        try {
            muestraInfoRuta(f);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        in.close();
    }
    static void muestraInfoRuta(File f) throws FileNotFoundException{
        
        if (f.exists()) {
            System.out.println("Existe!");
            if (f.isFile()) {
                System.out.println("Nombre del archivo: A_"+f.getName());
            } else if(f.isDirectory()){
                String [] fi = f.list();
                if (f != null){
                    for (int i = 0; i < fi.length; i++) {
                        File file = new File(f, fi[i]);

                        if (file.isDirectory()) {
                            System.out.println("Nombre del directorio: *_"+file.getName());
                        }
                    }
                    for (int i = 0; i < fi.length; i++) {
                        File file = new File(f, fi[i]);

                        if (file.isFile()) {
                            System.out.println("Nombre del archivo: A_"+file.getName());
                        }
                    }
                } else {
                    System.out.println("Error al listar el directorio.");
                }
            }
        } else{
            throw new FileNotFoundException("La ruta no existe... \nPrograma finalizado.");
        }
    }
}
