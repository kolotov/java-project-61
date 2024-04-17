package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;

public class EvenGame {
    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 20;

    public static void run() {
        Engine.run(RULES, new String[][]{
                packToPair(),
                packToPair(),
                packToPair()
        });
    }

    private static String[] packToPair() {
        var question = MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
        var answer = isEven(question) ? "yes" : "no";
        return new String[]{String.valueOf(question), answer};
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
