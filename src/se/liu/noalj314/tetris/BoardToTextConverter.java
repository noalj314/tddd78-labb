package se.liu.noalj314.tetris;

public class BoardToTextConverter
{
    public String convertToText(Board board) {
	StringBuilder sb = new StringBuilder();
	for (int heightIndex = 0; heightIndex < board.getHeight(); heightIndex++) {
	    for (int widthIndex = 0; widthIndex < board.getWidth(); widthIndex++) {
		switch(board.getSquareType(heightIndex, widthIndex)) {
		    case SquareType.EMPTY:
			sb.append("_");
			break;
		    case SquareType.I:
			sb.append("I");
			break;
		    case SquareType.O:
			sb.append("O");
			break;
		    case SquareType.T:
			sb.append("T");
			break;
		    case SquareType.S:
			sb.append("S");
			break;
		    case SquareType.Z:
			sb.append("Z");
			break;
		    case SquareType.J:
			sb.append("J");
			break;
		    case SquareType.L:
			sb.append("L");
			break;
		}
	    }
	    sb.append("\n");
	}
	return sb.toString();
    }
}
