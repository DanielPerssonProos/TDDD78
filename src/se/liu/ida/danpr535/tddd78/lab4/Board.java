package se.liu.ida.danpr535.tddd78.lab4;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Daniel on 15-02-11.
 */
public class Board {
    private SquareType[][] squares;
    private int height;
    private int width;
    private Poly falling;
    private int fallingPosX;
    private int fallingPosY;
    private ArrayList<BoardListener> listeners;

    public Board(int width, int height) {
        this.height = height;
        this.width = width;
        this.squares = new SquareType[width][height];
        this.falling = TetrominoMaker.getPoly(new Random().nextInt(TetrominoMaker.getNumberOfTypes()));
        this.fallingPosX = (width - falling.getSize())/2;
        this.fallingPosY = 0;
        this.listeners = new ArrayList<>();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col == 0 || row == height - 1 || col == width - 1){
                    squares[col][row] = SquareType.OUTSIDE;
                }
                else {
                    squares[col][row] = SquareType.EMPTY;
                }
            }
        }

    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public SquareType getSquareType(int col, int row){
        return squares[col][row];
    }

    public void setSquareType(int col, int row, SquareType squareType){
        squares[col][row] = squareType;
        notifyListeners();
    }

    public void randomizeBoard(){
        SquareType[] squareTypes = SquareType.values();

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int randomIndex = new Random().nextInt(squareTypes.length);
                SquareType randomSquareType = squareTypes[randomIndex];
                setSquareType(col, row, randomSquareType);
            }
        }
        notifyListeners();
    }

    public Poly getFalling() {
        return falling;
    }

    public void setFalling(Poly falling) {
        this.falling = falling;
    }

    public int getFallingPosX() {
        return fallingPosX;
    }

    public int getFallingPosY() {
        return fallingPosY;
    }

    public void addBoardListener(BoardListener bl){
        listeners.add(bl);
    }

    private void notifyListeners(){
        for (BoardListener listener : listeners) {
            listener.boardChanged();
        }
    }

    public void tick(){
        if(fallingPosY + falling.getSize() >= height || collisionConfirmed()){
            putBlockInBoard();
            falling = null;
            falling = TetrominoMaker.getPoly(new Random().nextInt(TetrominoMaker.getNumberOfTypes()));
            fallingPosY = 0;
        } else{
            fallingPosY += 1;
        }

        notifyListeners();
    }

    private boolean collisionConfirmed(){
        boolean collision = false;
        for (int col = 0; col < falling.getSize(); col++) {
            for (int row = 0; row < falling.getSize(); row++) {
                boolean blockNotEmpty = falling.getSquareType(col,row) != SquareType.EMPTY;
                boolean blockUnderneath = squares[fallingPosX + col][fallingPosY + row + 1] != SquareType.EMPTY;
                if (blockNotEmpty && blockUnderneath){
                    collision = true;
                }
            }
        }
        return collision;
    }

    private void putBlockInBoard(){
        for (int col = 0; col < falling.getSize(); col++) {
            for (int row = 0; row < falling.getSize(); row++) {
                boolean blockNotEmpty = falling.getSquareType(col,row) != SquareType.EMPTY;
                SquareType polyBlock = falling.getSquareType(col,row);
                if (blockNotEmpty){
                    squares[fallingPosX + col][fallingPosY + row] = polyBlock;
                }
            }
        }
    }

    private boolean gameOver(){
        boolean checkGameOver = false;
        for (int col = 0; col < falling.getSize(); col++) {
            for (int row = 0; row < falling.getSize(); row++) {
                boolean blockNotEmpty = falling.getSquareType(col,row) != SquareType.EMPTY;
                boolean boardPositionOccupied = squares[fallingPosX + col][fallingPosY + row] != SquareType.EMPTY;
                if (blockNotEmpty && boardPositionOccupied){
                    checkGameOver = true;
                }
            }
        }
        return checkGameOver;
    }
}

