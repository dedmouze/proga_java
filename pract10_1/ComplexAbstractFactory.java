package ru.chalovai.PR11;

public interface ComplexAbstractFactory {
    Complex createComplex();
    Complex createComplex(int real, int image);
}