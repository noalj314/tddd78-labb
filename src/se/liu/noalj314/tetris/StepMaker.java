package se.liu.noalj314.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StepMaker extends AbstractAction {
    private Board board;

    public StepMaker(Board board) {
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Penis");
        board.tick();  // funkar
    }
}
