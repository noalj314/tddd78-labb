package se.liu.noalj314.shapes;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;
import java.awt.Graphics;

public class DiagramViewer extends JComponent
{
    private final static List<Color> COLORS =
	    List.of(Color.BLACK, Color.RED, Color.GREEN, Color.BLUE,
		    Color.CYAN, Color.YELLOW, Color.MAGENTA);
    
    private final static Random RND = new Random(0);

    private static Color getRandomColor() {
	return COLORS.get(RND.nextInt(COLORS.size()));
    }

    private static Circle getRandomCircle() {
	return new Circle(RND.nextInt(400), RND.nextInt(400),
			  RND.nextInt(200), getRandomColor());
    }

    private static Rectangle getRandomRectangle() {
	return new Rectangle(RND.nextInt(400), RND.nextInt(400),
			     RND.nextInt(200), RND.nextInt(200),
			     getRandomColor());
    }

    private static Text getRandomText() {
	return new Text(RND.nextInt(400), RND.nextInt(400),
			10, "Hello", getRandomColor());
    }

    public static void main(String[] args) {

	DiagramComponent comp = new DiagramComponent();

	final Random RND = new Random(0);

	for (int i = 0; i < 10; i++) {
	    switch (RND.nextInt(3)) {
		case 0:
		    comp.addShape(getRandomCircle());
		    break;
		case 1:
		    comp.addShape(getRandomRectangle());
		    break;
		case 2:
		    comp.addShape(getRandomText());
		    break;
	    }
	}

	JFrame frame = new JFrame("Mitt fönster");
	frame.setLayout(new BorderLayout());
	frame.add(comp, BorderLayout.CENTER);
	frame.setSize(800, 600);
	frame.setVisible(true);

    }

}
