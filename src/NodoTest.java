import java.util.Scanner;

import model.ListaSimpleC;
import model.Nodo;

public class NodoTest {
    public static void main(String[] args) {
        //Declaración de variables.
        ListaSimpleC listaProcesos = new ListaSimpleC();
        int cantidad, quantum;
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
            String n = "P"+i;
            listaProcesos.insertaFinal(n, rafaga, quantum);
        }

        listaProcesos.imprimir();

        System.out.println("");



        while(Nodo.getContadorProcesosFinalizados() < cantidad) {
            listaProcesos.recorrer();
        }
        scanner.close();
    }
}
