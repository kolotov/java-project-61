package hexlet.code.games;


import hexlet.code.utils.MathUtils;

public class ProgressionGame {
    public static final String TITLE = "Progression";
    public static final String RULES = "What number is missing in the progression?";

    public static String[] getQuestionPair() {
        var length = 10;
        var sequence = createProgression(length);
        var hiddenIndex = MathUtils.randomInt(0, length);
        var answer = sequence[hiddenIndex];
        var question = sequenceToString(sequence, hiddenIndex);
        return new String[]{
                question,
                answer
        };
    }

    private static String sequenceToString(String[] sequence, int hideIndex) {
        var placeHolder = "..";
        sequence[hideIndex] = placeHolder;
        return String.join(" ", sequence);
    }

    private static String[] createProgression(int length) {
        String[] result = new String[length];
        var q = MathUtils.randomInt(2, 10);
        var nextNumber = MathUtils.randomInt(1, 20);
        for (var i = 0; i < length; i += 1) {
            result[i] = String.valueOf(nextNumber);
            nextNumber = nextNumber + q;
        }
        return result;
    }
}
