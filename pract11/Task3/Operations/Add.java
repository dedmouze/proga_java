package ru.chalovai.PR13.Task3.Operations;

import ru.chalovai.PR13.Task3.Expression.TripleExpression;

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
