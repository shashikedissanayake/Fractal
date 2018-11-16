import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

/**
 * Created by USER on 11/3/2018.
 */
public class Drawer extends JPanel {
    private int height,width,initialx,initialy;
    private Calculation componet;
    private int threadId;

    public Drawer(Calculation compont,int height,int width,int initialx,int initialy,int id){
        this.componet = compont;
        this.height = height+initialy;
        this.width = width+initialx;
        this.initialx = initialx;
        this.initialy = initialy;
        this.threadId = id;
    }

    private static void printPoint(Graphics2D frame, Color c, Point p) {

        frame.setColor(c);
        frame.draw(new Line2D.Double(p.getX(), p.getY(),
                p.getX(), p.getY()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = new BufferedImage(800,800,BufferedImage.TYPE_INT_RGB);
        g.drawImage(image,0,0,800,800,this);

        for(int i=initialy;i<height;i++){
            for(int j=initialx;j<width;j++){
                Point point = new Point(i,j);
                ComplexNumber z = new ComplexNumber(componet.mapRealToroi(i),componet.mapComplexToroi(j));
                int k = componet.calculatePoint(z);
                if(k<1000){
                    int color = k*5;
                    printPoint((Graphics2D)g,new Color(color), point);
                }else {
                    printPoint((Graphics2D)g, Color.BLACK, point);
                }
            }
        }

    }
}
