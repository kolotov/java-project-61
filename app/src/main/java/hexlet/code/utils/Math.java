package hexlet.code.utils;

public class Math {
    public static int randomInt(int min, int max) {
        var random = java.lang.Math.random() * (max - min + 1);
        return min + (int)random;
    }
}
