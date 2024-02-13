package se.liu.noalj314.tetris;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Highscore> {
    @Override
    public int compare(Highscore o1, Highscore o2) {
        // Anta att högre poäng ska komma först
        return Integer.compare(o2.getScore(), o1.getScore());
    }
}
