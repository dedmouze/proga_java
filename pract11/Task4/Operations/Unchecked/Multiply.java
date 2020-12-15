package ru.chalovai.PR13.Task4.Operations.Unchecked;

import ru.chalovai.PR13.Task4.Expressions.TripleExpression;
import ru.chalovai.PR13.Task4.Operations.Operation;

public class Multiply extends Operation {
    public Multiply(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    protected int evaluate(int left, int right) {
        return left * right;
    }

    protected double evaluate(double left, double right) {
        return left * right;
    }
}