package game;

import java.util.List;

public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public String getCountryWithMostGoals() {
        String result = "Nincs ilyen!";
        int maxGoal = 0;
        List<Game> games = gameRepository.getGames();
        for (Game game : games) {
            if (Integer.parseInt(game.getFirstCountryScore()) > Integer.parseInt(game.getSecondCountryScore()) && Integer.parseInt(game.getFirstCountryScore()) > maxGoal) {
                result = game.getFirstCountry();
                maxGoal = Integer.parseInt(game.getFirstCountryScore());
            }

            if (Integer.parseInt(game.getSecondCountryScore()) > maxGoal) {
                result = game.getSecondCountry();
                maxGoal = Integer.parseInt(game.getSecondCountryScore());
            }
        }
    }
}
        return result;
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

public Game getGameWithMostGoalDifference() {
        return gameRepository.getGames().stream()
        .max(Comparator.comparing(game -> Math.abs(game.getFirstCountryScore() - game.getSecondCountryScore())))
        .get();
        }
