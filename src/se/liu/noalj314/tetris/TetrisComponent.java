package se.liu.noalj314.tetris;
import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener
{
    private Board board;
    private final static EnumMap<SquareType, Color> SQUARECOLORS = createColorMap();

    public TetrisComponent(final Board board) {
	this.board = board;
	board.addBoardListener(this);
    }
    @Override
    public Dimension getPreferredSize() {
	return new Dimension(300, 300);
    }

    private static EnumMap<SquareType, Color > createColorMap() {
	EnumMap<SquareType, Color> map = new EnumMap<>(SquareType.class);
	map.put(SquareType.S, Color.GREEN);
	map.put(SquareType.T, Color.PINK);
	map.put(SquareType.O, Color.YELLOW);
	map.put(SquareType.J, Color.BLUE);
	map.put(SquareType.Z, Color.RED);
	map.put(SquareType.L, Color.ORANGE);
	map.put(SquareType.EMPTY, Color.GRAY);
	return map;
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;
	final int squareSize = 30; // storlek på varje ruta
	for (int y = 0; y < board.getHeight(); y++) {
	    for (int x = 0; x < board.getWidth(); x++) {
		SquareType squareType = board.getSquareType(y, x);
		g2d.setColor(SQUARECOLORS.get(squareType));
			g2d.fillRect(x * squareSize, y * squareSize, squareSize, squareSize);
	//	g2d.setColor(Color.LIGHT_GRAY);
		//	g2d.drawRect(x * squareSize, y * squareSize, squareSize, squareSize);
	    }
	}
    }

    @Override public void boardChanged() {
	repaint();
    }
}
