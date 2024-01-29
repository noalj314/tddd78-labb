package se.liu.noalj314.shapes;

import java.util.ArrayList;
import java.util.List;

public class CircleTest
{
    public static void main(String[] args) {
	final List<Circle> circles = new ArrayList<>();
	circles.add(new Circle(10, 10, 10, java.awt.Color.RED));
	circles.add(new Circle(20, 20, 20, java.awt.Color.BLUE));
	circles.add(new Circle(30, 30, 30, java.awt.Color.GREEN));
	circles.add(new Circle(40, 40, 40, java.awt.Color.YELLOW));

	for (Circle circle : circles) {
	    System.out.println(circle);
	}
    }
}
