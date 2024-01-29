package se.liu.noalj314.shapes;

import java.awt.*;

public class Text extends AbstractShape
{
    private int size;
    private String text;

    public Text(final int x, final int y, final int size, final String text, final Color color) {
	super(x, y, color);
	this.size = size;
	this.text = text;
    }

    @Override public String toString() {
	return "Text{" + "x=" + x + ", y=" + y + ", size=" + size + ", text='" + text + '\'' + ", color=" + color + '}';
    }

    @Override public void draw(final Graphics g) {
	g.setColor(color);
	g.setFont(new Font("serif", Font.PLAIN, size));
	g.drawString(text, x, y);
    }
}
