import javax.swing.*;
import java.awt.*;

/**
 * Created by USER on 11/3/2018.
 */
public class Main {

    private static Calculation calculation;
    private static ComplexNumber c;
    private static int iterations;
    private static Drawer drawer;

    public static void main(String [] args) throws InterruptedException {

        if (args.length > 0) {
            if (args[0].equals("Julia")) {
                switch (args.length - 1) {
                    case (0):
                        calculation = new Julia();
                        makeFrame(calculation);
                        break;
                    case (2):
                        c = new ComplexNumber(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                        calculation = new Julia(c);
                        makeFrame(calculation);
                        break;
                    case (3):
                        c = new ComplexNumber(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                        iterations = Integer.parseInt(args[3]);
                        calculation = new Julia(iterations, c);
                        makeFrame(calculation);
                        break;
                    default:
                        System.out.println("Wrong input!");
                }
            }else if(args[0].equals("Mandelbrot")){

                switch (args.length - 1) {
                    case (0):
                        calculation = new Mandelbrot();
                        makeFrame(calculation);
                        break;
                    case (4):
                        calculation = new Mandelbrot(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]));
                        makeFrame(calculation);
                        break;
                    case (5):
                        iterations = Integer.parseInt(args[5]);
                        calculation = new Mandelbrot(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),iterations);
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
        frame.setPreferredSize(new Dimension(800,800));
        drawer = new Drawer(calculation,800,800,0,0,1);
        frame.setContentPane(drawer);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
