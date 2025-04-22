
package q10tonipizza;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Q10ToniPizza {


    public static void main(String[] args) {
        BufferedReader stdin= new BufferedReader(new InputStreamReader(System.in));    
        ListaTickets lista = new ListaTickets();
        Ticket ticket=null;
        int opcion = 0, num=0;
        boolean correcto=true;
        
         do {
             
            System.out.println("  ####################################");
            System.out.println("  # 1.- Crea un ticket     .         #");
            System.out.println("  # 2.- Imprimir billete.            #");
            System.out.println("  # 3.- Grabar array en fichero.     #");
            System.out.println("  # 4.- Cargar array desde fichero.  #");
            System.out.println("  # 0.- Salir.                       #");
            System.out.println("  ####################################");

            System.out.print("Teclee opción (0 para salir):\n ");
            try {
                opcion = Integer.parseInt(stdin.readLine());
            } catch (NumberFormatException e){
                 System.out.println("Error de formato entrada/salida");
            } catch (IOException ex) {
                 System.out.println("Error de entrada/salida");
            }
            switch (opcion){
                case 1:
                    ticket = pidePizza();
                    try {
                        lista.insertar(ticket);
                    } catch (ExcepcionPropia ex) {
                             System.out.print("Error :");
                             System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    do{
                        correcto=true;
                        try{
                            System.out.print("Teclea num de ticket :");
                            num=Integer.parseInt(stdin.readLine());
                        }
                        catch (NumberFormatException ex){
                            System.out.println("Se han introducido caracteres no numéricos");
                            correcto=false;
                        }
                        catch (IOException ex){
                            System.out.println(ex.getMessage());
                            correcto=false;
                        }
                        if(num<0||num>1000){
                            System.out.println("El valor introducido tiene que ser entre "+0+" y "+1000);
                            correcto=false;
                        }
                    }while(!correcto);     
                    ticket = lista.devTicCod(num);
                    if (ticket!=null){
                        muestraTicket(ticket);
                    }
                    else{
                        System.out.println("Ticket no encontrado !!!");
                    }
                    break;
                case 3:
                    if (Fichero.guardarTickets(lista.getTickets()))
                        System.out.println("Grabado de arrayList en fichero");
                       else
                        System.out.println("No se pudo grabar arrayList en fichero");
                    break;
                    
                case 4:
                    lista.limpiar();
                    if (Fichero.cargarTickets(lista.getTickets()))
                        System.out.println("Carga de arrayList desde fichero");
                       else
                        System.out.println("No se pudo cargar arrayList en fichero");
                    break;              
                case 0:
                    System.out.println("");
                    System.out.println("Hasta pronto...");
                    break;
                default:
                    System.out.println("");
                    System.out.println("\nDebe introducir un valor entre 1 y 4, ó 0 para terminar");
                    break;
            }
        } while (opcion != 0);
        
        
       
        
        
    }
    
    public static Ticket pidePizza(){
        Ticket tic=null;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        String nomCli,apellidos,dni = null,nomPizza,resp;
        boolean extras = false;
        int opcion = 0,cantidad;
        int[] ing;
        Cliente c;
        Pizza p;
        boolean correcto = true;
        do{
            correcto=true;
            System.out.println("***********************");
            System.out.println("**PEDIDO DE TONIPIZZA**");
            System.out.println("***********************");
            System.out.println("");
            nomCli=validaTexto("el nombre");
            apellidos=validaTexto("los apellidos");
            try {
                dni=verifDNI();
            } catch (IOException ex) {
                System.out.println("Error de entrada de datos");
                correcto=false;
            }
            c=new Cliente(nomCli,apellidos,dni);
            System.out.println("");
            System.out.println("*************************");
            System.out.println("Pedido de:");
            System.out.println(c.toString());
            System.out.println("*************************");
            try {
               opcion=elijeOpcion();
            } catch (IOException ex) {
               System.out.println("Error en la entrada de datos.");
               correcto=false;
            }
            switch (opcion) {
               case 1:
                    nomPizza="Provenzal";
                    break;
               case 2:
                    nomPizza="Barbacoa";
                    break;
               default:
                    nomPizza="Mediterranea";
                    break;
            }
            cantidad=dameCantidad(1,10);
            try {
                  extras=siONo("Extras");
                  } catch (IOException ex) {
                           System.out.println("Error en la entrada de datos.");
                           correcto=false;
            }
            if(extras){
                ing=new int[3];
                for(int f=0;f<3;f++){
                    System.out.println("Ingrediente Nº"+(f+1));
                    ing[f]=dameCantidad(1,5);
                }
                p=new Pizza(nomPizza,extras,ing[0],ing[1],ing[2]);
            }else{
                p=new Pizza(nomPizza,extras);
            }
            muestraTicket(c,p,cantidad);
            tic = new Ticket(p, c);
        }while(!correcto);    
        return tic;
    }
    
    
    
    
    public static String validaTexto(String tipo) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String texto = null;
        int indice;
        boolean ok;
        do {
            ok=true;
            indice=0;
            try{
               System.out.println("Introduce "+tipo+" del cliente:");
               texto=teclado.readLine();
               if(texto.equals("")){
                  System.out.println("El campo no puede estar vacío.");
                  ok=false;
               }else{
                 while(indice<texto.length()&&ok){
                    if(Character.isDigit(texto.charAt(indice))){
                        ok=false;
                    }
                    indice++;
                }
                if(!ok){
                    System.out.println("Este campo, no puede contener números.");
                }
               }
            }
            catch(IOException ex){
                System.out.println("Error: en la entrada de datos");
            }
        } while (!ok);
        
        return texto;
    }

    
    
    
    public static String verifDNI() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        char[] letraDni={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};  
        boolean ok;
        String dni,num,letra;
        int indice,resto;
        do {
            ok=true;
            indice=0;
            System.out.println("Introduce el DNI (8 números+1letra):");
            dni=teclado.readLine();
            if(dni.length()==9){
                num=dni.substring(0,8);
                while(indice<num.length()&&ok){
                    if(Character.isLetter(num.charAt(indice))){
                        ok=false;
                    }
                    indice++;
                }
                if(ok){
                    if(Character.isLetter(dni.charAt(8))){
                        letra=dni.substring(8).toUpperCase();
                        resto=Integer.parseInt(num)%23;
                        if(letra.charAt(0)!=letraDni[resto]){
                            System.out.println("La letra del DNI introducido, no es válida");
                            ok=false;
                        }
                    }else{
                        System.out.println("El último ceracter, tiene que ser una letra.");
                        ok=false;
                    }
                }else{
                    System.out.println("Los primeros 8 caracteres, tienen que ser números");
                    ok=false;
                }
            }else{
                System.out.println("El tamaño del DNI, no es correcto");
                System.out.println("si el DNI es de 7 números + letra, añade un 0 al principio...");
                ok=false;
            }
        } while (!ok);
        
        return dni;
    }

    private static void muestraMenu() {
        System.out.println("Selecciona el nombre de la pizza:");
        System.out.println("1.- Provenzal.");
        System.out.println("2.- Barbacoa.");
        System.out.println("3.- Mediterranea.");
    }

    private static int elijeOpcion() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String respuesta;
        boolean ok;
        int op=0;
        do {
            ok=true;
            muestraMenu();
            try{
                System.out.println("Elije una opcion:");
                op=Integer.parseInt(teclado.readLine());
            }
            catch (NumberFormatException ex){
                respuesta= ("Se han introducido caracteres no numéricos");
                System.out.println(respuesta);
                ok=false;
            }
            catch (IOException ex){
                System.out.println(ex);
                ok=false;
            }
            if(op<1||op>3){
                System.out.println("El valor introducido tiene que ser entre 1 y 3");
                ok=false;
            }
            
        } while (!ok);
        
        return op;
    }

    private static boolean siONo(String texto) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String resp;
        boolean extras;
        extras=false;
        do {
            System.out.println("¿"+texto+"?si/no");
            resp=teclado.readLine();
            if(resp.equalsIgnoreCase("si")){
                extras=true;
            }else if(resp.equalsIgnoreCase("no")){
                extras=false;
            }else{
                System.out.println("Responde si o no...");
            }
        } while (!resp.equalsIgnoreCase("si")&&!resp.equalsIgnoreCase("no"));
        
        return extras;
    }

    private static int dameCantidad(int rangoIni, int rangoFin) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String error;
        boolean ok;
        int num=0;
        do {
            ok=true;
            try{
                System.out.println("Cantidad:");
                num=Integer.parseInt(teclado.readLine());
            }
            catch (NumberFormatException ex){
                error= ("Se han introducido caracteres no numéricos");
                System.out.println(error);
                ok=false;
            }
            catch (IOException ex){
                System.out.println(ex);
                ok=false;
            }
            if(num<rangoIni||num>rangoFin){
                System.out.println("El valor introducido tiene que ser entre "+rangoIni+" y "+rangoFin);
                ok=false;
            }
            
        } while (!ok);
        
        return num;
    }

    private static void muestraTicket(Cliente c, Pizza p,int cantidad) {
        System.out.println("***********************************************");
        System.out.println("****************TONIPIZZA**********************");
        System.out.println("***********************************************");
        System.out.println("Pedido realizado para:");
        System.out.println(c.toString());
        System.out.println(cantidad+" pizzas "+p.getNombre());
        System.out.println("Cantidad Extras:");
        System.out.println("Extra Nº1:"+p.getIngred1());
        System.out.println("Extra Nº2:"+p.getIngred2());
        System.out.println("Extra Nº3:"+p.getIngred3());
        System.out.println("***********************************************");
        System.out.println("****************fin**********************");
        System.out.println("***********************************************");
    }
    private static void muestraTicket(Ticket tic) {
        // falta la cantidad de pizzas, pero no lo guarde en el pedido
        System.out.println("***********************************************");
        System.out.println("****************TONIPIZZA**********************");
        System.out.println("***********************************************");
        System.out.println("Pedido realizado para:");
        System.out.println(tic.getCli().getNombre()+" "+tic.getCli().getApellidos());
        System.out.println(" pizzas "+tic.getPizza().getNombre());
        System.out.println("Cantidad Extras:");
        System.out.println("Extra Nº1:"+tic.getPizza().getIngred1());
        System.out.println("Extra Nº2:"+tic.getPizza().getIngred2());
        System.out.println("Extra Nº3:"+tic.getPizza().getIngred3());
        System.out.println("***********************************************");
        System.out.println("****************fin**********************");
        System.out.println("***********************************************");
    }
    
}
