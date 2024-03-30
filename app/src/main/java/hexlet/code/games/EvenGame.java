package hexlet.code.games;

import java.util.Scanner;

public class EvenGame {
    static final int GAME_ROUNDS = 3;
    private static Scanner sc = new Scanner(System.in);

    public static void run() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        var name = sc.nextLine();
        System.out.printf("Hello, %s!%n", name);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'");

        var userAnswer = "";
        var answer = "";
        var wins = 0;
        var isValid = true;
        while (isValid && wins < GAME_ROUNDS) {
            var question = getQuestion();
            answer = getValidAnswer(question);
            userAnswer = askUser(question);
            isValid = answer.equals(userAnswer);

            wins += 1;
            System.out.println("Correct!");
        }

        if (wins == GAME_ROUNDS) {
            System.out.printf("Congratulations, %s!%n", name);
            return;
        }

        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s.%n'", userAnswer, answer);
        System.out.printf("Let's try again, %s!%n", name);
    }

    private static String getValidAnswer(int question) {
        return question % 2 == 0 ? "yes" : "no";
    }

    private static int getQuestion() {
        var max = 20;
        return Math.round((float) Math.random() * max);
    }

    private static String askUser(int question) {
        System.out.printf("Question: %d%n", question);
        System.out.print("Your answer: ");
        return sc.nextLine();
    }
}
