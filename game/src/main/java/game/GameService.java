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
                .max(Comparator.comparing(game -> Math.abs((game.getFirstCountryScore()) - (game.getSecondCountryScore()))))
                .get();
    }
    public String getCountryWithMostGoals() {
            Map<String, Integer> result = new HashMap<>();
            int actual;
            int maxBattle = 0;
            String country = "Nincs";
            for (Game game : gameRepository.getGames()) {
                if (!result.containsKey(game.getFirstCountry())) {
                    result.put(game.getFirstCountry(), game.getFirstCountryScore());
                    //System.out.println("First_init");
                } else {
                    actual = result.get(game.getFirstCountry());
                    result.replace(game.getFirstCountry(), actual + game.getFirstCountryScore());
                    if (actual > maxBattle) {
                        maxBattle = actual + actual + game.getFirstCountryScore();
                        country = game.getFirstCountry();
                        //System.out.println("First_inc");
                    }
                }
                if (!result.containsKey(game.getSecondCountry())) {
                    result.put(game.getSecondCountry(), game.getSecondCountryScore());
                    //System.out.println("Second_init");
                } else {
                    actual = result.get(game.getSecondCountry());
                    result.replace(game.getSecondCountry(), actual + game.getSecondCountryScore());
                    if (actual > maxBattle) {
                        maxBattle = actual + actual + game.getSecondCountryScore();
                        country = game.getSecondCountry();
                       // System.out.println("Second_inc");
                    }
                }
            }
            return country;
    }

    public Game largestGoalDiff() {
        return gameRepository.getGames().stream()
                .max(Comparator.comparing(game -> Math.abs(game.getFirstCountryScore() - game.getSecondCountryScore()))).get();
    }

    public int getGoals(String country) {
        int goals = 0;
        for (Game g : gameRepository.getGames()) {
            if (g.getFirstCountry().equals(country)) {
                goals += g.getFirstCountryScore();
            } else if (g.getSecondCountry().equals(country)) {
                goals += g.getSecondCountryScore();
            }
        }
        return goals;
    }
}
