package se.liu.noalj314.tetris;

import java.awt.*;

public interface FallHandler
{
    public boolean hasCollision(Board board, Point fallingPos);
    public String getDescription();
}
