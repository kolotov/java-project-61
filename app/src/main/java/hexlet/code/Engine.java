package hexlet.code;

import hexlet.code.constants.Texts;

import java.util.Scanner;

public class Engine {

    private static Scanner sc = new Scanner(System.in);

    public static void run(int gameType) {
        print("%n" + Texts.MESSAGE_WELCOME);
        var name = promptUser(Texts.MESSAGE_ASK_NAME);
        print(Texts.MESSAGE_HELLO.formatted(name));

        print(GameManager.getRules(gameType));
        startGame(gameType, name);
    }

    public static void startGame(int gameType, String name) {
        var wins = 0;
        while (wins < GameManager.GAME_ROUNDS) {
            var questionPair = GameManager.getQuestionPair(gameType);
            var question = questionPair[0];
            var answer = questionPair[1];

            var userAnswer = promptUser(Texts.MESSAGE_QUESTION_PROMPT.formatted(question));
            var isValid = answer.equals(userAnswer);
            if (!isValid) {
                print(Texts.MESSAGE_GAME_OVER.formatted(userAnswer, answer, name));
                return;
            }

            wins += 1;
            print(Texts.MESSAGE_CORRECT);
        }

        if (wins == GameManager.GAME_ROUNDS) {
            print(Texts.MESSAGE_CONGRATULATION.formatted(name) + "%n");
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
