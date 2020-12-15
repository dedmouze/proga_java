package ru.chalovai.PR11;

public class Main {
    public static void main(String[] args) {
        // Создание объекта класса Complex
        Complex a = new Complex(5, 9);
        System.out.println(a);

        // Наследуем от абстрактной фабрики конкретную, и создаем новый конкретный объект
        ComplexAbstractFactory b = new ConcreteFactory();
        Complex c = b.createComplex(0, -3);
        System.out.println(c);

        ConcreteFactory d = new ConcreteFactory();
        Complex f = d.createComplex(100, 0);
        System.out.println(f);
    }
}
