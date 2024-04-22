package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;

public class ProgressionGame {
    public static final String RULES = "What number is missing in the progression?";

    private static final int MIN_STEP = 2;
    private static final int MAX_STEP = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 20;
    private static final int LENGTH_PROGRESSION = 20;

    public static void run() {
        String[][] data = new String[Engine.GAME_ROUNDS][];
        for (var i = 0; i < Engine.GAME_ROUNDS; i += 1) {
            data[i] = packToPair();
        }

        Engine.run(RULES, data);
    }

    private static String[] packToPair() {
        var step = MathUtils.randomInt(MIN_STEP, MAX_STEP);
        var firstNumber = MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
        var progression = createProgression(ProgressionGame.LENGTH_PROGRESSION, step, firstNumber);
        var hiddenIndex = MathUtils.randomInt(0, LENGTH_PROGRESSION - 1);
        var answer = progression[hiddenIndex];
        progression[hiddenIndex] = "..";
        var question = String.join(" ", progression);
        return new String[]{question, answer};
    }

    private static String[] createProgression(int length, int step, int firstNumber) {
        String[] result = new String[length];
        var nextNumber = firstNumber;
        for (var i = 0; i < length; i += 1) {
            result[i] = String.valueOf(nextNumber);
            nextNumber = nextNumber + step;
        }
        return result;
    }
}
