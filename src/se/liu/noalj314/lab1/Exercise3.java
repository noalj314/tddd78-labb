package se.liu.noalj314.lab1;

import javax.swing.*;

public class Exercise3
{
    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Please input a value");
	int max = 12;
	int start = 1;
	int tabell = Integer.parseInt(input);
	while (start <= max){
	    int sum = tabell * start;
	    System.out.println(start + " * "+tabell + " = " + sum);
	    start ++;
	    sum = 0;
	}

    }
}
