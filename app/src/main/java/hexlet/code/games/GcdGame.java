package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;

public class GcdGame {
    public static final String RULES = "Find the greatest common divisor of given numbers.";

    private static final int MIN_NUMBER = 10;
    private static final int MAX_NUMBER = 100;

    public static void run() {
        String[][] data = new String[Engine.GAME_ROUNDS][];
        for (var i = 0; i < Engine.GAME_ROUNDS; i += 1) {
            data[i] = packToPair();
        }

        Engine.run(RULES, data);
    }

    private static String[] packToPair() {
        var num1 = MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
        var num2 = MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
        var question = "%d %d".formatted(num1, num2);
        var answer = gcd(num1, num2);
        return new String[]{question, answer.toString()};
    }

    private static Integer gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
