package se.liu.noalj314.tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TetrisViewer extends JFrame
{
    private Board board;
    private Timer timer;
    private TetrisComponent tetrisComponent;
    private HighscoreComponent highscoreComponent;

    public TetrisViewer(Board board) {
        this.showStartImage();
        createMenu();
        this.board = board;
        this.tetrisComponent = new TetrisComponent(board);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(tetrisComponent, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        startTimer();
    }
    public void gameOverScreen(){
        this.highscoreComponent = new HighscoreComponent(board.getHighscoreList(), board);
        this.remove(tetrisComponent);
        this.add(highscoreComponent,  BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.repaint();
        this.validate();
    }

    public void startGame(){
        this.remove(highscoreComponent);
        this.add(tetrisComponent, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        startTimer();
    }

    public void startTimer() {
        final Action doOneStep = new AbstractAction()
        {
            @Override public void actionPerformed(final ActionEvent e) {
                if (!board.isGameOver) {
                    board.tick();
                } else if (highscoreComponent.playAgain) {
                    startGame();
                    board.isGameOver = false;
                } else {
                   // timer.stop();
                    gameOverScreen();

                }
            }
        };
        timer = new Timer(500, doOneStep);
        timer.setCoalesce(true);
        timer.start();
    }

    private void createMenu() {
        final JMenuBar bar = new JMenuBar();
        final JMenu file = new JMenu("Fil");
        JMenuItem quit = (new JMenuItem("Avsluta"));
        quit.addActionListener(new QuitListener());
        file.add(quit);
        bar.add(file);
        this.setJMenuBar(bar);
    }
    public void showStartImage() {
        JDialog startDialog = new JDialog(this, "Start Image", true);
        startDialog.add(new StartImage());
        startDialog.setSize(300, 300);
        Timer timer = new Timer(2000, e -> startDialog.dispose());
        timer.setRepeats(false);
        timer.start();
        startDialog.setVisible(true);
        startDialog.pack();
    }


    private class QuitListener implements ActionListener {
        @Override public void actionPerformed(final ActionEvent e) {
            if(JOptionPane.showConfirmDialog(null, "Är du säker på det?", "Avsluta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }
}