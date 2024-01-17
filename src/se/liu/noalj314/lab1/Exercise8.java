package se.liu.noalj314.lab1;

import javax.swing.*;

public class Exercise8
{
    public static void main(String[] args) {
	while (true){
	    //&& passar bäst för om första är false så vill vi ju inte fårga säker också
	    if (askUser("quit?") && askUser("säker?")) {
		return ;
	    }
	    else {
		System.out.println("The program will the continue");
	    }
	}
    }

    public static boolean askUser(String question) {
	return JOptionPane.showConfirmDialog(null, question, "",
					     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
}
