package se.liu.noalj314.tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener
{
    private Board board;
    public static final int SQUARESIZE = 30;
    private final static EnumMap<SquareType, Color> SQUARECOLORS = createColorMap();

    public TetrisComponent(final Board board) {
	this.board = board;
	board.addBoardListener(this);

	final InputMap in = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
	in.put(KeyStroke.getKeyStroke("DOWN"), "rotateLeft");
	in.put(KeyStroke.getKeyStroke("UP"), "rotateRight");
	in.put(KeyStroke.getKeyStroke("SPACE"), "space");


	final ActionMap am = this.getActionMap();
	am.put("moveLeft", new MoveAction(Direction.LEFT));
	am.put("moveRight", new MoveAction(Direction.RIGHT));
	am.put("rotateLeft", new RotateAction(Direction.LEFT));
	am.put("rotateRight", new RotateAction(Direction.RIGHT));
	am.put("space", new AbstractAction() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (!board.pauseGame) {
		    board.pauseGame = true;
		} else{
		    board.pauseGame = false;
		}
	    }
	});
    }
    @Override
    public Dimension getPreferredSize() {
	return new Dimension(board.getWidth()*SQUARESIZE,
				  board.getHeight()*SQUARESIZE);
    }

    private static EnumMap<SquareType, Color > createColorMap() {
	EnumMap<SquareType, Color> map = new EnumMap<>(SquareType.class);
	map.put(SquareType.S, Color.GREEN);
	map.put(SquareType.T, Color.MAGENTA);
	map.put(SquareType.O, Color.YELLOW);
	map.put(SquareType.J, Color.BLUE);
	map.put(SquareType.Z, Color.RED);
	map.put(SquareType.L, Color.ORANGE);
	map.put(SquareType.I, Color.CYAN);
	map.put(SquareType.EMPTY, Color.GRAY);
	map.put(SquareType.TEST, Color.BLACK);
	return map;
    }

    @Override protected void paintComponent( Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;
	for (int y = 0; y < board.getHeight(); y++) {
	    for (int x = 0; x < board.getWidth(); x++) {
		SquareType squareType = board.getVisibleSquareAt(y, x);
		g2d.setColor(SQUARECOLORS.get(squareType));
		g2d.fillRect(x * SQUARESIZE, y * SQUARESIZE, SQUARESIZE, SQUARESIZE);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.drawRect(x * SQUARESIZE,y * SQUARESIZE, SQUARESIZE, SQUARESIZE);
	    }
	}
	g2d.setColor(Color.GREEN);
	g.drawString(String.valueOf(board.getScore()), board.getDblMargin()*2, board.getDblMargin()*3);
	g2d.setColor(Color.BLUE);
	g.drawString(board.getFallHandler().getDescription(), board.getDblMargin()*2, board.getDblMargin()*7);

    }

    @Override public void boardChanged() {
	repaint();
    }
    private class MoveAction extends AbstractAction {
	private final Direction direction;

	private MoveAction(Direction direction) {
	    this.direction = direction;
	}
	@Override public void actionPerformed(ActionEvent e) {
	    if (!board.pauseGame) {
		board.move(direction);
	    }
	}
    }
    private class RotateAction extends AbstractAction {
	private final Direction direction;

	private RotateAction(Direction direction) {
	    this.direction = direction;
	}
	@Override public void actionPerformed(ActionEvent e) {
	    if (!board.pauseGame) {
		board.rotate(direction);
	    }
	}
    }
}



