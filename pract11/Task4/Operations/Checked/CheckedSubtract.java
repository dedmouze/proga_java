package ru.chalovai.PR13.Task4.Operations.Checked;

import ru.chalovai.PR13.Task4.Exceptions.ArithmeticParserException;
import ru.chalovai.PR13.Task4.Expressions.TripleExpression;
import ru.chalovai.PR13.Task4.Operations.BinaryOperation;

public class CheckedSubtract extends BinaryOperation {
    public CheckedSubtract(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    protected int evaluate(int left, int right) {
        if (right > 0 ? left < Integer.MIN_VALUE + right
                : left > Integer.MAX_VALUE + right) {
            throw new ArithmeticParserException("Integer overflow");
        }
        return left - right;
    }
}