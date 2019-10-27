package models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MenTest {
    public MenTest() {
    }

    @Test
    public void givenMenWhenCanMoveVerticallyThenFalse() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(2, 2);
        Men men = new Men();
        assertFalse(men.canMove(origin, target));

    }

    @Test
    public void givenMenWhenCanMoveHorizotallyThenFalse() {
        Coordinate origin = new Coordinate(3, 1);
        Coordinate target = new Coordinate(3, 2);
        Men men = new Men();
        assertFalse(men.canMove(origin, target));
    }

    @Test
    public void givenMenWhenCanMoveDiagonalFordwardThenTrue() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        Men men = new Men();
        assertTrue(men.canMove(origin, target));
    }

    @Test
    public void givenMenWhenCanMoveDiagonalBackwardThenFalse() {
        Coordinate origin = new Coordinate(3, 2);
        Coordinate target = new Coordinate(2, 1);
        Men men = new Men();
        assertFalse(men.canMove(origin, target));
    }
}