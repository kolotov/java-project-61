package hexlet.code.games;


import hexlet.code.utils.MathUtils;

public class ProgressionGame {
    public static final String TITLE = "Progression";
    public static final String RULES = "What number is missing in the progression?";

    public static String[] getQuestionPair() {
        var lengthOfProgression = 10;
        var sequence = createProgression(lengthOfProgression);
        var hiddenIndex = MathUtils.randomInt(0, lengthOfProgression - 1);
        var answer = sequence[hiddenIndex];
        var question = sequenceToString(sequence, hiddenIndex);
        return new String[]{question, answer};
    }

    private static String sequenceToString(String[] sequence, int hideIndex) {
        var placeHolder = "..";
        sequence[hideIndex] = placeHolder;
        return String.join(" ", sequence);
    }

    private static String[] createProgression(int length) {
        String[] result = new String[length];
        var maxStepOfProgression = 10;
        var step = MathUtils.randomInt(2, maxStepOfProgression);
        var maxNumberOfRange = 20;
        var nextNumber = MathUtils.randomInt(1, maxNumberOfRange);
        for (var i = 0; i < length; i += 1) {
            result[i] = String.valueOf(nextNumber);
            nextNumber = nextNumber + step;
        }
        return result;
    }
}
