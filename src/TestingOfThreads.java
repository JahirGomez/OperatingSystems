import java.util.Scanner;
import model.Proceso;
import java.util.ArrayList;

public class TestingOfThreads {
    public static void main( String[] args ) {
        int cantidad, quantum;
        ArrayList listaProcesos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de procesos a generar");
        cantidad = scanner.nextInt();
        System.out.println("Ingrese el el quantum de los proceso en milisegundos");
        quantum = scanner.nextInt();
        
        for (int i=0; i<cantidad; i++){
            int rafaga;
            System.out.println("Ingrese el tiempo de CPU del proceso:");
            rafaga = scanner.nextInt();
            Proceso p = new Proceso(i, rafaga, quantum, cantidad);
            listaProcesos.add(p);
        }

        for (int i=0; i<cantidad; i++){
            Boolean ver = true;
            if (i==0){
                ((Proceso)listaProcesos.get(i)).start();
            }else{
                do{
                    if ((((Proceso)listaProcesos.get(i-1)).getEstado()).equals("En espera")){
                        ((Proceso)listaProcesos.get(i)).start();
                        ver=false;
                    }
                }while (ver);
            }
            ver=true;
        }
    }
}
