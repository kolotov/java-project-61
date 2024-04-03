package hexlet.code;

import hexlet.code.games.EvenGame;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class Engine {
    private static final int GAME_ROUNDS = 3;
    private static final int TYPE_EVEN_GAME = 2;

    private static final int[] GAMES = {
            TYPE_EVEN_GAME
    };

    public static final String[] GAME_ITEMS = {
            "%d - %s".formatted(TYPE_EVEN_GAME, EvenGame.TITLE)
    };

    private static Scanner sc = new Scanner(System.in);

    public static void run(int numberOfGame) {
        if (!hasGame(numberOfGame)) {
            return;
        }

        System.out.println(getRules(numberOfGame));
        System.out.println(Texts.MESSAGE_WELCOME);
        var name = askName();

        var wins = 0;
        while (wins < GAME_ROUNDS) {
            var questionPair = getQuestionPair(numberOfGame);
            var question = questionPair[0];
            var answer = questionPair[1];

            var userAnswer = askQuestion(question);
            var isValid = answer.equals(userAnswer);
            if (!isValid) {
                System.out.printf(Texts.MESSAGE_GAME_OVER, name, userAnswer, answer);
                return;
            }

            wins += 1;

            System.out.println(Texts.MESSAGE_CORRECT);
        }

        if (wins == GAME_ROUNDS) {
            System.out.printf(Texts.MESSAGE_CONGRATULATION, name);
        }
    }

    private static String[] getQuestionPair(int numberOfGame) {
        switch (numberOfGame) {
            case TYPE_EVEN_GAME:
                return EvenGame.getQuestionPair();
        }
        return new String[0];
    }

    private static String getRules(int numberOfGame) {
        switch (numberOfGame) {
            case TYPE_EVEN_GAME:
                return EvenGame.RULES;
        }
        return "";
    }

    private static boolean hasGame(int itemNumber) {
        return ArrayUtils.contains(GAMES, itemNumber);
    }

    private static String askName() {
        System.out.print(Texts.MESSAGE_ASK_NAME);
        var name = sc.nextLine();
        System.out.printf(Texts.MESSAGE_HELLO, name);
        return name;
    }

    private static String askQuestion(String question) {
        System.out.printf(Texts.MESSAGE_QUESTION_PROMPT, question);
        return sc.nextLine();
    }
}
