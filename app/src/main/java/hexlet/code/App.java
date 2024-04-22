package hexlet.code;

import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class App {
    private static final int MENU_ITEM_EXIT = 0;
    private static final int MENU_ITEM_GREAT = 1;
    private static final int MENU_ITEM_EVEN_GAME = 2;
    private static final int MENU_ITEM_CALC_GAME = 3;
    private static final int MENU_ITEM_GCD_GAME = 4;
    private static final int MENU_ITEM_PROGRESSION_GAME = 5;
    private static final int MENU_ITEM_PRIME_GAME = 6;

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.printf("%d - Great%n", MENU_ITEM_GREAT);
        System.out.printf("%d - Even%n", MENU_ITEM_EVEN_GAME);
        System.out.printf("%d - Calc%n", MENU_ITEM_CALC_GAME);
        System.out.printf("%d - GCD%n", MENU_ITEM_GCD_GAME);
        System.out.printf("%d - Progression%n", MENU_ITEM_PROGRESSION_GAME);
        System.out.printf("%d - Prime%n", MENU_ITEM_PRIME_GAME);
        System.out.printf("%d - Exit%n", MENU_ITEM_EXIT);

        System.out.print("Your choice: ");
        var itemNumber = 0;
        var scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            itemNumber = scanner.nextInt();
        }

        switch (itemNumber) {
            case MENU_ITEM_EXIT -> {
            }
            case MENU_ITEM_GREAT -> Cli.greetUser();
            case MENU_ITEM_EVEN_GAME -> EvenGame.run();
            case MENU_ITEM_CALC_GAME -> CalcGame.run();
            case MENU_ITEM_GCD_GAME -> GcdGame.run();
            case MENU_ITEM_PROGRESSION_GAME -> ProgressionGame.run();
            case MENU_ITEM_PRIME_GAME -> PrimeGame.run();
            default -> System.out.println("Incorrect input!");
        }
    }

}


