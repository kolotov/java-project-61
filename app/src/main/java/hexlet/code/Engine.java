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

    public static final String[] GAME_TITLES = {
            "%d - %s".formatted(TYPE_EVEN_GAME, EvenGame.TITLE),
            "%d - %s".formatted(TYPE_CALC_GAME, CalcGame.TITLE),
            "%d - %s".formatted(TYPE_GCD_GAME, GcdGame.TITLE),
            "%d - %s".formatted(TYPE_PROGRESSION_GAME, ProgressionGame.TITLE),
            "%d - %s".formatted(TYPE_PRIME_GAME, PrimeGame.TITLE)
    };

    private static final int[] GAME_TYPES
            = {TYPE_EVEN_GAME, TYPE_CALC_GAME, TYPE_GCD_GAME, TYPE_PROGRESSION_GAME, TYPE_PRIME_GAME};

    private static Scanner sc = new Scanner(System.in);

    public static void run(int gameType) {
        System.out.println();
        System.out.println(MESSAGE_WELCOME);

        var name = promptUser(MESSAGE_ASK_NAME);
        System.out.printf(MESSAGE_HELLO + "%n", name);

        var gameData = loadGame(gameType);
        startGame(gameData, name);
    }

    private static void startGame(String[][] gameData, String name) {
        var rules = gameData[0][0];
        System.out.println(rules);

        var currentRound = 0;
        while (currentRound < GAME_ROUNDS) {
            var questionPair = gameData[currentRound + 1];
            var question = questionPair[0];
            var answer = questionPair[1];

            var userAnswer = promptUser(MESSAGE_QUESTION_PROMPT.formatted(question));
            var isValid = answer.equals(userAnswer);
            if (!isValid) {
                System.out.printf(MESSAGE_GAME_OVER + "%n", userAnswer, answer, name);
                return;
            }

            currentRound += 1;
            System.out.println(MESSAGE_CORRECT);
        }

        if (currentRound == GAME_ROUNDS) {
            System.out.printf(MESSAGE_CONGRATULATION.formatted(name) + "%n");
        }
    }

    public static String promptUser(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static boolean hasGame(int gameType) {
        for (var game : GAME_TYPES) {
            if (game == gameType) {
                return true;
            }
        }
        return false;
    }

    private static String[][] loadGame(int gameType) {
        var data = new String[GAME_ROUNDS + 1][1];
        data[0][0] = switch (gameType) {
            case TYPE_EVEN_GAME -> EvenGame.RULES;
            case TYPE_CALC_GAME -> CalcGame.RULES;
            case TYPE_GCD_GAME -> GcdGame.RULES;
            case TYPE_PROGRESSION_GAME -> ProgressionGame.RULES;
            case TYPE_PRIME_GAME -> PrimeGame.RULES;
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };

        for (var i = 0; i < GAME_ROUNDS; i += 1) {
            data[i + 1] = switch (gameType) {
                case TYPE_EVEN_GAME -> EvenGame.getQuestionPair();
                case TYPE_CALC_GAME -> CalcGame.getQuestionPair();
                case TYPE_GCD_GAME -> GcdGame.getQuestionPair();
                case TYPE_PROGRESSION_GAME -> ProgressionGame.getQuestionPair();
                case TYPE_PRIME_GAME -> PrimeGame.getQuestionPair();
                default -> throw new IllegalStateException("Unexpected value: " + gameType);
            };
        }
        return data;
    }
}
