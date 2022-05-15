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
public class ListaSimple extends Lista{

    @Override
    public void insertaInicio(String nombre, int r, int quantum) {
        if (vacio()){
            inicio = ultimo = new Nodo(nombre, r, quantum);
        }
        else{
            inicio = new Nodo(nombre, r, quantum, inicio);
        }
    }

    @Override
    public void insertaFinal(String nombre, int r, int quantum) {
        if (vacio()){
            inicio = ultimo = new Nodo(nombre, r, quantum);
        }
        else{
            Nodo temp = new Nodo(nombre, r, quantum);
            ultimo.setSiguiente(temp);
            ultimo = temp;
        }
    }

    @Override
    public Object eliminaInicio() {
    Object eliminado = null;
    if (vacio())
            System.out.println("La lista está vacía");
    else{
        if(inicio==ultimo){
            eliminado = inicio.getName();
            inicio = ultimo = null;
        }
        else{
            eliminado = inicio.getName();
            inicio = inicio.getSiguiente();
        }
    }
    return eliminado;
    }

    @Override
    public Object eliminaFinal() {
    Object eliminado = null;
    if (vacio())
            System.out.println("La lista está vacía");
    else{
        if(inicio==ultimo){
            eliminado = ultimo.getName();
            inicio = ultimo = null;
        }
        else{
            Nodo actual = inicio;
            while (actual.getSiguiente()!= ultimo){
                actual = actual.getSiguiente();
            }
            eliminado = ultimo.getName();
            actual.setSiguiente(null);
            ultimo = actual;
        }
    }
    return eliminado;
    }
    
    /*public void insertaOrdenado(String nombre, int r, int quantum){
    if (vacio())
        insertaInicio(nombre, r, quantum);
    else{
        if (inicio == ultimo)
            if (dato < (Integer)inicio.getName())
                insertaInicio(dato);
            else
                insertaFinal(dato);
        else{
            Nodo antes = null, despues = inicio;
            while(despues!=null && dato > (Integer)despues.getName()){
                antes = despues;
                despues = despues.getSiguiente();
            }
            if (antes==null)
                insertaInicio(dato);
            else
                if (despues==null)
                    insertaFinal(dato);
                else{
                    Nodo nuevo = new Nodo(dato,despues);
                    antes.setSiguiente(nuevo);
                }        
        }
    }                
    }*/
    
    /*public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        /*lista.insertaInicio(34);
        lista.insertaInicio("Hola");
        lista.insertaInicio(34.5);
        lista.insertaInicio("Otro dato");
        lista.insertaFinal("último");
        lista.imprimir();
        System.out.println("Eliminando el último de la lista...");
        System.out.println("Este elemento es:"+lista.eliminaFinal());
        lista.imprimir();
        System.out.println("\nEliminando el primer elemento de la lista... \n");
        System.out.println(lista.eliminaInicio());
        lista.imprimir();*//*
        System.out.println("Inserta en Orden");
        lista.insertaOrdenado(34);
        lista.insertaOrdenado(20);
        lista.insertaOrdenado(50);
        lista.insertaOrdenado(23);
        lista.imprimir();        
    }*/
}