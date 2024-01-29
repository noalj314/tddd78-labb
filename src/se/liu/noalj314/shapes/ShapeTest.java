package se.liu.noalj314.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeTest
{
    public static void main(String[] args) {
	final List<Shape> shapes = new ArrayList<>();
	shapes.add(new Circle(10, 10, 10, java.awt.Color.RED));
	shapes.add(new Circle(20, 20, 20, java.awt.Color.BLUE));
	shapes.add(new Circle(30, 30, 30, java.awt.Color.GREEN));
	shapes.add(new Circle(40, 40, 40, java.awt.Color.YELLOW));
	shapes.add(new Rectangle(10, 10, 10, 10, java.awt.Color.RED));
	shapes.add(new Text(10, 10, 10, "Hello", java.awt.Color.RED));
	//for (Shape shape : shapes) {
	// shape.draw(final Graphics g);
	}
    }

