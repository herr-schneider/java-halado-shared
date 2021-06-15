package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public int getCountryWithMostGoals() {
        int mostGoal = 0;
        Map<String, Integer> result = new HashMap<>();
        int actual;
        for (Game game : gameRepository.getGames()) {
            if (!result.containsKey(game.getFirstCountry())) {
                result.put(game.getFirstCountry(), Integer.parseInt(game.getFirstCountryScore()));
            } else {
                actual = result.get(game.getFirstCountry());
                result.replace(game.getFirstCountry(), actual + 1);
                if (actual > mostGoal) {
                    mostGoal = actual + 1;
                }
            }
            if (!result.containsKey(game.getSecondCountry())) {
                result.put(game.getSecondCountry(), Integer.parseInt(game.getSecondCountryScore()));
            } else {
                actual = result.get(game.getSecondCountry());
                result.replace(game.getSecondCountry(), actual + 1);
                if (actual > mostGoal) {
                    mostGoal = actual + 1;
                }
            }
        }
        return mostGoal;
    }
}