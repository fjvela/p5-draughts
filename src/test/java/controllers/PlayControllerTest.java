package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import models.Game;
import models.Coordinate;
import models.Piece;
import models.Color;

public class PlayControllerTest {

    public PlayControllerTest() {

    }

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        PlayController playController = new PlayController(game);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }


}