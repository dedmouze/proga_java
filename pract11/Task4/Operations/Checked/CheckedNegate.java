package ru.chalovai.PR13.Task4.Operations.Checked;

import ru.chalovai.PR13.Task4.Exceptions.ArithmeticParserException;
import ru.chalovai.PR13.Task4.Expressions.TripleExpression;
import ru.chalovai.PR13.Task4.Operations.UnaryOperation;

public class CheckedNegate extends UnaryOperation {
    public CheckedNegate(TripleExpression object) {
        super(object);
    }

    protected int evaluate(int object) {
        if (object == Integer.MIN_VALUE)
            throw new ArithmeticParserException("Overflow exception : -(" + object + ")");
        return -object;
    }
}
