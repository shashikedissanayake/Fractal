import javax.swing.*;

/**
 * Created by USER on 11/3/2018.
 */
public class Worker implements Runnable {
    private int height;
    private int width;
    private int initialx;
    private int initialy;
    private Calculation componet;
    private JFrame frame;
    private int id;

    public Worker(int height, int width, Calculation componet, int initialx, int initialy, JFrame frame,int id) {
        this.height = height;
        this.width = width;
        this.initialx = initialx;
        this.initialy = initialy;
        this.componet = componet;
        this.frame = frame;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(id+" started");
        Drawer drawer = new Drawer(componet,height,width,initialx,initialy,id);
        frame.setContentPane(drawer);
        System.out.println(id+" finished");
    }
}
