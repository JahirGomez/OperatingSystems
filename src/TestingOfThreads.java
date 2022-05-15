import java.util.Scanner;

import javax.xml.catalog.Catalog;

import model.Proceso;
import java.util.ArrayList;

public class TestingOfThreads {
    public static void main( String[] args ) {
        //Declaración de variables.
        int cantidad, quantum;
        ArrayList listaProcesos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        //Lectura de datos iniciales.
        System.out.println("Ingrese el número de procesos a generar");
        cantidad = scanner.nextInt();
        System.out.println("Ingrese el el quantum de los proceso en milisegundos");
        quantum = scanner.nextInt();
        
        //for para crear procesos.
        for (int i=0; i<cantidad; i++){
            int rafaga;
            System.out.println("Ingrese el tiempo de CPU del proceso:");
            rafaga = scanner.nextInt();
            Proceso p = new Proceso(i, rafaga, quantum, cantidad);
            listaProcesos.add(p);
        }

        int contador = 0, bandera=0;
        while (listaProcesos.size()>0){
            //Si sólo hay un proceso en la cola.
            if (listaProcesos.size()==1){
                if (contador==0){
                    ((Proceso)listaProcesos.get(0)).start();
                    contador++;
                }

                while(((Proceso)listaProcesos.get(0)).getEstado().equals("En espera")){
                    try {
                        ((Proceso)listaProcesos.get(0)).consume();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (((Proceso)listaProcesos.get(0)).getEstado().equals("Finalizado")){
                    listaProcesos.remove(0);
                }
            }else{//Si hay más de un proceso.
                //for para iniciar y sincronizar los procesos.
                if(contador==0) {
                    for (int i=0; i<listaProcesos.size(); i++){
                    
                        if (i==0){
                            System.out.println("Iniciando proceso " + i);
                        
                            ((Proceso)listaProcesos.get(i)).start();
                        }else{
                            boolean ver = true;
                            do{
                                if (((Proceso)listaProcesos.get(i-1)).getEstado().equals("En espera")) {
                                System.out.println("Iniciando proceso " + i);
                                
                                ((Proceso)listaProcesos.get(i)).start();
                                ver = false;
                                }
                            } while (ver);
                            //Sacar el proceso si termina su ejecución.
                            if (((Proceso)listaProcesos.get(i)).getEstado().equals("Finalizado")){
                                bandera++;
                                listaProcesos.remove(i);
                                break;
                            }
                        }
                    
                        //System.out.println("consumiendo proceso " + i);
                    
                        /*try {
                            ((Proceso)listaProcesos.get(i)).consume();
                        } catch (InterruptedException e) {
                            System.out.println("Error de" + ((Proceso)listaProcesos.get(i)).getName() + " en " + e);
                        }*/
                    }
                    contador++;
                }else{
                    for (int i=0; i<listaProcesos.size(); i++){
                    
                        if (i==0){
                            if (((Proceso)listaProcesos.get(listaProcesos.size()-1)).getEstado().equals("En espera")) {
                                //System.out.println("consumiendo proceso " + i);
                            
                                try {
                                    ((Proceso)listaProcesos.get(i)).consume();
                                } catch (InterruptedException e) {
                                    System.out.println("Error de" + ((Proceso)listaProcesos.get(i)).getName() + " en " + e);
                                }
                            }
                        }else{
                            boolean ver = true;
                            do{
                                if (((Proceso)listaProcesos.get(i-1)).getEstado().equals("En espera")) {
                                    //System.out.println("consumiendo proceso " + i);
                                    try {
                                        ((Proceso)listaProcesos.get(i)).consume();
                                    } catch (InterruptedException e) {
                                        System.out.println("Error de" + ((Proceso)listaProcesos.get(i)).getName() + " en " + e);
                                    }
                                ver = false;
                                }
                            }while (ver);
                        }
                        if (((Proceso)listaProcesos.get(i)).getEstado().equals("Finalizado")){
                            bandera++;
                            listaProcesos.remove(i);
                            break;
                        }
                    }
                }
            }
        }
    }
}
