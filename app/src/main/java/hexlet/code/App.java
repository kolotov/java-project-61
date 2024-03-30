package hexlet.code;

import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int itemNumber = -1;
        while (itemNumber != 0) {
            itemNumber = runMenu();
            runGame(itemNumber);
        }
    }

    private static void runGame(int numberOfGame) {
        switch (numberOfGame) {
            case 1:
                Cli.greetUser();
                break;
            case 2:
                EvenGame.run();
                break;
        }
    }

    private static int runMenu() {
        System.out.println();
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Great");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        if (!sc.hasNextInt()) {
            sc.next();
            return runMenu();
        }

        System.out.println();
        return sc.nextInt();
    }
}


