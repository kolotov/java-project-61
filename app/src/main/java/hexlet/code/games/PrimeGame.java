package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;

public class PrimeGame {
    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 20;

    public static void run() {
        String[][] data = new String[Engine.GAME_ROUNDS][];
        for (var i = 0; i < Engine.GAME_ROUNDS; i += 1) {
            data[i] = packToPair();
        }

        Engine.run(RULES, data);
    }

    private static String[] packToPair() {
        var question = MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
        var answer = isPrime(question) ? "yes" : "no";
        return new String[]{String.valueOf(question), answer};
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        int start = number / 2;
        for (var i = start; i > 1; i -= 1) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
