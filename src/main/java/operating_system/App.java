package operating_system;

import operating_system.Model.Proceso;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Proceso p1 = new Proceso("P1");
        Proceso p2 = new Proceso("P2");
        p2.start();
        p1.start();
    }
}
