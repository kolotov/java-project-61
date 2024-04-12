package hexlet.code;

import hexlet.code.games.*;

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

    static final int TYPE_EVEN_GAME = 2;
    static final int TYPE_CALC_GAME = 3;
    static final int TYPE_GCD_GAME = 4;
    static final int TYPE_PROGRESSION_GAME = 5;
    static final int TYPE_PRIME_GAME = 6;

    static final int[] GAME_TYPES
            = {TYPE_EVEN_GAME, TYPE_CALC_GAME, TYPE_GCD_GAME, TYPE_PROGRESSION_GAME, TYPE_PRIME_GAME};
    private static Scanner sc = new Scanner(System.in);

    public static void run(int gameType) {
        print("%n" + MESSAGE_WELCOME);
        var name = promptUser(MESSAGE_ASK_NAME);
        print(MESSAGE_HELLO.formatted(name));

        print(getRules(gameType));
        startGame(gameType, name);
    }

    public static void startGame(int gameType, String name) {
        var wins = 0;
        while (wins < GAME_ROUNDS) {
            var questionPair = getQuestionPair(gameType);
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

        if (wins == GAME_ROUNDS) {
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

    static String[] getQuestionPair(int gameType) {
        return switch (gameType) {
            case TYPE_EVEN_GAME -> EvenGame.getQuestionPair();
            case TYPE_CALC_GAME -> CalcGame.getQuestionPair();
            case TYPE_GCD_GAME -> GcdGame.getQuestionPair();
            case TYPE_PROGRESSION_GAME -> ProgressionGame.getQuestionPair();
            case TYPE_PRIME_GAME -> PrimeGame.getQuestionPair();
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };
    }

    static String getRules(int gameType) {
        return switch (gameType) {
            case TYPE_EVEN_GAME -> EvenGame.RULES;
            case TYPE_CALC_GAME -> CalcGame.RULES;
            case TYPE_GCD_GAME -> GcdGame.RULES;
            case TYPE_PROGRESSION_GAME -> ProgressionGame.RULES;
            case TYPE_PRIME_GAME -> PrimeGame.RULES;
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };
    }

    static String getTitle(int gameType) {
        return switch (gameType) {
            case TYPE_EVEN_GAME -> EvenGame.TITLE;
            case TYPE_CALC_GAME -> CalcGame.TITLE;
            case TYPE_GCD_GAME -> GcdGame.TITLE;
            case TYPE_PROGRESSION_GAME -> ProgressionGame.TITLE;
            case TYPE_PRIME_GAME -> PrimeGame.TITLE;
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };
    }

    static String[] getMenuTitles() {
        String[] titles = new String[GAME_TYPES.length];
        var i = 0;
        for (var type : GAME_TYPES) {
            titles[i] = "%d - %s".formatted(type, getTitle(type));
            i += 1;
        }
        return titles;
    }

    static boolean hasGame(int gameType) {
        for (var game : GAME_TYPES) {
            if (game == gameType) {
                return true;
            }
        }
        return false;
    }
}
