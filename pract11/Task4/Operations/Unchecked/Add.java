package ru.chalovai.PR13.Task4.Operations.Unchecked;

import ru.chalovai.PR13.Task4.Expressions.TripleExpression;
import ru.chalovai.PR13.Task4.Operations.Operation;

public class Add extends Operation {
    public Add(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    protected int evaluate(int left, int right) {
        return left + right;
    }

    protected double evaluate(double left, double right) {
        return left + right;
    }
}