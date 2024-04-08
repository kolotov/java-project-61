package hexlet.code.games;

import hexlet.code.utils.MathUtils;

public class CalcGame {
    public static final String TITLE = "Calc";
    public static final String RULES = "What is the result of the expression?";

    private static final String[] OPERATORS = {"+", "-", "*"};

    public static String[] getQuestionPair() {
        var num1 = MathUtils.randomInt(2, 10);
        var num2 = MathUtils.randomInt(2, 10);
        var operator = OPERATORS[MathUtils.randomInt(0, 2)];
        var question = "%d %s %d".formatted(num1, operator, num2);
        return new String[]{
                question,
                getAnswer(num1, num2, operator).toString()
        };
    }

    private static Integer getAnswer(int num1,int num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}