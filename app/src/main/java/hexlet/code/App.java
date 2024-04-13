package hexlet.code;

public class App {
    public static void main(String[] args) {
        while (true) {
            showMenu();
            var answer = Engine.promptUser("Your choice: ");
            if (!isInt(answer)) {
                continue;
            }

            var itemNumber = Integer.parseInt(answer);
            if (itemNumber == 0) {
                return;
            }

            if (itemNumber == 1) {
                Cli.greetUser();
                return;
            }

            if (Engine.hasGame(itemNumber)) {
                Engine.run(itemNumber);
                return;
            }
        }
    }

    private static void showMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Great");
        for (var item : Engine.GAME_TITLES) {
            System.out.println(item);
        }
        System.out.println("0 - Exit");
    }

    private static boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


