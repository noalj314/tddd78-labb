package se.liu.noalj314.tetris;

public class Poly
{
    SquareType[][] shape;
    public Poly(final SquareType[][] shape) {
	this.shape = shape;
    }

    public int getWidth() {
	return shape[0].length;
    }

    public int getHeight() {
	return shape.length;
    }

    public SquareType[][] getShape() {
	return shape;
    }
}