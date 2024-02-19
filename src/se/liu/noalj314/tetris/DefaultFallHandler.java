package se.liu.noalj314.tetris;

import java.awt.*;

public class DefaultFallHandler extends AbstractFallHandler
{

    @Override protected boolean ifCondition(SquareType fallType, SquareType boardType){
	return boardType != SquareType.EMPTY && fallType != SquareType.EMPTY;
    }
    @Override public String getDescription() {
	return "No powerup";
    }
}
