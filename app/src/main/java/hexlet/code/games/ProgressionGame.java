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
        Engine.run(RULES, new String[][]{
                packToPair(),
                packToPair(),
                packToPair()
        });
    }

    private static String[] packToPair() {
        var progression = createProgression();
        var hiddenIndex = MathUtils.randomInt(0, LENGTH_PROGRESSION - 1);
        var answer = progression[hiddenIndex];
        progression[hiddenIndex] = "..";
        var question = String.join(" ", progression);
        return new String[]{question, answer};
    }

    private static String[] createProgression() {
        String[] result = new String[ProgressionGame.LENGTH_PROGRESSION];
        var step = MathUtils.randomInt(MIN_STEP, MAX_STEP);
        var nextNumber = MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
        for (var i = 0; i < ProgressionGame.LENGTH_PROGRESSION; i += 1) {
            result[i] = String.valueOf(nextNumber);
            nextNumber = nextNumber + step;
        }
        return result;
    }
}
