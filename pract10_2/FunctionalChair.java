package ru.chalovai.PR10;

public class FunctionalChair implements Chair {
    public int sum(int a, int b){
        System.out.println(a + " + " + b + " = " + (a+b));
        return a+b;
    }

    FunctionalChair(){
        sum((int)(Math.random()*10), (int)(Math.random()*10));
    }

    @Override
    public String toString() {
        return "Functional Chair";
    }
}