/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10tonipizza;

import java.util.ArrayList;

/**
 *
 * @author jadiazalejo
 */
public class ListaTickets {
    //atributos
    private ArrayList <Ticket> tickets;   

   
    
    private int activo;

    public ListaTickets() {
       tickets = new ArrayList<Ticket>();
       activo = -1;
    }

    public ListaTickets(ArrayList<Ticket> tickets, int activo) {
        this.tickets = tickets;
        this.activo = activo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
 
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
    public void limpiar() {
        tickets.clear();   
        activo = -1;
    } 

   public boolean insertar(Ticket tic) throws ExcepcionPropia {
         boolean resp=false;
   
        if (tic.getCli().getDni().equalsIgnoreCase("")) {
            throw new ExcepcionPropia("El DNI no puede estar en blanco");
        }
        if (!existe(tic)){
            resp =tickets.add(tic);
            activo = tickets.size()-1;
           }
           else
            throw new ExcepcionPropia("El Ticket está repetido");
        
        return resp;
    }
    
    public void borrar(Ticket tic){  
        tickets.remove(tic);  
        if (!tickets.isEmpty())
            activo = 0;
    }  
   
    public boolean borrarPos(int  posicion){ 
        boolean borrado = false;
        if (posicion>0 && posicion<tickets.size()){
            tickets.remove(posicion); 
            borrado = true;
            if (!tickets.isEmpty())
                activo = 0;
               else
                activo = -1;
        }
        return borrado;
    }
 
    public int elementos(){     
       return tickets.size();
    }
   
    public boolean vacio(){    
       return tickets.isEmpty();
    }
 
   public Boolean ticExite(Ticket tic) {
        Ticket tic1 = null;
        boolean enc = false;
        int i = 0;
        
        while ( i < tickets.size() && enc==false ) {
            tic1 = (Ticket) tickets.get(i);
            if (tic1.equals(tic)) {
                enc = true;
            }
            else
              i++;
        }
        
        return enc;
    }
   
    public Ticket devTicCod(int  num) {
        Ticket tic1 = null;    
        boolean enc = false;
        int i = 0;
        while ( i < tickets.size() && enc==false ) {
            tic1 = (Ticket) tickets.get(i);
            if (tic1.getCodTic()==num) {   
                enc=true;   
            }
            else
                i++;
        }
        if(!enc) tic1=null;
        return tic1;   
   }
    
    public Ticket devTicPos(int pos){
        Ticket tic1 = null;    
        boolean enc = false;
        if ((pos >=0) && (pos<tickets.size())) {
            tic1 = (Ticket) tickets.get(pos);
        }
        return tic1;   
   }
    
     /**
     * Comprueba si existe un tic repetida
     */
    public boolean existe(Ticket tic) {
        boolean resp = false;
        int i = 0;
        
        if (!tickets.isEmpty()) {
            i = 0;
            do {
                if (tic.getCodTic()==(tickets.get(i).getCodTic())) {
                    resp = true;
                }            
                i++;
            } while (i < tickets.size());
        }
        return resp;
    }
    
    public Ticket siguiente() {
        Ticket resp = null;
        if (activo < tickets.size()-1){
           activo++;
           resp = tickets.get(activo);
        }
        return resp;
    }

    public Ticket anterior() {
        Ticket resp = null;
        if (activo > 0){
           activo--;
           resp = tickets.get(activo);
        }
        return resp;
    }

    public Ticket primer() {
        Ticket resp = null;
        if (tickets.size()>0){
           activo = 0;
           resp = tickets.get(activo);
        }
        return resp;
    }

    public Ticket ultimo() throws ExcepcionPropia {
        Ticket resp = null;
        if (tickets.size()>0){
           activo = tickets.size()-1;
           resp = tickets.get(activo);
        }
        return resp;
    }

    /**
     * pregunta si el que se esta mostrando es el ultimo
     */
    public boolean isUltimo() {
        boolean resp=false;
        if (tickets.size()-1 == activo){
           resp = true;
        }
        return resp;
    }

    public boolean isPrimer() {
        boolean resp=false;
        if (activo==0){
           resp = true;
        }
        return resp;
    }
    
}
