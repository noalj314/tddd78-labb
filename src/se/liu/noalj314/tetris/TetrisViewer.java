package se.liu.noalj314.tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TetrisViewer extends JFrame
{
    private Board board;
    private HighscoreList highscoreList = new HighscoreList();

    private Timer timer;
    private TetrisComponent tetrisComponent;
    private HighscoreComponent highscoreComponent = null;
    private boolean gameOverScreenActive;
    private int timerDelay = 750;
    private int timerCounter = 0;

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
        highscoreList.addHighscore(new Highscore(JOptionPane.showInputDialog("Enter name!"), board.getScore()));
        if (highscoreComponent != null) {
            this.remove(highscoreComponent);
        }
        this.highscoreComponent = new HighscoreComponent(highscoreList, board);

        this.remove(tetrisComponent);
        this.add(highscoreComponent,  BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.repaint();
        this.validate();
        gameOverScreenActive = true;
    }

    public void startGame(){
        // Check if highscoreComponent exists and reset or remove it
        gameOverScreenActive = false;

        if (highscoreComponent != null) {
            this.remove(highscoreComponent);
            highscoreComponent = null;
            // Setup highscoreComponent as necessary
        }
        board.clear(); // Reset the board state
        board.isGameOver = false; // Reset game over state
        this.add(tetrisComponent, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.repaint(); // Refresh frame to reflect changes
        timer.start(); // Restart the game timer
    }

    public void startTimer() {
        final Action doOneStep = new AbstractAction()
        {
            @Override public void actionPerformed(final ActionEvent e) {
                if (!board.isGameOver) {
                    if (!board.pauseGame) {
                        board.tick();
                    }
                } else if (highscoreComponent != null && highscoreComponent.playAgain) {
                    startGame();
                } else if (!gameOverScreenActive) {
                    gameOverScreen();
                } if (board.getScore() % 1000 == 0 && board.getScore() != 0) { // increase speed every thousand points
                    if (timerDelay >= 250) {
                        timerDelay -= 100;
                        timer.setDelay(timerDelay);
                    }
                }
                timerCounter += timerDelay;
            }
        };
        timer = new Timer(timerDelay, doOneStep);
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