package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;

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

    private static final int GAME_ROUNDS = 3;

    private static final int TYPE_EVEN_GAME = 2;
    private static final int TYPE_CALC_GAME = 3;
    private static final int TYPE_GCD_GAME = 4;
    private static final int TYPE_PROGRESSION_GAME = 5;
    private static final int TYPE_PRIME_GAME = 6;

    private static final int[] GAME_TYPES
            = {TYPE_EVEN_GAME, TYPE_CALC_GAME, TYPE_GCD_GAME, TYPE_PROGRESSION_GAME, TYPE_PRIME_GAME};
    private static Scanner sc = new Scanner(System.in);

    public static void run(int gameType) {
        System.out.printf("%n" + MESSAGE_WELCOME + "%n");
        var name = promptUser(MESSAGE_ASK_NAME);
        System.out.printf(MESSAGE_HELLO + "%n", name);

        System.out.println(getRules(gameType));
        startGame(gameType, name);
    }

    private static void startGame(int gameType, String name) {
        var wins = 0;
        while (wins < GAME_ROUNDS) {
            var questionPair = getQuestionPair(gameType);
            var question = questionPair[0];
            var answer = questionPair[1];

            var userAnswer = promptUser(MESSAGE_QUESTION_PROMPT.formatted(question));
            var isValid = answer.equals(userAnswer);
            if (!isValid) {
                System.out.printf(MESSAGE_GAME_OVER + "%n", userAnswer, answer, name);
                return;
            }

            wins += 1;
            System.out.println(MESSAGE_CORRECT);
        }

        if (wins == GAME_ROUNDS) {
            System.out.printf(MESSAGE_CONGRATULATION.formatted(name) + "%n");
        }
    }

    public static String promptUser(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static String[] getMenuTitles() {
        String[] titles = new String[GAME_TYPES.length];
        var i = 0;
        for (var type : GAME_TYPES) {
            titles[i] = "%d - %s".formatted(type, getTitle(type));
            i += 1;
        }
        return titles;
    }

    public static boolean hasGame(int gameType) {
        for (var game : GAME_TYPES) {
            if (game == gameType) {
                return true;
            }
        }
        return false;
    }

    private static String[] getQuestionPair(int gameType) {
        return switch (gameType) {
            case TYPE_EVEN_GAME -> EvenGame.getQuestionPair();
            case TYPE_CALC_GAME -> CalcGame.getQuestionPair();
            case TYPE_GCD_GAME -> GcdGame.getQuestionPair();
            case TYPE_PROGRESSION_GAME -> ProgressionGame.getQuestionPair();
            case TYPE_PRIME_GAME -> PrimeGame.getQuestionPair();
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };
    }

    private static String getRules(int gameType) {
        return switch (gameType) {
            case TYPE_EVEN_GAME -> EvenGame.RULES;
            case TYPE_CALC_GAME -> CalcGame.RULES;
            case TYPE_GCD_GAME -> GcdGame.RULES;
            case TYPE_PROGRESSION_GAME -> ProgressionGame.RULES;
            case TYPE_PRIME_GAME -> PrimeGame.RULES;
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };
    }

    private static String getTitle(int gameType) {
        return switch (gameType) {
            case TYPE_EVEN_GAME -> EvenGame.TITLE;
            case TYPE_CALC_GAME -> CalcGame.TITLE;
            case TYPE_GCD_GAME -> GcdGame.TITLE;
            case TYPE_PROGRESSION_GAME -> ProgressionGame.TITLE;
            case TYPE_PRIME_GAME -> PrimeGame.TITLE;
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };
    }
}
