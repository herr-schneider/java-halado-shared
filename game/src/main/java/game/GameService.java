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
}
