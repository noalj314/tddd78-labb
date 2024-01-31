package se.liu.noalj314.tetris;
import javax.swing.*;
import java.awt.*;


public class TetrisViewer
{
    private Board board;
    private Timer timer;
    private TetrisComponent tetrisComponent;
    public TetrisViewer(Board board) {
        this.board = board;
        this.tetrisComponent = new TetrisComponent(board);
    }
    public void show() {
        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.add(tetrisComponent, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        board.tick();
        startTimer();
    }

    private void startTimer() {
        StepMaker stepMaker = new StepMaker(board);
        timer = new Timer(1000, stepMaker);
        timer.start();
    }
}
