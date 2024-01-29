package se.liu.noalj314.tetris;

public class BoardToTextConverter
{
    public String convertToText(Board board) {
	StringBuilder sb = new StringBuilder();
	for (int y = 0; y < board.getHeight(); y++) {
	    for (int x = 0; x < board.getWidth(); x++) {
		SquareType square = board.getVisibleSquareAt(y, x);
		sb.append(squareToChar(square));
	    }
	    sb.append("\n");
    	}
	return sb.toString();
    }

	private char squareToChar(SquareType square) {
	    switch(square) {
		case EMPTY: return '_';
		case I: return 'I';
		case O: return 'O';
		case T: return 'T';
		case S: return 'S';
		case Z: return 'Z';
		case J: return 'J';
		case L: return 'L';
		default: return '_'; // för oförutsedda fall
	    }
	}
    }

