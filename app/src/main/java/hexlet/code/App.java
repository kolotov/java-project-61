package hexlet.code;

import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Great");
        System.out.printf("%d - %s%n", Engine.TYPE_EVEN_GAME, EvenGame.TITLE);
        System.out.printf("%d - %s%n", Engine.TYPE_CALC_GAME, CalcGame.TITLE);
        System.out.printf("%d - %s%n", Engine.TYPE_GCD_GAME, GcdGame.TITLE);
        System.out.printf("%d - %s%n", Engine.TYPE_PROGRESSION_GAME, ProgressionGame.TITLE);
        System.out.printf("%d - %s%n", Engine.TYPE_PRIME_GAME, PrimeGame.TITLE);
        System.out.println("0 - Exit");

        System.out.print("Your choice: ");
        var itemNumber = 0;
        if (scanner.hasNextInt()) {
            itemNumber = scanner.nextInt();
        }

        switch (itemNumber) {
            case 0 -> {
            }
            case 1 -> Cli.greetUser();
            case 2, 3, 4, 5, 6 -> Engine.run(itemNumber);
        }
    }
}


