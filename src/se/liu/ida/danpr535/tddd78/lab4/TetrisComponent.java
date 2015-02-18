package se.liu.ida.danpr535.tddd78.lab4;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener{
    private Board board;
    private int boardWidth;
    private int boardHeight;
    private EnumMap colorMap;
    private final int blockSize;

    public TetrisComponent(Board board) {
        this.board = board;
        this.boardWidth = board.getWidth();
        this.boardHeight = board.getHeight();
        this.blockSize = 40;
        this.colorMap = new EnumMap<SquareType,java.awt.Color>(SquareType.class);
        colorMap.put(SquareType.I, Color.RED);
        colorMap.put(SquareType.J, Color.YELLOW);
        colorMap.put(SquareType.L, Color.MAGENTA);
        colorMap.put(SquareType.O, Color.ORANGE);
        colorMap.put(SquareType.S, Color.GREEN);
        colorMap.put(SquareType.T, Color.BLUE);
        colorMap.put(SquareType.Z, Color.CYAN);
        colorMap.put(SquareType.EMPTY, Color.GRAY);
        colorMap.put(SquareType.OUTSIDE, Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    final Graphics2D g2d = (Graphics2D) g;
        int polyX = board.getFallingPosX();
        int polyY = board.getFallingPosY();
        int polyWidth = board.getFalling().getSize();
        int polyHeight = board.getFalling().getSize();
        boolean polyInPos;
        boolean polyPosEmpty;
        SquareType paintedSquare;
        Poly fallingPoly = board.getFalling();


        for (int col = 0; col < boardWidth; col++) {
       	    for (int row = 0; row < boardHeight; row++) {
                polyInPos = col >= polyX && col < polyX + polyWidth && row >= polyY && row < polyY + polyHeight;
                paintedSquare = board.getSquareType(col,row);
                if (polyInPos){
                    polyPosEmpty = fallingPoly.getSquareType(col - polyX, row - polyY) == SquareType.EMPTY;
                    if (!polyPosEmpty){
                        paintedSquare = fallingPoly.getSquareType(col - polyX, row - polyY);
                    }
                }
                g2d.setColor((Color) colorMap.get(paintedSquare));
        	    g2d.fillRect(col * blockSize, row * blockSize, blockSize, blockSize);
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.drawRect(col * blockSize, row * blockSize, blockSize, blockSize);
            }
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(boardWidth*blockSize,boardHeight*blockSize);
    }

    @Override
    public void boardChanged() {
        repaint();
    }
}
