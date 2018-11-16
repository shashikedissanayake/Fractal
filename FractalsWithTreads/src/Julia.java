import java.awt.*;

/**
 * Created by USER on 11/3/2018.
 */
public class Julia extends Calculation {

    private int iterations;
    private ComplexNumber c;

    public Julia(int height,int width,double realX1, double realX2, double imaginaryY1, double imaginaryY2,int iterations,ComplexNumber c) {
        // set the panel size
        super(realX1,realX2,imaginaryY1,imaginaryY2,width,height);
        this.iterations = iterations;
        this.c = c;
    }

    public Julia(int height,int width,int iterations,ComplexNumber c) {
        // set the panel size
        super(-1,1,-1,1,width,height);
        this.iterations = iterations;
        this.c = c;
    }

    public Julia(int height,int width,ComplexNumber c) {
        // set the panel size
        super(-1.5,1.5,-1.5,1.5,width,height);
        this.iterations = 1000;
        this.c = c;
    }

    public Julia(int height,int width) {
        // set the panel size
        super(-1,1,-1,1,width,height);
        this.iterations = 1000;
        this.c = new ComplexNumber(-0.4,0.6);
    }


    @Override
    public synchronized int calculatePoint(ComplexNumber num1) {
        int i = 0;
        while (i++ < iterations){
            num1.square();
            num1.add(c);
            if(num1.absSquare() > 4){
                break;
            }
        }

        return i;
    }
}
