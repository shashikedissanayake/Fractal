import java.awt.*;

/**
 * Created by USER on 11/3/2018.
 */
public abstract class Calculation {
    private int realAxisSize;
    private int complexAxisSize;
    private double realX1;
    private double realX2;
    private double imaginaryY1;
    private double imaginaryY2;

    public Calculation(double realX1, double realX2, double imaginaryY1, double imaginaryY2,int realAxisSize,int complexAxisSize){
        this.realX1 = realX1;
        this.realX2 = realX2;
        this.imaginaryY1 = imaginaryY1;
        this.imaginaryY2 = imaginaryY2;
        this.complexAxisSize = complexAxisSize;
        this.realAxisSize = realAxisSize;
    }

    public double mapRealToroi(int pixel){
        return (realX1 + pixel*(realX2 - realX1)/realAxisSize);
    }

    public double mapComplexToroi(int pixel){
        return (imaginaryY2 - pixel*(imaginaryY2 - imaginaryY1)/complexAxisSize);
    }

    public abstract int calculatePoint(ComplexNumber num1);
}
