package se.liu.noalj314.lab1;

import javax.swing.*;

public class Exercise2
{
    public static void main(String[] args) {
	final int min = 10;
	final int max = 20;
	String input = JOptionPane.showInputDialog("Enter for or while to loop");
	switch (input) {
	    case "while":
		System.out.println(sumWhile(min, max));
		break;
	    case "for":
		System.out.println(sumFor(min, max));
		break;
	    default:
		System.out.println("Error");

	}
    }
    public static int sumFor(int min, int max) {
	int summa = 0;
	for (int i = min; i <= max; i++) {
	    summa += i;
	}
	return summa;

    }
    public static int sumWhile(int min, int max) {
	int summa = 0;
	int i = min;
	while (i <= max){
	    summa += i;
	    i ++;
	}
	return summa;

    }
}
