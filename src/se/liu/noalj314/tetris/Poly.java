package se.liu.noalj314.tetris;

public class Poly
{
    private SquareType[][] shape;
    public Poly(final SquareType[][] shape) {
	this.shape = shape;
    }

    public int getWidth() {
	return shape[0].length;
    }

    public int getHeight() {
	return shape.length;
    }
    public SquareType[][] getShape(){
	return shape;
    }
    public Poly rotate(boolean right) {
	if (right) {
	    return rotateRight();
	} else {
	    return rotateLeft();
	}
    }
    public Poly rotateRight() {
	Poly newPoly = new Poly(new SquareType[this.getHeight()][this.getWidth()]);
	for (int r = 0; r < this.getHeight(); r++) {
	    for (int c = 0; c < this.getWidth(); c++){
		newPoly.shape[c][newPoly.getWidth()-1-r] = this.shape[r][c];
	    }
	}
	return newPoly;
    }
    public Poly rotateLeft() {
	Poly newPoly = new Poly(new SquareType[this.getHeight()][this.getWidth()]);
	for (int i = 0; i < 3; i++) {
	    for (int r = 0; r < this.getHeight(); r++) {
		for (int c = 0; c < this.getWidth(); c++) {
		    newPoly.shape[c][newPoly.getWidth() - 1 - r] = this.shape[r][c];
		}
	    }
	}
	return newPoly;
    }
    public SquareType getSquareType(int y, int x) {return shape[y][x];}
}