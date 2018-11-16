/**
 * Created by USER on 11/3/2018.
 */
public class Mandelbrot extends Calculation {

    private int iterations;

    public Mandelbrot(double realX1, double realX2, double imaginaryY1, double imaginaryY2,int iterations) {
        super(realX1, realX2, imaginaryY1, imaginaryY2);
        this.iterations = iterations;
    }

    public Mandelbrot(double realX1, double realX2, double imaginaryY1, double imaginaryY2) {
        super(realX1, realX2, imaginaryY1, imaginaryY2);
        this.iterations = 1000;
    }

    public Mandelbrot(int iterations) {
        super(-1, 1, -1, 1);
        this.iterations = iterations;
    }

    public Mandelbrot() {
        super(-1, 1, -1, 1);
        this.iterations = 1000;
    }


    @Override
    public synchronized int calculatePoint(ComplexNumber num1) {
        int i = 0;
        ComplexNumber z0 = new ComplexNumber(0,0);
        while (i++ < iterations){
            z0.square();
            z0.add(num1);
            if(z0.absSquare() > 4){
                break;
            }
        }

        return i;
    }
}
