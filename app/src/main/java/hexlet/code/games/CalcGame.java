package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;

public class CalcGame {
    public static final String RULES = "What is the result of the expression?";

    private static final String[] OPERATORS = {"+", "-", "*"};

    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 10;

    public static void run() {
        Engine.run(RULES, new String[][]{
                packToPair(),
                packToPair(),
                packToPair()
        });
    }

    private static String[] packToPair() {
        var num1 = MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
        var num2 = MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
        var operator = OPERATORS[MathUtils.randomInt(0, OPERATORS.length - 1)];
        var question = "%d %s %d".formatted(num1, operator, num2);
        var answer = calculate(num1, num2, operator).toString();
        return new String[]{question, answer};
    }

    private static Integer calculate(int num1, int num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
