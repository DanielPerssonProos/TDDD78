package se.liu.ida.danpr535.tddd78.lab4;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class TetrisFrame extends JFrame {
    private Board gameBoard;
    private TetrisComponent gui;
    private JMenuBar menuBar;

    public TetrisFrame(Board gameBoard)  {
	    super("TetroBlox");
	    this.gameBoard = gameBoard;
        this.menuBar = new JMenuBar();
    	this.gui = new TetrisComponent(gameBoard);

    	gui.setLayout(new BorderLayout());
	    add(gui,BorderLayout.CENTER);
        final JMenu menu = new JMenu("Alternativ");
        JMenuItem quit = new JMenuItem("Avsluta",'Q');
        quit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(quit);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

    	setVisible(true);
	    pack();

        this.gameBoard.addBoardListener(this.gui);
    }

    public Board getGameBoard() {
	return gameBoard;
    }


}
