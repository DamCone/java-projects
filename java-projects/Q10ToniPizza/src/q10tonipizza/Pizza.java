/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10tonipizza;

import java.io.Serializable;

/**
 *
 * @author Toni
 */
public class Pizza implements Serializable{
    private String nombre;
    private boolean extras;
    private int ingred1;
    private int ingred2;
    private int ingred3;

    public Pizza() {
    }
    
    public Pizza(String nombre, boolean extras) {
        this.nombre = nombre;
        this.extras = extras;
        this.ingred1 = 0;
        this.ingred2 = 0;
        this.ingred3 = 0;
    }

    public Pizza(String nombre, boolean extras, int ingred1, int ingred2, int ingred3) {
        this.nombre = nombre;
        this.extras = extras;
        this.ingred1 = ingred1;
        this.ingred2 = ingred2;
        this.ingred3 = ingred3;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the extras
     */
    public boolean isExtras() {
        return extras;
    }

    /**
     * @param extras the extras to set
     */
    public void setExtras(boolean extras) {
        this.extras = extras;
    }

    /**
     * @return the ingred1
     */
    public int getIngred1() {
        return ingred1;
    }

    /**
     * @param ingred1 the ingred1 to set
     */
    public void setIngred1(int ingred1) {
        this.ingred1 = ingred1;
    }

    /**
     * @return the ingred2
     */
    public int getIngred2() {
        return ingred2;
    }

    /**
     * @param ingred2 the ingred2 to set
     */
    public void setIngred2(int ingred2) {
        this.ingred2 = ingred2;
    }

    /**
     * @return the ingred3
     */
    public int getIngred3() {
        return ingred3;
    }

    /**
     * @param ingred3 the ingred3 to set
     */
    public void setIngred3(int ingred3) {
        this.ingred3 = ingred3;
    }

    @Override
    public String toString() {
        return "Pizza{" + "nombre=" + nombre + ", extras=" + extras + ", ingred1=" + ingred1 + ", ingred2=" + ingred2 + ", ingred3=" + ingred3 + '}';
    }
    
    
}
