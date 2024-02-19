package se.liu.noalj314.tetris;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Heavy extends AbstractFallHandler
{
    @Override
    public boolean hasCollision(Board board, Point lastFallingPos) {
	if (board.getFallingPos().x != lastFallingPos.x) {
	    return super.hasCollision(board, lastFallingPos);
	} else {
	    boolean canBePushedDown = true;
	    List<Point> toBePushed = new ArrayList<>();

	    for (int y = 0; y < board.getFalling().getHeight(); y++) {
		for (int x = 0; x < board.getFalling().getWidth(); x++) {
		    SquareType fallType = board.getFalling().getSquareType(y, x);
		    int boardX = board.getFallingPos().x + x;
		    int boardY = board.getFallingPos().y + y;
		    SquareType boardType = board.getSquareType(boardY, boardX);


		    if (ifCondition(fallType, boardType)) {
			if (boardType != SquareType.OUTSIDE) {
			    toBePushed.add(new Point(boardX, boardY));
			} else {
			    return true; // kollision med boardsgräns
			}
		    }
		}
	    }

	    for (Point p : toBePushed) {
		if (!support(p.y + 1, p.x, board)) {
		    canBePushedDown = false;
		    break;
		}
	    }

	    if (canBePushedDown) {
		pushDown(toBePushed, board);
		return false; // ingen kollision kvadrater trycks ner
	    } else {
		return true; // colllision kvadrater kan inte tryckas ner
	    }
	}
    }

    @Override public String getDescription() {
	return "Heavy";
    }

    @Override protected boolean ifCondition(final SquareType fallType, final SquareType boardType) {
	return fallType != SquareType.EMPTY && boardType != SquareType.EMPTY;
    }

    public boolean support(int yStart, int x, Board board){
	for (int y = yStart; y < board.getHeight(); y++){
	    if (board.getSquareType(y, x) == SquareType.EMPTY) {
		return true; // det finns ett tomt hål här så kan tryckas ner
	    }
	}
	return false; // inte tomt kan inte tryckas ner
    }
    public void pushDown(List<Point> points, Board board) {
	points.sort((p1, p2) -> Integer.compare(p2.y, p1.y));

	for (Point point : points) {
	    if (point.y + 1 < board.getHeight()) {
		SquareType currentType = board.getSquareType(point.y, point.x);
		SquareType belowType = board.getSquareType(point.y + 1, point.x);

		if (belowType == SquareType.EMPTY) {
		    board.setSquareType( SquareType.EMPTY, point.x, point.y); // Korrekt ordning av argument
		    board.setSquareType(currentType, point.x, point.y +1); // Korrekt ordning av argument
		}
	    }
	}
    }
}

