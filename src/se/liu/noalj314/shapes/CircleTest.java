package se.liu.noalj314.shapes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CircleTest
{
    public static void main(String[] args) {
	final List<Circle> circles = new ArrayList<>();
	circles.add(new Circle(10, 10, 10, Color.RED));
	circles.add(new Circle(20, 20, 20, Color.BLUE));
	circles.add(new Circle(30, 30, 30, Color.GREEN));
	circles.add(new Circle(40, 40, 40, Color.YELLOW));

	for (Circle circle : circles) {
	    System.out.println(circle);
	}
    }
}
