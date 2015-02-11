package se.liu.ida.danpr535.tddd78.lab4;

import java.util.Random;

/**
 * Created by Daniel on 15-02-11.
 */
public class BoardTest {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Board board = Board.generateRandomBoard(10, 6);
            String printableBoard = BoardToTextConverter.convertToText(board);
            System.out.println(printableBoard);
        }
    }
}
