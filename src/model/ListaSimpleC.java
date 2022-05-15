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
public class ListaSimpleC extends ListaCirc{

    @Override
    public void insertaInicio(String nombre, int r, int quantum) {
        if (vacio()){
            inicio = ultimo = new Nodo(nombre, r, quantum);
            ultimo.setSiguiente(inicio);
        }
        else{
            inicio = new Nodo(nombre, r, quantum, inicio);
            ultimo.setSiguiente(inicio);
        }}

    @Override
    public void insertaFinal(String nombre, int r, int quantum) {
          if (vacio()){
            inicio = ultimo = new Nodo(nombre, r, quantum);
            ultimo.setSiguiente(inicio);
        }
        else{
            Nodo temp = new Nodo(nombre, r, quantum);
            ultimo.setSiguiente(temp);
            ultimo = temp;
            ultimo.setSiguiente(inicio);
        }}

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
            ultimo.setSiguiente(inicio);
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
            actual.setSiguiente(inicio);
            ultimo = actual;
        }
    }
    return eliminado;
    }
    
    public void insertaOrdenado(int dato){
    
    }
    
    /*public static void main(String[] args) {
        ListaSimpleC listac = new ListaSimpleC();
        listac.insertaInicio("Hola");
        listac.insertaInicio(34);
        listac.insertaFinal(23.4);
        listac.insertaInicio("Catorce");
        listac.imprimir();
        System.out.println("\nEliminando..."+listac.eliminaFinal());
        listac.imprimir();
        while(!listac.vacio()){
            System.out.println("\nQuitando..."+listac.eliminaInicio());
            listac.imprimir();
        }
    }*/
}
