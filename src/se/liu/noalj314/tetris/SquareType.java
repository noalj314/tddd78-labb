package se.liu.noalj314.tetris;

import java.util.Random;

public enum SquareType
{
    EMPTY, I, O, T, S, Z, J, L;
    public static void main(String[] args) {
	Random rnd = new Random();
	SquareType[] arraySquares = SquareType.values();
	for (int i = 0; i < 25; i++) {
	    // ta en random integer ur längden av vår array
	    int randomindex = rnd.nextInt(arraySquares.length);
	    //  Skriv sedan ut värdet som fås av det indexet
	    System.out.println(arraySquares[randomindex]);
	}

    }

}
