package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GameServiceTest {

    GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService(new GameRepository());
    }


    @Disabled
    void testGetGameWithMostGoalDifference() {
       // Game expected = gameService.getGameWithMostGoalDifference();

//        Assertions.assertEquals("Turkey", expected.getFirstCountry());
//        Assertions.assertEquals("Italy", expected.getSecondCountry());
//        Assertions.assertEquals(0, expected.getFirstCountryScore());
//        Assertions.assertEquals(3, expected.getSecondCountryScore());
    }

    @Test
    void testGetCountryWithMostGoals() {
        Assertions.assertEquals(0, gameService.getCountryWithMostGoals());
    }
}
