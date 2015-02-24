package se.liu.ida.danpr535.tddd78.lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.AbstractMap;
import java.util.EnumMap;

/**
 * This class is used to paint the board in the game frame, and also to handle input from the user.
 */

public class TetrisComponent extends JComponent implements BoardListener{
    private Board board;
    private int boardWidth;
    private int boardHeight;
    private AbstractMap<SquareType, Color> colorMap;
    private final int blockSize;

    public TetrisComponent(Board board) {
        this.board = board;
        this.boardWidth = board.getWidth();
        this.boardHeight = board.getHeight();
        this.blockSize = 40;
        this.colorMap = new EnumMap<>(SquareType.class);
        colorMap.put(SquareType.I, Color.RED);
        colorMap.put(SquareType.J, Color.YELLOW);
        colorMap.put(SquareType.L, Color.MAGENTA);
        colorMap.put(SquareType.O, Color.ORANGE);
        colorMap.put(SquareType.S, Color.GREEN);
        colorMap.put(SquareType.T, Color.BLUE);
        colorMap.put(SquareType.Z, Color.CYAN);
        colorMap.put(SquareType.EMPTY, Color.GRAY);
        colorMap.put(SquareType.OUTSIDE, Color.BLACK);

        getInputMap().put(KeyStroke.getKeyStroke("A"), "moveLeft");
        getInputMap().put(KeyStroke.getKeyStroke("D"), "moveRight");
        getInputMap().put(KeyStroke.getKeyStroke("W"), "rotate");
        getInputMap().put(KeyStroke.getKeyStroke("S"), "place");
        getActionMap().put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.movePolyRight();
            }
        });
        getActionMap().put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.movePolyLeft();
            }
        });
        getActionMap().put("rotate", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.rotateFalling();
            }
        });
        getActionMap().put("place", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.placeFalling();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    final Graphics2D g2d = (Graphics2D) g;
        int polyX = board.getFallingPosX();
        int polyY = board.getFallingPosY();
        int polyWidth = board.getFalling().getSize();
        int polyHeight = board.getFalling().getSize();
        Poly fallingPoly = board.getFalling();


        for (int row = 0; row < boardHeight; row++) {
       	    for (int col = 0; col < boardWidth; col++) {
                boolean polyInPos = row >= polyY && col < polyX + polyWidth && col >= polyX && row < polyY + polyHeight;
                SquareType paintedSquare = board.getSquareType(row, col);
                if (polyInPos){
                    boolean polyPosEmpty = fallingPoly.getSquareType(row - polyY, col - polyX) == SquareType.EMPTY;
                    if (!polyPosEmpty){
                        paintedSquare = fallingPoly.getSquareType(row - polyY, col - polyX);
                    }
                }
                g2d.setColor(colorMap.get(paintedSquare));
        	    g2d.fillRect(col * blockSize,row * blockSize, blockSize, blockSize);
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.drawRect(col * blockSize,row * blockSize, blockSize, blockSize);
            }
        }
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(boardWidth*blockSize,boardHeight*blockSize);
    }

    @Override
    public void boardChanged() {
        repaint();
    }
}
