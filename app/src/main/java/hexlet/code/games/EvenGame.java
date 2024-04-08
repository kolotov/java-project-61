package hexlet.code.games;

import hexlet.code.utils.MathUtils;

public class EvenGame {
    public static final String TITLE = "Even";
    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'";

    public static String[] getQuestionPair() {
        var question = getQuestion();
        return new String[]{
                question.toString(),
                getAnswer(question)
        };
    }

    private static String getAnswer(int question) {
        return MathUtils.isEven(question) ? "yes" : "no";
    }

    private static Integer getQuestion() {
        return MathUtils.randomInt(0, 20);
    }
}
