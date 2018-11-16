import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by USER on 11/3/2018.
 */
public class Worker implements Runnable {
    private int height;
    private int width;
    private int initialx;
    private int initialy;
    private Calculation componet;
    private int id;
    private BufferedImage image;

    public Worker(int height, int width, Calculation componet, int initialx, int initialy, BufferedImage image,int id) {
        this.height = height+initialy;
        this.width = width+initialx;
        this.initialx = initialx;
        this.initialy = initialy;
        this.componet = componet;
        this.id = id;
        this.image = image;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println(id+" started");
        for(int i=initialy;i<height;i++){
            for(int j=initialx;j<width;j++){
                ComplexNumber z = new ComplexNumber(componet.mapRealToroi(i),componet.mapComplexToroi(j));
                int k = componet.calculatePoint(z);
                if(k<1000){
                    Color color = new Color(k*5);
                    image.setRGB(i,j,color.getRGB());
                }else {
                    image.setRGB(i,j,Color.black.getRGB());
                }
            }
        }
        long time = System.currentTimeMillis() - startTime;
        System.out.println(id+" finished in :"+time);
    }
}
