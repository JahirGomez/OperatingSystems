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
    
    /*@Override
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
    }*/

    @Override
    public void imprimir() {
        Nodo actual = inicio;
        if (!vacio()){
            if (inicio == ultimo){
                actual.setEstado("En ejecución");
                System.out.println(actual);
                while(!actual.estado.equals("Finalizado")) {
                    if(actual.getResto() > 0 && actual.getResto() >= Nodo.getQuantum()) {
                        for (int i=0; i<Nodo.getQuantum(); i++){
                            actual.resto--;
                        }

                        if(actual.resto == 0) {
                            actual.setEstado("Finalizado");
                            System.out.println(actual);
                            //FUNCIÓN PARA ELIMINAR NODO DE LA LISTA.
                        }else{
                            actual.setEstado("En espera");
                            System.out.println(actual.getName() + " " + actual.getEstado());
                        }
                    }else{
                        if(actual.getResto() > 0 && actual.getResto() < Nodo.getQuantum()) {
                            for (int i=0; i<Nodo.getQuantum(); i++){
                                actual.resto--;
                                if(actual.getResto() == 0){
                                    actual.setEstado("Finalizado");
                                    System.out.println(actual);
                                    break;
                                }
                                
                            }
                            //FUNCIÓN PARA ELIMINAR NODO DE LA LISTA.
                        }
                    }
                }
            }else{
                do{
                    actual.setEstado("En ejecución");
                    System.out.println(actual);
                    while(!actual.estado.equals("Finalizado")) {
                        if(actual.getResto() > 0 && actual.getResto() >= Nodo.getQuantum()) {
                            for (int i=0; i<Nodo.getQuantum(); i++){
                                actual.resto--;
                            }

                            if(actual.resto == 0) {
                                actual.setEstado("Finalizado");
                                System.out.println(actual);
                                //FUNCIÓN PARA ELIMINAR NODO DE LA LISTA.
                            }else{
                                actual.setEstado("En espera");
                                System.out.println(actual.getName() + " " + actual.getEstado());
                            }
                        }else{
                            if(actual.getResto() > 0 && actual.getResto() < Nodo.getQuantum()) {
                                for (int i=0; i<Nodo.getQuantum(); i++){
                                    actual.resto--;
                                    if(actual.getResto() == 0){
                                        actual.setEstado("Finalizado");
                                        System.out.println(actual);
                                        break;
                                    }

                                }
                                //FUNCIÓN PARA ELIMINAR NODO DE LA LISTA.
                            }
                        }
                    }
                    actual = actual.getSiguiente();
                }while(actual!=inicio);
            }
        }
    }
}
