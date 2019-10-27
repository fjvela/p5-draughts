package controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Game;
import models.StateValue;

public class ResumeControllerTest {

    public ResumeControllerTest() {
    }

    @Test
    public void givenResumeControllerWhenUserNotContinueThenGameStateIsExit() {
        Game game = new Game();
        ResumeController resumeController = new ResumeController(game);
        resumeController.resume(false);

        assertEquals(game.getStateValue(), StateValue.EXIT);
    }

    @Test
    public void givenResumeControllerWhenUserContinueThenGameStateIsInitial() {
        Game game = new Game();
        ResumeController resumeController = new ResumeController(game);
        resumeController.resume(true);

        assertEquals(game.getStateValue(), StateValue.INITIAL);
    }
}