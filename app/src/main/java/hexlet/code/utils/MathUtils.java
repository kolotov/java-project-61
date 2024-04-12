package hexlet.code.utils;

public class MathUtils {
    public static int randomInt(int min, int max) {
        var random = Math.random() * (max - min + 1);
        return min + (int) random;
    }
}
