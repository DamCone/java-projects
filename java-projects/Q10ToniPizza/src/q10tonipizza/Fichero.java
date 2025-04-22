/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10tonipizza;

import java.io.*;
import java.util.ArrayList;

public class Fichero {
    private static FileOutputStream fs;
    private static ObjectOutputStream oos;
    private static FileInputStream fe;
    private static DataInputStream d;
    private static ObjectInputStream ois;
    private static File f;
    private static final File dir = new File("./src/Ficheros");
    
    public static boolean guardarTickets(ArrayList <Ticket> lista) {
        boolean exito;
        Ticket tic;
        try {
            if (!dir.exists()){
                dir.mkdir();
            }
            // instanciamos un ObjectOutputStream asociado a un FileOutputStream para escribir
            // objetos en un flujo de salida y al conectarlos al fichero se escriben en el.
            fs = new FileOutputStream( dir.getAbsolutePath() + "/tickets.txt");
            oos = new ObjectOutputStream(fs);
           
            // construimos un objeto con los datos deseados y lo escribimos
            // en el flujo de salida ObjectOutputStream con el método writeObject
            for (int i = 0; i < lista.size(); i++) {
                tic = (Ticket) lista.get(i);
                oos.writeObject(tic);
            }
            // Cerramos los flujos abiertos una vez utilizados            
            oos.close( );
            fs.close( );
            exito = true;
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
            exito=false;
        }
        return exito;
    }
    
    public static boolean cargarTickets(ArrayList <Ticket> lista) {
        boolean exito=true;
        Ticket tic;
        try {
            fe = null;
            d = null;
            try {
                exito = true;
                if (!dir.exists()){
                    dir.mkdir();
                }
                f = new File(dir.getAbsolutePath() + "/tickets.txt");
                if (f.exists()) {
                    fe = new FileInputStream (f);
                    ois = new ObjectInputStream (fe);
                    do {
                        tic = (Ticket) ois.readObject();
                        lista.add(tic);
                        
                    } while (true);
                }
                else{
                    System.out.println("No exite el fichero");
                    exito = false;
                }

            } catch (EOFException eof) {
                System.out.println(".....................FIN DE FICHERO");
            } catch (FileNotFoundException fnf) {
                System.err.println("Fichero no encontrado " + fnf);
                exito = false;
            } catch (IOException e) {
                System.err.println("Se ha producido una IOException");
                e.printStackTrace();
                exito = false;
            } catch (Throwable e) {
                System.err.println("Error de programa" + e);
                e.printStackTrace();
                exito = false;
            } finally {
                if (d != null) {
                    d.close( );
                    fe.close( );
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
            exito = false;
        }
        return exito;
    }
}
