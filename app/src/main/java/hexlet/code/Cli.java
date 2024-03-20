package hexlet.code;
import java.util.Scanner;
public class Cli {
    public static void greetUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        var sc = new Scanner(System.in);
        var name = sc.nextLine();
        System.out.printf("Hello, %s!%n", name);
    }
}
