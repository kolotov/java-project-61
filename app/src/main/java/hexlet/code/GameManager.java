package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;

public class GameManager {
    static final int GAME_ROUNDS = 3;

    private static final int TYPE_EVEN_GAME = 2;
    private static final int TYPE_CALC_GAME = 3;
    private static final int TYPE_GCD_GAME = 4;
    private static final int TYPE_PROGRESSION_GAME = 5;

    static final int[] GAME_TYPES = {
            GameManager.TYPE_EVEN_GAME,
            GameManager.TYPE_CALC_GAME,
            GameManager.TYPE_GCD_GAME,
            GameManager.TYPE_PROGRESSION_GAME
    };

    static String[] getQuestionPair(int gameType) {
        return switch (gameType) {
            case GameManager.TYPE_EVEN_GAME -> EvenGame.getQuestionPair();
            case GameManager.TYPE_CALC_GAME -> CalcGame.getQuestionPair();
            case GameManager.TYPE_GCD_GAME -> GcdGame.getQuestionPair();
            case GameManager.TYPE_PROGRESSION_GAME -> ProgressionGame.getQuestionPair();
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };
    }

    static String getRules(int gameType) {
        return switch (gameType) {
            case GameManager.TYPE_EVEN_GAME -> EvenGame.RULES;
            case GameManager.TYPE_CALC_GAME -> CalcGame.RULES;
            case GameManager.TYPE_GCD_GAME -> GcdGame.RULES;
            case GameManager.TYPE_PROGRESSION_GAME -> ProgressionGame.RULES;
            default -> throw new IllegalStateException("Unexpected value: " + gameType);
        };
    }

    static String getTitle(int gameType) {
        return switch (gameType) {
            case GameManager.TYPE_EVEN_GAME -> EvenGame.TITLE;
            case GameManager.TYPE_CALC_GAME -> CalcGame.TITLE;
            case GameManager.TYPE_GCD_GAME -> GcdGame.TITLE;
            case GameManager.TYPE_PROGRESSION_GAME -> ProgressionGame.TITLE;
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
