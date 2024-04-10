package hexlet.code.games;

import hexlet.code.utils.MathUtils;

public class CalcGame {
    public static final String TITLE = "Calc";
    public static final String RULES = "What is the result of the expression?";

    private static final String[] OPERATORS = {"+", "-", "*"};

    public static String[] getQuestionPair() {
        var minNumberOfRange = 2;
        var maxNumberOfRange = 10;
        var num1 = MathUtils.randomInt(minNumberOfRange, maxNumberOfRange);
        var num2 = MathUtils.randomInt(minNumberOfRange, maxNumberOfRange);
        var operator = OPERATORS[MathUtils.randomInt(0, 2)];
        var question = "%d %s %d".formatted(num1, operator, num2);
        var answer = getAnswer(num1, num2, operator).toString();
        return new String[]{question, answer};
    }

    private static Integer getAnswer(int num1, int num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
