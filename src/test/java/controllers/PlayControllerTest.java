package controllers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import models.Game;
import models.King;
import models.Men;
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

    @Test
    public void givenPlayControllerWhenMovementIsTheSameThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(5, 5);
        Coordinate target = new Coordinate(5, 5);
        PlayController playController = new PlayController(game);
        assertNotNull(playController.move(origin, target));
    }

    @Test
    public void givenPlayControlerWhenMoveOutBoardMinThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(-2, -1);
        PlayController playController = new PlayController(game);
        assertNotNull(playController.move(origin, target));
    }

    @Test
    public void givenPlayControlerWhenMoveOutBoardMaxThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(200, 100);
        PlayController playController = new PlayController(game);
        assertNotNull(playController.move(origin, target));
    }

    @Test
    public void givenPlayControllerWhenPieceIsMenAndMoveIsVerticalThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 1);
        PlayController playController = new PlayController(game);
        assertThat(playController.getPiece(target), instanceOf(Men.class));
        assertNotNull(playController.move(origin, target));
    }

    @Test
    public void givenPlayControllerWhenPieceIsMenAndMoveIsHorizontalThenError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(2, 2);
        PlayController playController = new PlayController(game);
        assertThat(playController.getPiece(target), instanceOf(Men.class));
        assertNotNull(playController.move(origin, target));
    }

    @Test
    public void givenPlayControllerWhenPieceReachKingRowThenPieceHasBeenConvertedKing() {
        Game game = new Game();

        Coordinate origin = new Coordinate(7, 5);
        Coordinate target = new Coordinate(8, 4);
        PlayController playController = new PlayController(game);
        assertNotNull(playController.move(origin, target));
        Piece piece = playController.getPiece(target);

        assertThat(piece, instanceOf(King.class));
    }

    @Test
    public void givenPlayControllenWhenMoveThenTurnIsChanged() {
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        PlayController playController = new PlayController(game);
        assertNull(playController.move(origin, target));
        assertEquals(playController.getTurn(), Color.BLACK);

        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }
}