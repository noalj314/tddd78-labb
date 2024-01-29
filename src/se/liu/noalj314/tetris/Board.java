package se.liu.noalj314.tetris;

import java.awt.Point;
import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;
    private final static Random RND = new Random();
    private Poly falling;
    private Point fallingPos;

    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.squares = new SquareType[height][width];
	this.falling = new TetrominoMaker().getPoly(1);
	this.fallingPos = new Point(width / 2, 0);
	for (int heightIndex = 0; heightIndex < height; heightIndex++) {
	    for (int widthIndex = 0; widthIndex < width; widthIndex++) {
		this.squares[heightIndex][widthIndex] = SquareType.EMPTY;
	    }
	}
    }

    public Poly getFalling() {
	return falling;
    }

    public Point getFallingPos() {
	return fallingPos;
    }
    public int getHeight() {
	return height;
    }
    public int getWidth() {
	return width;
    }

    public SquareType getSquareType(int y, int x) {
	if (x < 0 || x >= width || y < 0 || y >= height) {
	    throw new IllegalArgumentException("Coordinates out of bounds");
	}
	return squares[y][x];
    }
    public SquareType getVisibleSquareAt(int y, int x) {
	if (falling != null) { // if block is  falling
	    int blockY = y - fallingPos.y; // Positionen i x-led
	    int blockX = x - fallingPos.x; // Positionen i y-led
	    // Kontrollera om positionen ligger inom blockets dimensioner
	    if (blockX >= 0 && blockX < falling.getWidth() &&
		blockY >= 0 && blockY < falling.getHeight()) {

		// Hämta SquareType för den positionen inom blocket
		SquareType square = falling.getShape()[blockY][blockX];

		// Om det inte är en EMPTY, returnera denna SquareType
		if (square != SquareType.EMPTY) {
		    return square;
		}
	    }
	}

	// Om det inte finns något fallande block på denna position,
	// returnera SquareType från brädet
	return squares[y][x];
    }
    public void randomSquares() {
	for (int heightIndex = 0; heightIndex < height; heightIndex++) {
	    for (int widthIndex = 0; widthIndex < width; widthIndex++) {
		SquareType[] squareTypes = SquareType.values();
		int randomIndex = RND.nextInt(squareTypes.length);
		squares[heightIndex][widthIndex] = squareTypes[randomIndex];
	    }
	}
    }


    public static void main(String[] args) {
	Board myBoard = new Board(10, 10);
	System.out.println(myBoard.getSquareType(0, 0));
    }

}
