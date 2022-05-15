package model;

public class Proceso extends Thread {
    private static int n;
    private int rafaga, quantum, resto;
    private String estado = "Listo";
    public static Object lock = new Object();
    private static int a=0;
    private int noProc;

    public Proceso (int number, int r, int q, int cantidad){
        super("P"+number);
        this.noProc=number;
        this.rafaga=this.resto=r;
        this.quantum=q;
        Proceso.setN(cantidad);
    }

    @Override
    public void run() {

        /*try {
            this.consume();
        }catch (InterruptedException e){
            System.out.println("Error de" + this.getName() + " en " + e);
        }*/

        while (!this.estado.equals("Finalizado")){
            synchronized (lock){
                while (noProc!=a){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                a++;
                if (a==n-1){
                    a=0;
                }
                if (resto>0 && resto>=quantum){
                    System.out.println(this);
                    for (int j=0; j<quantum; j++){
                        this.resto--;
                        if (resto==0){
                            break;
                        }
                    }
                    
                    if (resto == 0){
                        this.estado = "Finalizado";
                        System.out.println(this);
                        Proceso.setN(n-1);
                        /*try {
                            this.produce();
                        }catch (InterruptedException e) {
                            System.out.println("Error de" + this.getName() + " en " + e);
                        }*/
                        this.stop();
                    }else{
                        System.out.println(this.getName() + " En espera");
                        this.estado="En espera";
                        /*if (a-1<n){
                            lock.notifyAll();
                        }*/
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    //this.dormir((Proceso.getN()-1)*quantum);
                }else{
                    if (resto>0 && quantum>resto){
                        System.out.println(this);
                        while (resto>0){
                            this.resto--;
                        }
                        this.estado = "Finalizado";
                        System.out.println(this);
                        Proceso.setN(n-1);
                        lock.notifyAll();
                        this.stop();
                        //this.dormir((Proceso.getN()-1)*quantum);
                    }else{
                        if (resto == 0 && quantum !=0){
                            this.estado = "Finalizado";
                            System.out.println(this);
                            Proceso.setN(n-1);
                            this.stop();
                        }
                    }
                }
                //this.dormir((Proceso.getN()-1)*quantum);
            }
        }    
    }


    @Override
    public String toString() {
        if (!estado.equals("Finalizado")){
            return "Ejecutando " + this.getName();
        }else{
            return this.getName() +  " Finalizado";
        }
    }

    public void dormir(int a) {
        try{
            this.sleep(a);
        }catch (InterruptedException e){
            System.out.println("Error de" + this.getName() + " en " + e);
        }
    }

    public static void setN(int a) {
        n = a;
    }

    public static int getN() {
        return n;
    }

    public String getEstado() {
        return this.estado;
    }

}