package hexlet.code.games;


import hexlet.code.utils.MathUtils;

public class GcdGame {
    public static final String TITLE = "GCD";
    public static final String RULES = "Find the greatest common divisor of given numbers.";

    public static String[] getQuestionPair() {
        var num1 = MathUtils.randomInt(10, 100);
        var num2 = MathUtils.randomInt(20, 100);
        var question = "%d %d".formatted(num1, num2);
        return new String[]{
                question,
                getAnswer(num1, num2).toString()
        };
    }

    private static Integer getAnswer(int num1,int num2) {
        return MathUtils.gcd(num1, num2);
    }
}
