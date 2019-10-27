package models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KingTest {
    public KingTest() {
    }

    @Test
    public void givenKingWhenCanMoveVerticallyThenFalse() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(2, 2);
        King King = new King();
        assertFalse(King.canMove(origin, target));

    }

    @Test
    public void givenKingWhenCanMoveHorizotallyThenFalse() {
        Coordinate origin = new Coordinate(3, 1);
        Coordinate target = new Coordinate(3, 2);
        King King = new King();
        assertFalse(King.canMove(origin, target));
    }

    @Test
    public void givenKingWhenCanMoveDiagonalFordwardThenTrue() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        King King = new King();
        assertTrue(King.canMove(origin, target));
    }

    @Test
    public void givenKingWhenCanMoveDiagonalBackwardThenTrue() {
        Coordinate origin = new Coordinate(3, 2);
        Coordinate target = new Coordinate(2, 1);
        King King = new King();
        assertTrue(King.canMove(origin, target));
    }
}