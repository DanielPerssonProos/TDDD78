package se.liu.ida.danpr535.tddd78.lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TetrisFrame extends JFrame implements BoardListener{
    private Board gameBoard;
    private TetrisComponent gui;
    private JMenuBar menuBar;
    private JLabel scoreLabel;

    public TetrisFrame(Board gameBoard)  {
	    super("TetroBlox");
	    this.gameBoard = gameBoard;
        this.menuBar = new JMenuBar();
    	this.gui = new TetrisComponent(gameBoard);
        this.scoreLabel = new JLabel("Score");
    	gui.setLayout(new BorderLayout());
        setup();

        this.gameBoard.addBoardListener(this.gui);
        this.gameBoard.addBoardListener(this);
    }

    public Board getGameBoard() {
	return gameBoard;
    }

    public boolean showGameOverMessage(){
        String name = JOptionPane.showInputDialog(this,"Poäng: " + gameBoard.getScore()+ "\n" + "Skriv in ditt namn",
                "Game Over", JOptionPane.PLAIN_MESSAGE);
        if (name != null)
            HighscoreList.getInstance().insertHighscore(new Highscore(name, gameBoard.getScore()));


        int reply = JOptionPane.showOptionDialog(this , highscoreString(),
                "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null,new String[]{"Spela igen","Avsluta"},"Default");
        if (reply == JOptionPane.NO_OPTION){
            System.exit(0);
        } else if (reply == JOptionPane.YES_OPTION){
            gameBoard.resetBoard();
        }
        return false;
    }

    private String highscoreString(){
        ArrayList<Highscore> highscores = (ArrayList<Highscore>) HighscoreList.getInstance().getHighscores();
        String highscoreString = "";
        int place = 1;
        if (highscores.size() <= 10) {
            for (Highscore highscore : highscores) {
                highscoreString += place + ". " + highscore.getName() + ": " + "\n" + highscore.getScore() + " poäng" + "\n";
                place += 1;
            }
        } else{
            for (int i = 1; i <= 10; i++) {
                highscoreString += place + ". " + highscores.get(i).getName() + ": " +
                        "\n" + highscores.get(i).getScore() + " poäng" + "\n";
            }
        }
        return highscoreString;
    }

    @Override
    public void boardChanged() {
        scoreLabel.setText("Score: " + Integer.toString(gameBoard.getScore()));
    }

    private void setup(){
        add(gui,BorderLayout.CENTER);
        final JMenu menu = new JMenu("Alternativ");
        JMenuItem restart = new JMenuItem("Starta om", 'R');
        JMenuItem quit = new JMenuItem("Avsluta",'Q');
        restart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameBoard.resetBoard();
            }
        });
        quit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reply = JOptionPane.showConfirmDialog(gui, "Vill du verkligen avsluta TetroBlox?",
                           "Avsluta", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        menu.add(restart);
        menu.add(quit);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        scoreLabel.setText("Score: " + Integer.toString(gameBoard.getScore()));
        add(scoreLabel, BorderLayout.NORTH);

       	setVisible(true);
   	    pack();
    }
}
