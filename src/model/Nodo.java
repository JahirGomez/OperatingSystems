/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jahir Gómez
 */
public class Nodo {
    private static int rafaga;
    protected int quantum, resto;
    protected String name, estado;
    protected Nodo siguiente;
    
    public Nodo(){}
    
    public Nodo(String name, int raf, int q){
        this.name = name;
        this.rafaga = raf;
        this.resto = this.quantum = q;
        siguiente = null;
    }
    
    public Nodo(String name, Nodo siguiente){
        this.name = name;
        this.siguiente = siguiente;
    }

    /**
     * @return the name
     */
    public Object getname() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setname(String name) {
        this.name = name;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
}
