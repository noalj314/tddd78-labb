package se.liu.noalj314.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;;

public class HighscoreComponent extends JComponent implements BoardListener
{
    private HighscoreList highscores;
    private Board board;
    public boolean playAgain = false;

    public HighscoreComponent(HighscoreList highscores, Board board) {
	this.highscores = highscores;
	this.board = board;
	board.addBoardListener(this);
	this.setFocusable(true);
	this.requestFocusInWindow();

	InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	ActionMap actionMap = this.getActionMap();

	inputMap.put(KeyStroke.getKeyStroke("SPACE"), "space");
	actionMap.put("space", new AbstractAction() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		boolean playAgain = true;
	    }
	});

    }

    @Override protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;
	for (int i = 0;  i < 10; i++) {
	    try {
		g.drawString(highscores.getHighscore(i), 1+i*10, 1+i*10);
	    } catch(RuntimeException ignored) {
	    }
	}
    }
    @Override public void boardChanged() {
	repaint();
    }
}
