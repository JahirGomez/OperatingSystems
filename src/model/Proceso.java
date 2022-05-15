package model;

public class Proceso extends Thread {
    private static int n;
    private int rafaga, quantum, resto;
    private String estado = "Listo";

    public Proceso (int number, int r, int q, int cantidad){
        super("P"+number);
        this.rafaga=this.resto=r;
        this.quantum=q;
        Proceso.setN(cantidad);
    }

    @Override
    public void run() {
        while (!this.estado.equals("Finalizado")){
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
            try {
                this.produce();
            }catch (InterruptedException e) {
                System.out.println("Error de" + this.getName() + " en " + e);
            }
            //this.dormir((Proceso.getN()-1)*quantum);
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

    /*public void dormir(int a) {
        try{
            this.sleep(a);
        }catch (InterruptedException e){
            System.out.println("Error de" + this.getName() + " en " + e);
        }
    }*/

    public static void setN(int a) {
        n = a;
    }

    public static int getN() {
        return n;
    }

    public String getEstado() {
        return this.estado;
    }

    public void produce() throws InterruptedException {
        synchronized (this) {
            //System.out.println("Entrando a producir en " + this.getName());
            this.estado="En espera";
            wait();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            //System.out.println("Entrando a consumir en " + this.getName());
            notify();
        }
    }

}