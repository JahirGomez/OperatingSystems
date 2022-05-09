package operating_system.Model;

public class Proceso extends Thread {

    public Proceso (String name){
        super(name);
    }

    @Override
    public void run (){
        for (int i=0; i<5; i++){
            System.out.println (this.getName() + ". " + i);
        }
    }
}
