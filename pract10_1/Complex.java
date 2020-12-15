package ru.chalovai.PR11;

public class Complex {
    int real;
    int imagine;

    public Complex(int real, int imagine) {
        this.real = real;
        this.imagine = imagine;
    }

    public int getReal() {
        return real;
    }

    public int getImagine() {
        return imagine;
    }

    @Override
    public String toString() {
        if (imagine < 0) {
            return "Complex number {" + real + " (x) " +
                    + imagine + "i (iy)" +
                    "}";
        }
        else return "Complex number {" + real + " (x)" + " + "
                + imagine + "i (iy)" +
                "}";
    }
}