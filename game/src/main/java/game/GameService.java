package game;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    public Game getGameWithMostGoalDifference() {
        return gameRepository.getGames().stream()
                .max(Comparator.comparing(game -> Math.abs((Integer.parseInt(game.getFirstCountryScore())) - (Integer.parseInt(game.getSecondCountryScore())))))
                .get();
    }
    public String getCountryWithMostGoals() {
            Map<String, Integer> result = new HashMap<>();
            int actual;
            int maxBattle = 0;
            String country = "Nincs";
            for (Game game : gameRepository.getGames()) {
                if (!result.containsKey(game.getFirstCountry())) {
                    result.put(game.getFirstCountry(), Integer.parseInt(game.getFirstCountryScore()));
                } else {
                    actual = result.get(game.getFirstCountry());
                    result.replace(game.getFirstCountry(), actual + Integer.parseInt(game.getFirstCountryScore()));
                    if (actual > maxBattle) {
                        maxBattle = actual + actual + Integer.parseInt(game.getFirstCountryScore());
                        country = game.getFirstCountry();
                    }
                }
                if (!result.containsKey(game.getSecondCountry())) {
                    result.put(game.getSecondCountry(), Integer.parseInt(game.getSecondCountryScore()));
                } else {
                    actual = result.get(game.getSecondCountry());
                    result.replace(game.getSecondCountry(), actual + Integer.parseInt(game.getSecondCountryScore()));
                    if (actual > maxBattle) {
                        maxBattle = actual + actual + Integer.parseInt(game.getSecondCountryScore());
                        country = game.getSecondCountry();
                    }
                }
            }
            return country;
    }


    public int getGoals(String country) {
        int goals = 0;
        for (Game g : gameRepository.getGames()) {
            if (g.getFirstCountry().equals(country)) {
                goals += Integer.parseInt(g.getFirstCountryScore());
            } else if (g.getSecondCountry().equals(country)) {
                goals += Integer.parseInt(g.getSecondCountryScore());
            }
        }
        return goals;
    }
}
