package hexlet.code;

import hexlet.code.utils.IntUtils;

public class App {
    public static void main(String[] args) {
        int itemNumber = -1;
        while (itemNumber != 0) {
            itemNumber = handle();
        }
    }

    private static int handle() {
        showMenu();

        var answer = Engine.promptUser("Your choice: ");
        if (answer == null || !IntUtils.isInt(answer)) {
            return -1;
        }

        var itemNumber = Integer.parseInt(answer);
        if (itemNumber == 1) {
            Cli.greetUser();
            return 0;
        }

        if (GameManager.hasGame(itemNumber)) {
            Engine.run(itemNumber);
        }
        return itemNumber;
    }

    private static void showMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Great");
        for (var item : GameManager.getMenuTitles()) {
            System.out.println(item);
        }
        System.out.println("0 - Exit");
    }
}


