package hexlet.code.games;


import hexlet.code.utils.MathUtils;

public class GcdGame {
    public static final String TITLE = "GCD";
    public static final String RULES = "Find the greatest common divisor of given numbers.";

    public static String[] getQuestionPair() {
        var minNumber = 10;
        var manNumber = 100;
        var num1 = MathUtils.randomInt(minNumber, manNumber);
        var num2 = MathUtils.randomInt(minNumber, manNumber);
        var question = "%d %d".formatted(num1, num2);
        return new String[]{question, getAnswer(num1, num2).toString()};
    }

    private static Integer getAnswer(int num1, int num2) {
        return MathUtils.gcd(num1, num2);
    }
}
