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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running");
                JFrame frame = new JFrame("Tetris");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(tetrisComponent, BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
                startTimer();
            }
        });
    }

    public void startTimer() {
        StepMaker stepMaker = new StepMaker(board);
        timer = new Timer(1000, stepMaker);
        timer.start();
    }
}
