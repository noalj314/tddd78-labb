package se.liu.noalj314.tetris;

import java.awt.*;

public class Fallthrough extends AbstractFallHandler
{


    @Override protected boolean ifCondition(final SquareType fallType, final SquareType boardType) {
	return fallType != SquareType.EMPTY && boardType == SquareType.OUTSIDE;
    }

    @Override public String getDescription() {
	return "Fallthrough";
    }
}
