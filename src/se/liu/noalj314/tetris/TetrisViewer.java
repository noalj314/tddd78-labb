package se.liu.noalj314.tetris;
import javax.swing.*;
import java.awt.*;

public class TetrisViewer
{
    private Board board;
    public TetrisViewer(Board board) {
        this.board = board;
    }
    public void show() {
        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea area = new JTextArea(board.getHeight(), board.getWidth());
        area.setText(new BoardToTextConverter().convertToText(board));
        area.setFont(new Font("Monospaced", Font.PLAIN, 20));

        frame.setLayout(new BorderLayout());
        frame.add(area, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
