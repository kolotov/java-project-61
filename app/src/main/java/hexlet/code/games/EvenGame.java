package hexlet.code.games;

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
        return question % 2 == 0 ? "yes" : "no";
    }

    private static Integer getQuestion() {
        var max = 20;
        return Math.round((float) Math.random() * max);
    }
}
