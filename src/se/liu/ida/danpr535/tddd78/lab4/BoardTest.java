package se.liu.ida.danpr535.tddd78.lab4;



import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Daniel on 15-02-11.
 */
public class BoardTest {
    public static void main(String[] args) {
	TetrisFrame tetroBlox = new TetrisFrame(new Board(12,16));

	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
		    tetroBlox.getGameBoard().tick();
	    }
	};
	final Timer clockTimer = new Timer(1000, doOneStep);
 	clockTimer.setCoalesce(true);
	clockTimer.start();

	/* for (int i = 0; i < 10; i++) {
            Board board = new Board(10, 10);
            String printableBoard = BoardToTextConverter.convertToText(board);
            System.out.println(printableBoard);
        }*/
    }
}
