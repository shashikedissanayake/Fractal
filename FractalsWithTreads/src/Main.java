import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by USER on 11/3/2018.
 */
public class Main {

    private static Calculation calculation;
    private static ComplexNumber c;
    private static int iterations;
    private static Drawer drawer;
    private static BufferedImage image;
    private static int height = 800;
    private static int width = 800;

    public static void main(String [] args) throws InterruptedException {

        if (args.length > 0) {
            if (args[0].equals("Julia")) {
                switch (args.length - 1) {
                    case (0):
                        calculation = new Julia(height,width);
                        makeFrame(calculation);
                        break;
                    case (2):
                        c = new ComplexNumber(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                        calculation = new Julia(height,width,c);
                        makeFrame(calculation);
                        break;
                    case (3):
                        c = new ComplexNumber(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                        iterations = Integer.parseInt(args[3]);
                        calculation = new Julia(height,width,iterations, c);
                        makeFrame(calculation);
                        break;
                    default:
                        System.out.println("Wrong input!");
                }
            }else if(args[0].equals("Mandelbrot")){

                switch (args.length - 1) {
                    case (0):
                        calculation = new Mandelbrot(height,width);
                        makeFrame(calculation);
                        break;
                    case (4):
                        calculation = new Mandelbrot(height,width,Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]));
                        makeFrame(calculation);
                        break;
                    case (5):
                        iterations = Integer.parseInt(args[5]);
                        calculation = new Mandelbrot(height,width,Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),iterations);
                        makeFrame(calculation);
                        break;
                    default:
                        System.out.println("Wrong input!");
                }

            }else {
                System.out.println("Wrong input!");
            }



        }else {
            System.out.println("Wrong input!");
        }
    }

    public static void makeFrame(Calculation calculation) throws InterruptedException {
        // create a frame
        JFrame frame = new JFrame("Fractals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(width,height));

        image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        int canvasHeight = height/4;
        int canvasWidth = width/2;

        Thread thread1 = new Thread(new Worker(canvasHeight,canvasWidth,calculation,0,0,image,1));
        Thread thread2 = new Thread(new Worker(canvasHeight,canvasWidth,calculation,400,0,image,2));
        Thread thread3 = new Thread(new Worker(canvasHeight,canvasWidth,calculation,0,200,image,3));
        Thread thread4 = new Thread(new Worker(canvasHeight,canvasWidth,calculation,400,200,image,4));
        Thread thread5 = new Thread(new Worker(canvasHeight,canvasWidth,calculation,0,400,image,5));
        Thread thread6 = new Thread(new Worker(canvasHeight,canvasWidth,calculation,400,400,image,6));
        Thread thread7 = new Thread(new Worker(canvasHeight,canvasWidth,calculation,0,600,image,7));
        Thread thread8 = new Thread(new Worker(canvasHeight,canvasWidth,calculation,400,600,image,8));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();

        drawer = new Drawer(image);

        frame.setContentPane(drawer);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
