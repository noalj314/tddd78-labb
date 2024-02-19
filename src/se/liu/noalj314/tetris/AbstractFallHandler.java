package se.liu.noalj314.tetris;


import java.awt.*;

public abstract class AbstractFallHandler implements FallHandler
{
    public boolean hasCollision(Board board, Point lastFallingPos) {
	for (int y = 0; y < board.getFalling().getHeight(); y++) {
	    for (int x = 0; x < board.getFalling().getWidth(); x++) {

		SquareType fallType = board.getFalling().getSquareType(y,x);
		SquareType boardType = board.getSquareType(board.getFallingPos().y + y,  board.getFallingPos().x + x);

		if (ifCondition(fallType, boardType)) {
		    return true;
		}
	    }
	}
	return false;
    }
    protected abstract boolean ifCondition(SquareType fallType, SquareType boardType);
}
