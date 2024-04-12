package hexlet.code.games;

import hexlet.code.utils.MathUtils;

public class EvenGame {
    public static final String TITLE = "Even";
    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 20;

    public static String[] getQuestionPair() {
        var question = getQuestion();
        return new String[]{question.toString(), getAnswer(question)};
    }

    private static String getAnswer(int question) {
        return isEven(question) ? "yes" : "no";
    }

    private static Integer getQuestion() {
        return MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
