/**
 * Created by USER on 11/3/2018.
 */
public class ComplexNumber {
    private double real;
    private double complex;

    public ComplexNumber(double real,double complex){
        this.real = real;
        this.complex = complex;
    }

    public int absSquare(){
        return (int)(Math.pow(real,2) + Math.pow(complex,2));
    }


    public void add( ComplexNumber num){
        setReal(this.getReal()+num.getReal());
        setComplex(this.getComplex()+num.getComplex());
    }


    public void square(){
        double realPart = Math.pow(this.getReal(),2) - Math.pow(this.getComplex(),2);
        double complexPart = 2*this.getReal()*this.getComplex();
        setComplex(complexPart);
        setReal(realPart);
    }

    public double getReal() {
        return real;
    }

    public double getComplex() {
        return complex;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setComplex(double complex) {
        this.complex = complex;
    }
}
