package models;


public abstract class Piece {

	public Color getColor() {
		return null;
	}

	public abstract boolean canMove(Coordinate origin, Coordinate target);

}