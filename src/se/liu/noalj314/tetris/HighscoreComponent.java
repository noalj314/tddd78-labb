package se.liu.noalj314.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class HighscoreComponent extends JComponent
{
    private HighscoreList highscores;
    private Board board;
    public boolean playAgain = false;
    private static final int SCORE_WIDTH = 300;
    private static final int SCORE_HEIGHT = 400;
    private String listAsJson;

    public HighscoreComponent(HighscoreList highscores, Board board) {
	this.highscores = highscores;


	this.board = board;
	this.setFocusable(true);
	this.requestFocusInWindow();

	InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	ActionMap actionMap = this.getActionMap();

	inputMap.put(KeyStroke.getKeyStroke("SPACE"), "space");
	actionMap.put("space", new AbstractAction() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("space pressed");
		HighscoreComponent.this.playAgain = true;
	    }
	});

    }

    @Override protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;
	g.drawString("Press space to start again!", 20, 20);
	int i = 1;
	for (Highscore currentScore: highscores.getHighscoreList()) {
	    System.out.println(currentScore);
	    try {
		g.drawString(currentScore.toString(), 35,35*i);
		i++;
	    } catch (NullPointerException ignored) {
	    }
	}
    }
	@Override public Dimension getPreferredSize() {
	    return new Dimension(SCORE_WIDTH, SCORE_HEIGHT);
	}
    }


