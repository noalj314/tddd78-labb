package se.liu.noalj314.tetris;

public class BoardTester
{
    public static void main(String[] args) {
	Board myBoard = new Board(20, 10);
	for (int i = 0; i <  11; i++) {
	    myBoard.randomSquares();
	    BoardToTextConverter myConverter = new BoardToTextConverter();
	    System.out.println(myConverter.convertToText(myBoard));
	}
    }
}
