package se.liu.noalj314.tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TetrisViewer
{
    private JFrame jFrame;
    private Board board;
    private HighscoreList highscoreList = new HighscoreList();
    private Timer timer = null;
    private TetrisComponent tetrisComponent;
    private HighscoreComponent highscoreComponent = null;
    private boolean gameOverScreenActive;
    private int timerDelay = 500;
    private int timerCounter = 0;

    public TetrisViewer(Board board) {
        this.jFrame = new JFrame();
        this.showStartImage();
        createMenu();
        this.board = board;
        this.tetrisComponent = new TetrisComponent(board);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrame.setLayout(new BorderLayout());
        this.jFrame.add(tetrisComponent, BorderLayout.CENTER);
        this.jFrame.pack();
        this.jFrame.setVisible(true);
        startTimer();
    }
    public void showGameOverScreen(){
        highscoreList.addHighscore(new Highscore(JOptionPane.showInputDialog("Enter name!"), board.getScore()));
        if (highscoreComponent != null) {
            this.jFrame.remove(highscoreComponent);
        }
        this.highscoreComponent = new HighscoreComponent(highscoreList, board);

        this.jFrame.remove(tetrisComponent);
        this.jFrame.add(highscoreComponent,  BorderLayout.CENTER);
        this.jFrame.pack();
        this.jFrame.setVisible(true);
        this.jFrame.repaint();
        this.jFrame.validate();
        gameOverScreenActive = true;
    }

    public void startGame(){
        // Check if highscoreComponent exists and reset or remove it
        gameOverScreenActive = false;
        timerDelay = 500; // reset timerdelay

        if (highscoreComponent != null) {
            this.jFrame.remove(highscoreComponent);
            highscoreComponent = null;
            // Setup highscoreComponent as necessary
        }
        board.clear(); // Reset the board state
        board.isGameOver = false; // Reset game over state
        this.jFrame.add(tetrisComponent, BorderLayout.CENTER);
        this.jFrame.pack();
        this.jFrame.setVisible(true);
        this.jFrame.repaint(); // Refresh frame to reflect changes
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
                    showGameOverScreen();
                } if (board.getPolyCounter() != 0 && board.getPolyCounter() % 10 == 0) { // increase speed every ten polys
                    if (timerDelay > 200) {
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
        this.jFrame.setJMenuBar(bar);
    }
    public void showStartImage() {
        JDialog startDialog = new JDialog(this.jFrame, "Start Image", true);
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

    public JFrame getjFrame() {
        return jFrame;
    }
}