package models;
import static org.hamcrest.CoreMatchers.instanceOf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {
    public BoardTest() {
    }

    @Test
    public void givenBoardWhenHasBeenStartedThenCanMoveAnyPiece() {
        Board board = new Board();
        assertTrue(board.canMoveAnyPiece());
    }

    @Test
    public void givenBoardWhenHasBeenPlayedThenCanNotMoveAnyPiece() {
        Board board = new Board();

        // TODO play all board and set in unplayeable game;
        board.move(new Coordinate(1, 3), new Coordinate(2, 4));

        assertFalse(board.canMoveAnyPiece());
    }

    @Test
    public void givenBoardWhenMenReachKingRowThenPieceHasBeenConvertedKing() {
        Board board = new Board();

        Coordinate origin = new Coordinate(7, 5);
        Coordinate target = new Coordinate(8, 4);
        
        assertNotNull(board.move(origin, target));
        assertThat(board.getPiece(target), instanceOf(King.class));

    }

}