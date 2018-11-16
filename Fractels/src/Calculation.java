/**
 * Created by USER on 11/3/2018.
 */
public abstract class Calculation {
    private int realAxisSize = 800;
    private int complexAxisSize = 800;
    private double realX1;
    private double realX2;
    private double imaginaryY1;
    private double imaginaryY2;

    public Calculation(double realX1, double realX2, double imaginaryY1, double imaginaryY2){
        this.realX1 = realX1;
        this.realX2 = realX2;
        this.imaginaryY1 = imaginaryY1;
        this.imaginaryY2 = imaginaryY2;
    }

    public double mapRealToroi(int pixel){
        return (realX1 + pixel*(realX2 - realX1)/realAxisSize);
    }

    public double mapComplexToroi(int pixel){
        return (imaginaryY2 - pixel*(imaginaryY2 - imaginaryY1)/complexAxisSize);
    }

    public int getRealAxisSize() {
        return realAxisSize;
    }

    public int getComplexAxisSize() {
        return complexAxisSize;
    }

    public abstract int calculatePoint(ComplexNumber num1);
}
