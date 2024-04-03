package hexlet.code;

import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);

    //TODO: add validation
    public static void main(String[] args) {
        int itemNumber = -1;
        while (itemNumber != 0) {
            showMenu();
            itemNumber = requestChoice();
            handle(itemNumber);
        }
    }

    private static void handle(int itemNumber) {
        if (itemNumber == 1) {
            Cli.greetUser();
            return;
        }

        Engine.run(itemNumber);
    }

    private static int requestChoice() {
        System.out.print("Your choice: ");
        if (!sc.hasNextInt()) {
            sc.next();
            return -1;
        }
        return sc.nextInt();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Great");
        for (var item : Engine.GAME_ITEMS) {
            System.out.println(item);
        }
        System.out.println("0 - Exit");
    }
}


