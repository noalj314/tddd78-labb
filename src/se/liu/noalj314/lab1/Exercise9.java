package se.liu.noalj314.lab1;

import javax.swing.*;

public class Exercise9
{
    public static void main(String[] args) {
	String x = JOptionPane.showInputDialog("Enter a value");
	System.out.println(findRoot(Double.parseDouble(x)));
    }

    public static double findRoot(double x) {
	double guess = x;
	for (int i = 0; i < 11; i++) {
	    guess -= (guess*guess-x) / (2*guess);
	}
	return guess;
    }
}
