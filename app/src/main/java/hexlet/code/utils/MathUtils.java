package hexlet.code.utils;

public class MathUtils {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int randomInt(int min, int max) {
        var random = Math.random() * (max - min + 1);
        return min + (int) random;
    }

    public static Integer gcd(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }

        if (num2 == 0) {
            return num1;
        }
        var min = Math.min(num1, num2);
        var max = Math.max(num1, num2);
        var remainder = max % min;
        return gcd(min, remainder);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        int start = number / 2;
        for (var i = start; i > 1; i -= 1) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
