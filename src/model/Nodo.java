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
    private static int quantum, contadorProcesoFinalizados=0;
    protected int rafaga, resto, pagina, pagdis;
    protected String name, estado="Listo";
    protected Nodo siguiente;
   
    
    public Nodo(){}
    
    public Nodo(String name, int raf, int q){
        this.name = name;
        this.resto = this.rafaga = raf;
        this.quantum = q;
        siguiente = null;
    }
    
    public Nodo(String name, int raf, int q, Nodo siguiente){
        this.name = name;
        this.resto = this.rafaga = raf;
        Nodo.quantum = q;
        this.siguiente = siguiente;
    }


    public int getRafaga() {
        return this.rafaga;
    }

    public void setRafaga(int rafaga) {
        this.rafaga = rafaga;
    }

    public int getResto() {
        return this.resto;
    }

    public void setResto(int resto) {
        this.resto = resto;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Nodo getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public static int getQuantum() {
        return Nodo.quantum;
    }
    

    @Override
    public String toString() {
        if(!this.estado.equals("Finalizado")) {
            return "Ejecutando " +this.getName();
        }else{
            return this.getName() +  "Finalizado";
        }
    }

    public static void setContadorProcesoFinalizados() {
        Nodo.contadorProcesoFinalizados++;
    }

    public static int getContadorProcesosFinalizados() {
        return contadorProcesoFinalizados;
    }

}
