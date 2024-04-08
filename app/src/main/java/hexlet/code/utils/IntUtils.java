package hexlet.code.utils;

public class IntUtils {
    public static boolean isInt(String value){
        try {
         Integer.parseInt(value);
         return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
