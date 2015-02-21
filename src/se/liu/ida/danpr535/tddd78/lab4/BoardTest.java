package se.liu.ida.danpr535.tddd78.lab4;



import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Daniel on 15-02-11.
 */
public class BoardTest {
    public static void main(String[] args) {
	TetrisFrame tetroBlox = new TetrisFrame(new Board(16,12));

	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
            tetroBlox.getGameBoard().tick();
            if (tetroBlox.getGameBoard().checkGameOver()){
                tetroBlox.showGameOverMessage();
            }

        }
	};
	Timer clockTimer = new Timer(750, doOneStep);
 	clockTimer.setCoalesce(true);
	clockTimer.start();

	/* for (int i = 0; i < 10; i++) {
            Board board = new Board(10, 10);
            String printableBoard = BoardToTextConverter.convertToText(board);
            System.out.println(printableBoard);
        }*/
    }
}
