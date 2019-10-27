package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class GameTest {
    public GameTest() {

    }

    public void givenGameWhenMoveFirstTimeThenIsBlack() {
        Game game = new Game();

        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);

        assertNull(game.move(origin, target));

        assertEquals(game.getTurn(), Color.BLACK);
    }

    public void givenGameWhenFirtTurnThenIsWhite() {
        Game game = new Game();

        assertEquals(game.getTurn(), Color.WHITE);
    }

    public void givenGameWhenFirstMoveThenNoWinnerNoDraw() {
        Game game = new Game();

        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);

        assertNull(game.move(origin, target)); 
        assertFalse(game.isWinner());
        assertFalse(game.isDraw());
    }

    public void givenGameWhenGameHasBeenPlayedThenWinnerWhite() {
        Game game = new Game();

        //TODO PLAY ALL THE GAME
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);

        assertNull(game.move(origin, target)); 
        assertTrue(game.isWinner());
        assertEquals(game.getTurn(), Color.WHITE);
    }

    public void givenGameWhenGameHasBeenPlayedThenDraw() {
        Game game = new Game();

        //TODO PLAY ALL THE GAME
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);

        assertNull(game.move(origin, target)); 
        assertFalse(game.isWinner());
        assertTrue(game.isDraw());

    }
}