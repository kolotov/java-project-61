package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final String MESSAGE_CONGRATULATION = "Congratulations, %s!";
    private static final String MESSAGE_CORRECT = "Correct!";
    private static final String MESSAGE_WELCOME = "Welcome to the Brain Games!";
    private static final String MESSAGE_GAME_OVER
            = "'%s' is wrong answer ;(. Correct answer was '%s'.%nLet's try again, %s!";
    private static final String MESSAGE_QUESTION_PROMPT = "Question: %s%nYour answer: ";
    private static final String MESSAGE_ASK_NAME = "May I have your name? ";
    private static final String MESSAGE_HELLO = "Hello, %s!";
    private static Scanner sc = new Scanner(System.in);

    public static void run(int gameType) {
        print("%n" + MESSAGE_WELCOME);
        var name = promptUser(MESSAGE_ASK_NAME);
        print(MESSAGE_HELLO.formatted(name));

        print(GameManager.getRules(gameType));
        startGame(gameType, name);
    }

    public static void startGame(int gameType, String name) {
        var wins = 0;
        while (wins < GameManager.GAME_ROUNDS) {
            var questionPair = GameManager.getQuestionPair(gameType);
            var question = questionPair[0];
            var answer = questionPair[1];

            var userAnswer = promptUser(MESSAGE_QUESTION_PROMPT.formatted(question));
            var isValid = answer.equals(userAnswer);
            if (!isValid) {
                print(MESSAGE_GAME_OVER.formatted(userAnswer, answer, name));
                return;
            }

            wins += 1;
            print(MESSAGE_CORRECT);
        }

        if (wins == GameManager.GAME_ROUNDS) {
            print(MESSAGE_CONGRATULATION.formatted(name) + "%n");
        }
    }

    public static String promptUser(String prompt) {
        print(prompt, false);
        return sc.nextLine();
    }

    private static void print(String text) {
        print(text, true);
    }

    private static void print(String text, boolean ln) {
        var eol = ln ? "%n" : "";
        System.out.printf(text + eol);
    }
}
