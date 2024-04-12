package hexlet.code.games;

import hexlet.code.utils.MathUtils;

public class PrimeGame {
    public static final String TITLE = "Prime";
    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 20;

    public static String[] getQuestionPair() {
        var question = getQuestion();
        return new String[]{question.toString(), getAnswer(question)};
    }

    private static String getAnswer(int question) {
        return isPrime(question) ? "yes" : "no";
    }

    private static Integer getQuestion() {
        return MathUtils.randomInt(MIN_NUMBER, MAX_NUMBER);
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
