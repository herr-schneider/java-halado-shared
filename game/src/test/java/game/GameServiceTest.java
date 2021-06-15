package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GameServiceTest {

    GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService(new GameRepository());
    }


    @Test
    void testGetGameWithMostGoalDifference() {
        Game expected = gameService.getGameWithMostGoalDifference();

        Assertions.assertEquals("Turkey", expected.getFirstCountry());
        Assertions.assertEquals("Italy", expected.getSecondCountry());
        Assertions.assertEquals(0, expected.getFirstCountryScore());
        Assertions.assertEquals(3, expected.getSecondCountryScore());
    }

    @ParameterizedTest
    @MethodSource("createArguments")
    void testGetGoalsParameterized(String country, int goals) {
        Assertions.assertEquals(goals, gameService.getGoals(country));
    }

    static Stream<Arguments> createArguments() {
        return Stream.of(
                arguments("Hungary", 1),
                arguments("Denmark", 0),
                arguments("Turkey", 1),
                arguments("Wales", 2)
        );
    }

    @Test
    void testGetCountryWithMostGoals() {
        Assertions.assertEquals(0, gameService.getCountryWithMostGoals());
    }
}
