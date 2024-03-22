package se.liu.noalj314.tetris;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class StartImage extends JComponent
{
    private URL url = ClassLoader.getSystemResource("images/gc.jpeg");
    private final ImageIcon img = new ImageIcon(url);

    public void paintComponent(final Graphics g){
	final Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(	RenderingHints.KEY_ANTIALIASING,
				     RenderingHints.VALUE_ANTIALIAS_ON);
	img.paintIcon(this, g, 0 ,0);
    }
}

