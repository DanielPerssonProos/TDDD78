package se.liu.ida.danpr535.tddd78.lab4;

/**
 * Created by Daniel on 15-02-11.
 */
public class Poly {
    private SquareType[][] squares;
    private int size;
    private SquareType polyType;

    public Poly(SquareType[][] squares, SquareType polyType) {
        this.squares = squares;
        this.size = squares.length;
        this.polyType = polyType;
    }


    public SquareType getSquareType(int row, int col) {
        return squares[row][col];
    }

    public int getSize() {
        return size;
    }


    public Poly rotateRight() {
        SquareType[][] rotatedSquares = new SquareType[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                rotatedSquares[col][size - 1 - row] = squares[row][col];
            }
        }
        return new Poly(rotatedSquares, polyType);
    }
}