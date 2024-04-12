package hexlet.code.games;


import hexlet.code.utils.MathUtils;

public class GcdGame {
    public static final String TITLE = "GCD";
    public static final String RULES = "Find the greatest common divisor of given numbers.";

    private static final int MIN_NUMBER = 10;
    private static final int MAX_NUMBER = 100;

    public static String[] getQuestionPair() {
        var num1 = MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
        var num2 = MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
        var question = "%d %d".formatted(num1, num2);
        return new String[]{question, getAnswer(num1, num2).toString()};
    }

    private static Integer getAnswer(int num1, int num2) {
        return gcd(num1, num2);
    }

    private static Integer gcd(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }

        if (num2 == 0) {
            return num1;
        }
        var min = Math.min(num1, num2);
        var max = Math.max(num1, num2);
        var remainder = max % min;
        return gcd(min, remainder);
    }
}
