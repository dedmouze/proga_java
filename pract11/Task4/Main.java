package ru.chalovai.PR13.Task4;

import ru.chalovai.PR13.Task4.Exceptions.FormatParserException;
import ru.chalovai.PR13.Task4.Parser.ExpressionParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FormatParserException {
        ExpressionParser parse = new ExpressionParser();

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        System.out.println(parse.parse("x * (y - 2)*z + 1").evaluate(x, y, z));
        System.out.println(parse.parse("1000000*x*x*x*x*x/(x-1)").evaluate(x, x, x));
    }
}
