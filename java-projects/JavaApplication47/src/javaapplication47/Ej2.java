package javaapplication47;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
public class Ej2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduce la ruta: ");
        String ruta = in.nextLine();
        
        boolean info = true;
        
        File f = new File(ruta);
        File carpetaDocs = new File(f.getParent(),"DOCS");
        File f2 = new File(carpetaDocs,"Z");
        File nums = new File(carpetaDocs, "numeros.txt");
        File notas = new File(carpetaDocs, "alumnos_notas.txt");
        
        System.out.println(f);
        try {
            muestraInfoRuta(f, info);
            renombrarDirFich(f);
           if(borraTodo(f2)){
               System.out.println("Borrado!");
           } else {
               System.out.println("No se pudo borrar.");
           }
           int max = max(nums);
           int min = min(nums);
           System.out.println("Máximo: "+max);
           System.out.println("Mínimo: "+min);
           notasMedia(notas);
           System.out.println("Introduce cuantas personas quieres crear: ");
           int n = in.nextInt();
           personas(carpetaDocs, n);
           
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        in.close();
    }
    static void muestraInfoRuta(File f, boolean info) throws FileNotFoundException{
        
        if (f.exists() && info == false) {
            System.out.println("Existe!");
            if (f.isFile()) {
                System.out.println("Nombre del archivo: A_"+f.getName());
            } else if(f.isDirectory()){
                String [] fi = f.list();
                Arrays.sort(fi);
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
        }
        
        else if (f.exists() && info == true) {
            System.out.println("Existe!");
            if (f.isFile()) {
                System.out.println("Nombre del archivo: A_"+f.getName());
            } else if(f.isDirectory()){
                String [] fi = f.list();
                Arrays.sort(fi);
                if (f != null){
                    for (int i = 0; i < fi.length; i++) {
                        File file = new File(f, fi[i]);
                        
                        if (file.isDirectory()) {
                            System.out.println("Nombre del directorio: *_"+file.getName()+ ", "+file.length()+" bytes");
                            
                        }
                    }
                    for (int i = 0; i < fi.length; i++) {
                        File file = new File(f, fi[i]);

                        if (file.isFile()) {
                            System.out.println("Nombre del archivo: A_"+file.getName()+", "+file.length()+" bytes");
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
    
    static void renombrarDirFich(File f) throws FileNotFoundException, Exception{
        if (f.exists()) {
            
            File carpetaOriginal = new File(f.getParent(), "documentos");
            File carpetaDocs = new File(f.getParent(),"DOCS");
            carpetaOriginal.renameTo(carpetaDocs);
            
            File rutaF = new File(carpetaDocs,"Fotografias");
            File nuevaRutaF = new File(carpetaDocs,"FOTOS");
            rutaF.renameTo(nuevaRutaF);
            
            File rutaL = new File(carpetaDocs,"Libros");
            File nuevaRutaL = new File(carpetaDocs,"LECTURAS");
            rutaL.renameTo(nuevaRutaL);
            
            renombrarFicheros(nuevaRutaF);
            renombrarFicheros(nuevaRutaL);
            
            
        } else{
            throw new FileNotFoundException("La ruta no existe... \nPrograma finalizado.");
        }
    }
    static void renombrarFicheros(File carpeta){
            File [] fl = carpeta.listFiles();
            for (File archivo : fl) {
                String fileName = archivo.getName();
                
                int indicePunto = fileName.lastIndexOf('.');
                
                if (indicePunto > 0) {
                    String newName = fileName.substring(0, indicePunto);
                    File nuevoArchivo = new File(archivo.getParentFile(), newName);
                    archivo.renameTo(nuevoArchivo);
                }
            }
    }
    static boolean borraTodo(File f) throws Exception{
        boolean borrado = false;
        
        if (f.exists()) {
            if (f.isFile()) {
                if(borrarFich(f)){
                    borrado = true;
                }
            } else if(f.isDirectory()){
                borrarDir(f);
                borrado = true;
            }
        } else {
            throw new Exception("No existe el fichero/directorio.");
        }
        return borrado;
    }
    static boolean borrarFich (File f){
        boolean borrado = false;
        if (f.delete()) {
            System.out.println("Fichero borrado: "+f.getName());
            borrado = true;
        }
        return borrado;
    }
    static boolean borrarDir (File f){
        boolean borrado = false;
        File [] dir = f.listFiles();
        for (File file : dir) {
            if (file.isFile()) {
                borrarFich(file);
            } else if (file.isDirectory()){
                borrarDir(file);
                file.delete();
            }
        }
        if(f.delete()){
            borrado = true;
        }
        return borrado;
    }
    static int max(File f) throws FileNotFoundException{
        int max = -999999999;
        Scanner buscador = new Scanner(f);
        
        while (buscador.hasNext()) {
            if(buscador.hasNextInt()){
                int num = buscador.nextInt();
                if(num > max){
                    max = num;
                }
            }
        }
        buscador.close();
        return max;
    }
    static int min(File f) throws FileNotFoundException{
        int min = 999999999;
        Scanner buscador = new Scanner(f);
        
        while (buscador.hasNext()) {
            if(buscador.hasNextInt()){
                int num = buscador.nextInt();
                if(num < min){
                    min = num;
                }
            }
        }
        buscador.close();
        return min;
    }
    static void notasMedia(File f) throws FileNotFoundException, IOException{
        Scanner s = new Scanner(f);
        String [] notas = new String[10];
        int i = 0;
        
        while(s.hasNext()){
            String linea = s.nextLine();
            Scanner l = new Scanner(linea);
            String nombre=l.next() + " "+l.next();
            
            int suma = 0;
            int cont = 0;
            
            while (l.hasNextInt()) {
                cont++;
                suma += l.nextInt();
            }
            
            if(cont > 0){
                int media = suma / cont;
                notas[i] = media+ " " + nombre + "\n";
                i++;
            }
            l.close();
        }
        Arrays.sort(notas, 0, i, Comparator.reverseOrder());
        for (int j = 0; j < notas.length; j++) {
            System.out.print(notas[j]);
        }
        s.close();
    }
    static void personas (File f, int cuantos) throws FileNotFoundException, IOException{
        String [] personas = new String[cuantos];
        File nombres = new File(f, "usa_nombres.txt");
        File apellidos = new File(f, "usa_apellidos.txt");
        
        Random r = new Random();
        
        for (int i = 0; i < personas.length; i++) {
            Scanner s = new Scanner(nombres);
            Scanner sc = new Scanner(apellidos);
            personas[i] = "";
            int nombreRandom = r.nextInt(273)+1;
            int apellidoRandom = r.nextInt(244)+1;
            
            int j = 1;
            while(s.hasNext()){
                if (j == nombreRandom) {
                    personas[i] += s.next();
                } else{
                    s.next();
                }
                j++;
            }
            j = 1;
            while(sc.hasNext()){
                if (j == apellidoRandom) {
                    personas[i] += " "+sc.next();
                } else{
                    sc.next();
                }
                j++;
            }
            s.close();
            sc.close();
        }
        File nuevoPersonas = new File(f,"usa_personas2.txt");
        FileWriter file = new FileWriter(nuevoPersonas);
        for (int e = 0; e < personas.length;e++) {
            file.write(personas[e]+ "\n");
        }
        file.close();
    }
}
