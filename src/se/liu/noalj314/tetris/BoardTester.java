package se.liu.noalj314.tetris;
import javax.swing.Timer;
public class BoardTester {
    public static void main(String[] args) {
	Board myBoard = new Board(20, 10);
	TetrisViewer myViewer = new TetrisViewer(myBoard);
	myViewer.show();

	for (int i = 0; i <  11; i++) {
		BoardToTextConverter myConverter = new BoardToTextConverter();
        	//System.out.println(myConverter.convertToText(myBoard));
	}
    }
}

