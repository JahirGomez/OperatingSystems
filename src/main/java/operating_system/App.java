package operating_system;

import java.util.Scanner;
import java.util.ArrayList;
import operating_system.Model.Proceso;

public class App 
{ 
    public static void main( String[] args ) {
        int cantidad;
        ArrayList listaProcesos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de procesos a generar");
        cantidad = scanner.nextInt();
        
        for (int i=0; i<cantidad; i++){
            int quantum, rafaga;
            System.out.println("Ingrese el tiempo de CPU del proceso:");
            rafaga = scanner.nextInt();
            System.out.println("Ingrese el el quantum del proceso en mili5segundos");
            quantum = scanner.nextInt();
            Proceso p = new Proceso(i, rafaga, quantum, cantidad);
            listaProcesos.add(p);
        }

        for (int i=0; i<cantidad; i++){
            ((Proceso)listaProcesos.get(i)).start();
        }

    }
}
