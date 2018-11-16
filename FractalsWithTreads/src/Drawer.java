import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

/**
 * Created by USER on 11/3/2018.
 */
public class Drawer extends JPanel {
    private BufferedImage image;

    public Drawer(BufferedImage image){
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,image.getWidth(),image.getHeight(),this);
    }
}
