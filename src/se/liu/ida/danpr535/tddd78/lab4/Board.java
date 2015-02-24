package se.liu.ida.danpr535.tddd78.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class keeps track of the board and everything directly related to it. It keeps track of the falling poly
 * and its position, the score, the listeners and so on. Most of the core game mechanics are also contained here.
 */
public class Board {
    private SquareType[][] squares;
    private int width;
    private int height;
    private Poly falling;
    private int fallingPosX;
    private int fallingPosY;
    private List<BoardListener> listeners;
    private int score;

    public Board(int height, int width) {
        this.width = width;
        this.height = height;
        this.squares = new SquareType[height][width];
        this.falling = TetrominoMaker.getPoly(new Random().nextInt(TetrominoMaker.getNumberOfTypes()));
        this.fallingPosX = (width - falling.getSize())/2;
        this.fallingPosY = 0;
        this.listeners = new ArrayList<>();
        this.score = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col == 0 || row == height - 1 || col == width - 1){
                    squares[row][col] = SquareType.OUTSIDE;
                }
                else {
                    squares[row][col] = SquareType.EMPTY;
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

    public SquareType getSquareType(int row, int col){
        return squares[row][col];
    }

    public void setSquareType(int row, int col, SquareType squareType){
        squares[row][col] = squareType;
    }

    public int getScore() {
        return score;
    }

    public void randomizeBoard(){
        SquareType[] squareTypes = SquareType.values();

        for (int col = 0; col < height; col++) {
            for (int row = 0; row < width; row++) {
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
        fallingPosX = (width - falling.getSize())/2;
        fallingPosY = 0;
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
        //This way of writing this method in much more readable than using a ForEach.
        for (BoardListener listener : listeners) {
            listener.boardChanged();
        }
    }

    public void tick(){
        //This method moves the game forward one "tick".
        if(collisionConfirmed("Down")){
            putBlockInBoard();
            setFalling(TetrominoMaker.getPoly(new Random().nextInt(TetrominoMaker.getNumberOfTypes())));
            removeFullRows();
        } else
            fallingPosY += 1;
        notifyListeners();
    }

    private boolean collisionConfirmed(String direction){
        // This method checks if there is a block in the way in the direction given.
        boolean collision = false;
        int colAdjustment;
        int rowAdjustment;
        switch (direction){
            case "Down":
                colAdjustment = 0;
                rowAdjustment = 1;
                break;
            case "Left":
                colAdjustment = -1;
                rowAdjustment = 0;
                break;
            case "Right":
                colAdjustment = 1;
                rowAdjustment = 0;
                break;
            default:
                colAdjustment = 0;
                rowAdjustment = 0;

        }
        for (int row = 0; row < falling.getSize(); row++) {
            for (int col = 0; col < falling.getSize(); col++) {
                boolean blockNotEmpty = falling.getSquareType(row,col) != SquareType.EMPTY;
                if (fallingPosX + col + colAdjustment < width) {
                    if (blockNotEmpty) {
                        boolean blockInTheWay = getSquareType(fallingPosY + row + rowAdjustment,
                                fallingPosX + col + colAdjustment) != SquareType.EMPTY;
                        //blockNotEmpty is not always true. That completely depends on which index in the polys squares
                        //field that is called upon.
                        if (blockNotEmpty && blockInTheWay)
                            collision = true;
                    }
                }
            }
        }
        return collision;
    }

    private void putBlockInBoard(){
        for (int row = 0; row < falling.getSize(); row++) {
            for (int col = 0; col < falling.getSize(); col++) {
                boolean polyBlockNotEmpty = falling.getSquareType(row,col) != SquareType.EMPTY;
                SquareType polyBlock = falling.getSquareType(row,col);
                if (polyBlockNotEmpty){
                    setSquareType(fallingPosY + row,fallingPosX + col, polyBlock);
                }
            }
        }
    }

    public boolean checkGameOver(){
        //This method checks if the new poly can be painted on the board. If not, the game is over.
        boolean gameOver = false;
        for (int row = 0; row < falling.getSize(); row++) {
            for (int col = 0; col < falling.getSize(); col++) {
                if (fallingPosX + col < width){
                    boolean blockNotEmpty = falling.getSquareType(row,col) != SquareType.EMPTY;
                    boolean boardPositionOccupied = getSquareType(fallingPosY + row, fallingPosX + col)
                            != SquareType.EMPTY;
                    if (blockNotEmpty && boardPositionOccupied){
                        gameOver = true;
                    }
                }
            }
        }
        return gameOver;
    }

    public void movePolyLeft(){
        if (!collisionConfirmed("Left"))
            fallingPosX -= 1;
        notifyListeners();
    }

    public void movePolyRight(){
        if (!collisionConfirmed("Right"))
            fallingPosX += 1;
        notifyListeners();
    }

    private void removeFullRows(){
        /*Checks if there are any full rows and puts the row indicies of the full rows in the rowsToBeRemoved variable.
        The elements in this variable are then sent to the removeRow function, one by one.
        The reason that I did not change the type of the rowsToBeRemoved variable is that the type List is more describing
        of what its purpose is.
         */
        List<Integer> rowsToBeRemoved = new ArrayList<>();
        boolean rowFullSoFar = true;
        for (int row = 0; row < height - 1; row++) {
            for (int col = 1; col < width - 1; col++) {
                if (getSquareType(row,col) != SquareType.EMPTY){
                    rowFullSoFar &= true;
                } else
                    rowFullSoFar = false;
            }
            if (rowFullSoFar){
                rowsToBeRemoved.add(row);
            } else
                rowFullSoFar = true;
        }
        //More readable than ForEach
        for (Integer row : rowsToBeRemoved) {
            removeRow(row);
        }
        updateScore(rowsToBeRemoved.size());
        notifyListeners();
    }

    private void removeRow(int removedRow){
        //For all rows above the one to be removed, the row is copied down to the row below. Deleting the row in the process.
        for (int row = removedRow - 1; row >= 0 ; row--) {
            for (int col = 1; col < width - 1; col++) {
                setSquareType(row + 1, col, getSquareType(row, col));
                if (row == 0){
                    setSquareType(row, col, SquareType.EMPTY);
                }
            }
        }
    }

    public void rotateFalling(){
        falling = falling.rotateRight();
        if (collisionConfirmed("Here")){
            falling = falling.rotateRight().rotateRight().rotateRight();
        }
        notifyListeners();
    }

    public void placeFalling(){
        while (!collisionConfirmed("Down")){
            fallingPosY += 1;
        }
        notifyListeners();
    }

    private void updateScore(int removedRows){
        //Updates the score based on the number of row removed during that tick.
        // The magic ints in this function are the standard Tetris scores for that amount of rows.
        switch (removedRows){
            case 1:
                score += 100;
                break;
            case 2:
                score += 300;
                break;
            case 3:
                score += 500;
                break;
            case 4:
                score += 800;
                break;
            default:
                break;
        }
    }

    public void resetBoard(){
        //Resets the board when the player chooses to play again.
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col == 0 || row == height - 1 || col == width - 1){
                    squares[row][col] = SquareType.OUTSIDE;
                }
                else {
                    squares[row][col] = SquareType.EMPTY;
                }
            }
        }
        score = 0;
        setFalling(TetrominoMaker.getPoly(new Random().nextInt(TetrominoMaker.getNumberOfTypes())));
        fallingPosX = (width - falling.getSize())/2;
        fallingPosY = 0;
    }
}

