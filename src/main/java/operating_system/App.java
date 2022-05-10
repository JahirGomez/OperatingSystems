package operating_system;

import java.util.Scanner;
import java.util.ArrayList;
import operating_system.Model.Proceso;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList listaProcesos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int cantidad, tiempo;
        System.out.println("Ingrese el número de procesos a generar");
        cantidad = scanner.nextInt();
        System.out.println("Ingrese el la ranura de tiempo en milisegundos");
        tiempo = scanner.nextInt();
        
        for (int i=0; i<cantidad; i++){
            Proceso p = new Proceso(i, tiempo);
            p.start();
            try{
                p.sleep(tiempo/10);
            }catch (InterruptedException e){
                System.out.println("Error de" + p.getName() + " en " + e);
            }
            
            listaProcesos.add(p);
        }


    }
}

