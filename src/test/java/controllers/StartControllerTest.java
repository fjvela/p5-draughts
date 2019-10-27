package controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Game;
import models.StateValue;

public class StartControllerTest {
    public StartControllerTest() {

    }

    @Test
    public void givenStartControllerWhenStartThenGameStateIsInGame() {
        Game game = new Game();
        StartController startController = new StartController(game);
        startController.start();

        assertEquals(game.getStateValue(), StateValue.IN_GAME);

    }
}