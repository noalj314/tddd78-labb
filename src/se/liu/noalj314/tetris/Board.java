package se.liu.noalj314.tetris;

import javax.swing.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;
    private final static Random RND = new Random();
    private Poly falling;
    private Point fallingPos;
    private final static int MARGIN = 2;
    private final static int DBL_MARGIN = MARGIN * 2;
    private List<BoardListener> listeners;
    private int score = 0;
    public boolean isGameOver = false;
    public boolean pauseGame = false;


    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.squares = new SquareType[height + DBL_MARGIN][width + DBL_MARGIN];
	this.listeners = new ArrayList<>();
	falling = null;
	fallingPos = null;

	for (int heightIndex = 0; heightIndex < squares.length; heightIndex++) {
	    for (int widthIndex = 0; widthIndex < squares[heightIndex].length; widthIndex++) {
		if (heightIndex < MARGIN || heightIndex >= height + MARGIN || widthIndex < MARGIN || widthIndex >= width + MARGIN) {
		    squares[heightIndex][widthIndex] = SquareType.OUTSIDE;
		} else {
		    squares[heightIndex][widthIndex] = SquareType.EMPTY;
		}
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
    public int getScore(){
	return score;
    }
    public int getDblMargin(){
	return DBL_MARGIN;
    }


    public SquareType getSquareType(int y, int x) {
	return squares[y + MARGIN][x + MARGIN];
    }

    public SquareType getVisibleSquareAt(int y, int x) {
	if (falling != null) { // if block is  falling
	    int blockY = y - fallingPos.y; // Positionen i y-led
	    int blockX = x - fallingPos.x; // Positionen i x-led
	    // Kontrollera om positionen ligger inom blockets dimensioner
	    if (blockX >= 0 && blockX < falling.getWidth() && blockY >= 0 && blockY < falling.getHeight()) {

		// Hämta SquareType för den positionen inom blocket
		SquareType square = falling.getSquareType(blockY, blockX);

		// Om det inte är en EMPTY, returnera denna SquareType
		if (square != SquareType.EMPTY) {
		    return square;
		}
	    }
	}
	// Om det inte finns något fallande block på denna position,
	// returnera SquareType från brädet
	return getSquareType(y, x);
    }
   public void tick(){
	if (falling == null) {
	    TetrominoMaker maker = new TetrominoMaker();
	    int randomNumber = RND.nextInt(maker.getNumberOfTypes());
	    falling = maker.getPoly(randomNumber); // 1-6
	    fallingPos= new Point(getWidth() / 2 - falling.getWidth() / 2, 0);
	    setFalling(falling, fallingPos);
	    shiftRows();
	    gameOver(); //to check if  it is game over
	    if (isGameOver){
		notifyListeners();
	    }
	} else {
	    dropFalling();
	    if (hasCollision()){
		fallingPos.y -= 1;
		addToBoard();
		falling = null;
	    }
	}
	notifyListeners();
   }
   public void setFalling(Poly block, Point startPosition){
	this.falling = block;
	this.fallingPos = startPosition;
    }

    public void dropFalling(){
	fallingPos.y += 1;
    }

    public void move(Direction direction) {
	if (falling != null) {
	    switch (direction) {
		case LEFT:
		    fallingPos.x -= 1;
		    if (hasCollision()) {
			fallingPos.x += 1;
		    }
		    break;
		case RIGHT:
		    fallingPos.x += 1;
		    if (hasCollision()) {
			fallingPos.x -= 1;
		    }
		    break;
	    }
	    notifyListeners();
	}
    }

    public void rotate(Direction dir) {
	if (falling != null) {
	    Poly rotated = null;
	    Poly copyFalling = falling;
	    switch (dir) {
		case RIGHT:
		    rotated = falling.rotate(true);    // true since right
		    break;
		case LEFT:
		    rotated = falling.rotate(false);
		    break;
	    }
	    falling = rotated;
	    if (hasCollision()) {
		falling = copyFalling;
	    }
	}
    }

    public boolean hasCollision() {
	for (int y = 0; y < falling.getHeight(); y++) {
	    for (int x = 0; x < falling.getWidth(); x++) {
		if ( falling.getSquareType(y, x) != SquareType.EMPTY && getSquareType(fallingPos.y + y,  fallingPos.x + x) != SquareType.EMPTY) {
		    return true;
		}
	    }
	}
	return false;
    }
    public void addToBoard() {
	for (int y = 0; y < falling.getHeight(); y++) {
	    for (int x = 0; x < falling.getWidth(); x++) {
		SquareType squareType = getVisibleSquareAt(y + fallingPos.y, x + fallingPos.x);
		squares[y + fallingPos.y + MARGIN][x + fallingPos.x + MARGIN] = squareType;
		}
	    }
	}
	public boolean isRowFull(int heightIndex) {
	    boolean rowFull = true;
	    for (int widthIndex = MARGIN; widthIndex < width + MARGIN; widthIndex++) {
		if (squares[heightIndex][widthIndex] == SquareType.EMPTY) {
		    rowFull = false;
		    break;
		}
	    }
	    return rowFull;
    	}

    public void shiftRows() {
	int rowsRemoved = 0;
	for (int y = height + MARGIN - 1; y >= MARGIN; y--) {
	    if (isRowFull(y)) {
		// flytta ner alla rader ovanför den här raden
		for (int shiftRow = y; shiftRow > MARGIN; shiftRow--) {
		    for (int widthIndex = MARGIN; widthIndex < width + MARGIN; widthIndex++) {
			squares[shiftRow][widthIndex] = squares[shiftRow - 1][widthIndex];
		    }
		}
		// sätt den översta raden till empty efter skiftningen
		for (int widthIndex = MARGIN; widthIndex < width + MARGIN; widthIndex++) {
		    squares[MARGIN][widthIndex] = SquareType.EMPTY;
		}
		// eftedrsom en rad har tagits bort och alla rader ovanför har flyttats ner så
		// öka y så att nästa for kör samma index igen
		y++;
		rowsRemoved ++;
	    }
	}
	if (rowsRemoved > 0) {
	    updateScore(rowsRemoved);
	}
    }
    private void updateScore(int rowsRemoved){
	Map<Integer, Integer> pointMap = Map.of(1, 100, 2, 300, 3, 500, 4, 800);
	score += pointMap.get(rowsRemoved);
    }

    public boolean gameOver() {
	if (hasCollision()) {
	    isGameOver = true;
	} else {
	    isGameOver = false;
	}
	return isGameOver;
    }
    public void addBoardListener(BoardListener bl) {
	listeners.add(bl);
    }
    public void clear(){
	for (int heightIndex = 0; heightIndex < squares.length; heightIndex++) {
	    for (int widthIndex = 0; widthIndex < squares[heightIndex].length; widthIndex++) {
		if (heightIndex < MARGIN || heightIndex >= height + MARGIN || widthIndex < MARGIN || widthIndex >= width + MARGIN) {
		    this.squares[heightIndex][widthIndex] = SquareType.OUTSIDE;
		} else {
		    this.squares[heightIndex][widthIndex] = SquareType.EMPTY;
		}
	    }
	}
	score = 0;
	notifyListeners();
    }
    public boolean getisGameOver(){
	return isGameOver;
    }
    public void restartGame(){
	clear();
    }
    private void notifyListeners() {
	for (BoardListener bl : listeners) {
		bl.boardChanged();
	}
    }

}

