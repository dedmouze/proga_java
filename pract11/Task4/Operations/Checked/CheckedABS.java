package ru.chalovai.PR13.Task4.Operations.Checked;

import ru.chalovai.PR13.Task4.Exceptions.ArithmeticParserException;
import ru.chalovai.PR13.Task4.Expressions.TripleExpression;
import ru.chalovai.PR13.Task4.Operations.UnaryOperation;

public class CheckedABS extends UnaryOperation {
    public CheckedABS(TripleExpression object) {
        super(object);
    }

    protected int evaluate(int object) {
        if (object == Integer.MIN_VALUE) {
            throw new ArithmeticParserException("Overflow exception : abs(" + object + ")");
        }
        return object < 0 ? -object : object;
    }
}
