package ru.chalovai.PR13.Task4.Parser;

import ru.chalovai.PR13.Task4.Exceptions.FormatParserException;
import ru.chalovai.PR13.Task4.Expressions.TripleExpression;

public interface Parser {
    TripleExpression parse(String expression) throws FormatParserException;
}
