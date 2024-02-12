package se.liu.noalj314.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HighscoreList
{
    private List<Highscore> highscores;;

    public HighscoreList() {
	this.highscores = new ArrayList<>();
    }
    public void addHighscore(Highscore highscore){
	highscores.add(highscore);
    }
    public String getAllHighscores(){
	StringBuilder sb = new StringBuilder();
	for (Highscore highscore : highscores) {
	    sb.append(highscore.toString());
	}
	return sb.toString();
    }
    public String getHighscore(int index){
	return highscores.get(index).toString();
    }
}
