package se.liu.ida.danpr535.tddd78.lab4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Daniel on 15-02-11.
 */
public class Board {
    private SquareType[][] squares;
    private int height;
    private int width;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.squares = new SquareType[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (row == 0 || col == 0 || row == height - 1 || col == width - 1){
                    squares[row][col] = SquareType.OUTSIDE;
                }
                else {
                    squares[row][col] = SquareType.EMPTY;
                }
            }
        }

    }

    public static void main(String[] args) {
        Board test = new Board(5,5);
        System.out.println(test);
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public SquareType getSquareType(int row, int col){
        return squares[row][col];
    }

    public void setSquareType(int row, int col, SquareType squareType){
        squares[row][col] = squareType;
    }

    public static Board generateRandomBoard(int height, int width){
        Board generatedBoard = new Board(height,width);
        SquareType[] SquareTypes = SquareType.values();
        Random random = new Random();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int randomIndex = random.nextInt(SquareTypes.length);
                SquareType randomSquareType = SquareTypes[randomIndex];
                generatedBoard.setSquareType(row, col, randomSquareType);
            }
        }
        return generatedBoard;
    }

}
