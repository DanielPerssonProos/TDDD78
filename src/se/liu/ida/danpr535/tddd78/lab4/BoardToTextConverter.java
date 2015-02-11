package se.liu.ida.danpr535.tddd78.lab4;

/**
 * Created by Daniel on 15-02-11.
 */
public class BoardToTextConverter {

    public static String convertToText(Board board){

        int height = board.getHeight();
        int width = board.getWidth();
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                switch (board.getSquareType(row,col)){
                    case OUTSIDE:
                        builder.append("#");
                        break;
                    case EMPTY:
                        builder.append("-");
                        break;
                    case I:
                        builder.append("I");
                        break;
                    case J:
                        builder.append("J");
                        break;
                    case L:
                        builder.append("L");
                        break;
                    case O:
                        builder.append("O");
                        break;
                    case S:
                        builder.append("S");
                        break;
                    case T:
                        builder.append("T");
                        break;
                    case Z:
                        builder.append("Z");
                        break;
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
