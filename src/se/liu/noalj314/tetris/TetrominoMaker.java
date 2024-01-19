package se.liu.noalj314.tetris;

public class TetrominoMaker
{
    public int getNumberOfTypes() {
	return SquareType.values().length - 1; // Eftersom vi inte räknar med empty
    }
    public Poly getPoly(int n) {
	SquareType[][] polySquare;
	switch(n) {
	    case 0: // I, lång pinne
		polySquare = getI();
		break;
	    case 1: // O, kvadraten
		polySquare = getO();
		break;
	    case 2: // T,
		polySquare = getT();
		break;
	    case 3: // S,
		polySquare = getS();
		break;
	    case 4: // Z,
		polySquare = getZ();
		break;
	    case 5: // J,
		polySquare = getJ();
		break;
	    case 6: // L,
		polySquare = getL();
		break;
	    default:
		throw new IllegalArgumentException("Invalid index: " + n);
	}
	return polySquare;
    }
    public SquareType[][] getI(){
	return new SquareType[][] {
		{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
		{SquareType.I, SquareType.I, SquareType.I, SquareType.I},
		{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
		{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
	};
    }
    public SquareType[][] getO(){
	return new SquareType[][] {
		{SquareType.O, SquareType.O, SquareType.O, SquareType.O},
		{SquareType.O, SquareType.O, SquareType.O, SquareType.O}
	};
    }
    public SquareType[][] getT(){
     	return new SquareType[][] {
		{SquareType.EMPTY, SquareType.T, SquareType.EMPTY},
		{SquareType.T, SquareType.T, SquareType.T},
		{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
   	 };
    }
    public SquareType[][] getS() {
	return new SquareType[][] {
		{SquareType.EMPTY, SquareType.S, SquareType.S},
		{SquareType.S, SquareType.S, SquareType.EMPTY},
		{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
	};
    }
    public SquareType[][] getZ() {
	return new SquareType[][] {
		{SquareType.Z, SquareType.Z, SquareType.EMPTY},
		{SquareType.EMPTY, SquareType.Z, SquareType.Z},
		{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
	};
    }
    public SquareType[][] getJ() {
	return new SquareType[][] {
		{SquareType.J, SquareType.EMPTY, SquareType.EMPTY},
		{SquareType.J, SquareType.J, SquareType.J},
		{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
	};
    }
    public SquareType[][] getL() {
	return new SquareType[][] {
		{SquareType.EMPTY, SquareType.EMPTY, SquareType.L},
		{SquareType.L, SquareType.L, SquareType.L},
		{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
	};
    }
}
