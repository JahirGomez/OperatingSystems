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
public abstract class ListaCirc extends Lista {
    
    @Override
    public void imprimir(){
        Nodo actual = inicio;
        if (!vacio())
            if (inicio == ultimo)
                    System.out.println(actual.getName());
            else{
                do{
                    System.out.print(actual.getName()+"->");
                    actual = actual.getSiguiente();
                }while(actual!=inicio);

            }
    }

    public abstract void recorrer();
}
