package ru.chalovai.PR13.Task3.Objects;

import ru.chalovai.PR13.Task3.Expression.Expression;

public class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public int evaluate(int x, int y, int z) {
        return name.equals("x") ? x : name.equals("y") ? y : name.equals("z") ? z : 0;
    }
}
