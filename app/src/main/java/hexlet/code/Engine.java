package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int GAME_ROUNDS = 3;
    private static final String MESSAGE_CONGRATULATION = "Congratulations, %s!";
    private static final String MESSAGE_CORRECT = "Correct!";
    private static final String MESSAGE_WELCOME = "Welcome to the Brain Games!";
    private static final String MESSAGE_GAME_OVER
            = "'%s' is wrong answer ;(. Correct answer was '%s'.%nLet's try again, %s!";
    private static final String MESSAGE_QUESTION_PROMPT = "Question: %s%nYour answer: ";
    private static final String MESSAGE_ASK_NAME = "May I have your name? ";
    private static final String MESSAGE_HELLO = "Hello, %s!";
    private static Scanner scanner = new Scanner(System.in);

    public static void run(String rules, String[][] gameData) {
        System.out.println();
        System.out.println(MESSAGE_WELCOME);

        System.out.print(MESSAGE_ASK_NAME);
        var name = scanner.nextLine();
        System.out.printf(MESSAGE_HELLO + "%n", name);
        System.out.println(rules);
        startGame(gameData, name);
    }

    private static void startGame(String[][] gameData, String name) {
        for (var round = 0; round < GAME_ROUNDS; round += 1) {
            var questionPair = gameData[round];
            var question = questionPair[0];
            var answer = questionPair[1];

            System.out.printf(MESSAGE_QUESTION_PROMPT, question);
            var userAnswer = scanner.nextLine();
            var isValid = answer.equals(userAnswer);
            if (!isValid) {
                System.out.printf(MESSAGE_GAME_OVER + "%n", userAnswer, answer, name);
                return;
            }

            System.out.println(MESSAGE_CORRECT);
        }

        System.out.printf(MESSAGE_CONGRATULATION.formatted(name) + "%n");
    }
}
