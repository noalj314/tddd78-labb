package se.liu.noalj314.tetris;
import javax.swing.*;
import java.awt.event.ActionEvent;
public class BoardTester {
    public static void main(String[] args) {
	Board myBoard = new Board(10, 20);
	TetrisViewer myViewer = new TetrisViewer(myBoard);
	HighscoreList highscoreList = new HighscoreList();
	myViewer.show();
    }
}

