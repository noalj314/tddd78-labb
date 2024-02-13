package se.liu.noalj314.tetris;

public class Highscore
{
    private int score;
    private String name;
    public Highscore(String name, int score) {
	this.score = score;
	this.name = name;
    }

    public int getScore() {
	return score;
    }

    @Override public String toString() {
	return  name + ": '" + score;
    }
}
