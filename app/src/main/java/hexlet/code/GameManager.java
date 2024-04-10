package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;

public class GameManager {
    static final int GAME_ROUNDS = 3;

    private static final int TYPE_EVEN_GAME = 2;
    private static final int TYPE_CALC_GAME = 3;
    private static final int TYPE_GCD_GAME = 4;
    private static final int TYPE_PROGRESSION_GAME = 5;
    private static final int TYPE_PRIME_GAME = 6;

    private static final int[] GAME_TYPES
            = {TYPE_EVEN_GAME, TYPE_CALC_GAME, TYPE_GCD_GAME, TYPE_PROGRESSION_GAME, TYPE_PRIME_GAME};

    static String[] getQuestionPair(int gameType) {
        return switch (gameType) {
            case TYPE_EVEN_GAME -> EvenGame.getQuestionPair();
            case TYPE_CALC_GAME -> CalcGame.getQuestionPair();
            case TYPE_GCD_GAME -> GcdGame.getQuestionPair();
            case TYPE_PROGRESSION_GAME -> ProgressionGame.getQuestionPair();
            case TYPE_PRIME_GAME -> PrimeGame.getQuestionPair();
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };
    }

    static String getRules(int gameType) {
        return switch (gameType) {
            case TYPE_EVEN_GAME -> EvenGame.RULES;
            case TYPE_CALC_GAME -> CalcGame.RULES;
            case TYPE_GCD_GAME -> GcdGame.RULES;
            case TYPE_PROGRESSION_GAME -> ProgressionGame.RULES;
            case TYPE_PRIME_GAME -> PrimeGame.RULES;
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };
    }

    static String getTitle(int gameType) {
        return switch (gameType) {
            case TYPE_EVEN_GAME -> EvenGame.TITLE;
            case TYPE_CALC_GAME -> CalcGame.TITLE;
            case TYPE_GCD_GAME -> GcdGame.TITLE;
            case TYPE_PROGRESSION_GAME -> ProgressionGame.TITLE;
            case TYPE_PRIME_GAME -> PrimeGame.TITLE;
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };
    }

    static String[] getMenuTitles() {
        String[] titles = new String[GAME_TYPES.length];
        var i = 0;
        for (var type : GAME_TYPES) {
            titles[i] = "%d - %s".formatted(type, getTitle(type));
            i += 1;
        }
        return titles;
    }

    static boolean hasGame(int gameType) {
        for (var game : GAME_TYPES) {
            if (game == gameType) {
                return true;
            }
        }
        return false;
    }
}
