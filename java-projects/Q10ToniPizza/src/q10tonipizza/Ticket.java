/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10tonipizza;

import java.io.Serializable;

/**
 *
 * @author jadiazalejo
 */
public class Ticket implements Serializable{
    // atributos
    private static int numTic=0;
    
    private int codTic;
    private Pizza pizza;
    private Cliente cli;

    public Ticket(Pizza pizza, Cliente cli) {
        this.pizza = pizza;
        this.cli = cli;
        numTic++;
        codTic = getNumTic();
    }

    public static int getNumTic() {
        return numTic;
    }

    public static void setNumTic(int numTic) {
        Ticket.numTic = numTic;
    }
    
    public int getCodTic() {
        return codTic;
    }

    public void setCodTic(int codTic) {
        this.codTic = codTic;
    }
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    @Override
    public String toString() {
        return "Ticket{"+codTic+" "+ pizza.toString() + cli.toString() + '}';
    }
    
}
