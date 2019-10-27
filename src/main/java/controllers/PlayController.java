package controllers;

import models.Game;
import models.Color;
import models.Coordinate;
import models.Piece;

public class PlayController extends AcceptController {

	public PlayController(Game game) {
	}

	public Error move(Coordinate origin, Coordinate target) {
		return null;
	}

	public Piece getPiece(Coordinate coordinate) {
		return null;
	}

	public Color getTurn() {
		return Color.BLACK;
	}

	public boolean isWinner() {
		return false;
	}

	public boolean isDraw() {
		return false;
	}

	public void cancel() {

	}
}