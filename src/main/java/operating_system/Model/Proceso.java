package operating_system.Model;

public class Proceso extends Thread {
    private int slot;

    public Proceso (int number, int n){
        super("P"+number);
        this.slot=n;
    }

    @Override
    public void run (){
        for (int i=0; i<5; i++){
            System.out.println ("Ejecutando " + this.getName());
            try{
                sleep(this.slot/10);
            }catch (InterruptedException e){
                System.out.println("Error de" + this.getName() + " en " + e);
            }
        }
    }


    @Override
    public String toString() {
        return "Ejecutando " + this.getName();
    }


    public void iniciar (){
        this.start();
    }
}
