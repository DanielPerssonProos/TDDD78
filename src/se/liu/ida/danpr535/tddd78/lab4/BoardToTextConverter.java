package se.liu.ida.danpr535.tddd78.lab4;

/**
 * Created by Daniel on 15-02-11.
 */
public final class BoardToTextConverter {
    private BoardToTextConverter(){}

    public static String convertToText(Board board){

        int height = board.getHeight();
        int width = board.getWidth();
        StringBuilder builder = new StringBuilder();
        Poly fallingPoly = board.getFalling();
        int polyX = board.getFallingPosX();
        int polyY = board.getFallingPosY();
        int polyHeight = fallingPoly.getSize();
        int polyWidth = fallingPoly.getSize();

        for (int col = 0; col < width; col++) {
	    for (int row = 0; row < height; row++) {
            boolean polyInPos = col >= polyX && col < polyX + polyWidth && row >= polyY && row < polyY + polyHeight;
            SquareType printedSquare = board.getSquareType(col, row);
            if (polyInPos){
                boolean polyPosEmpty = fallingPoly.getSquareType(col - polyX, row - polyY) == SquareType.EMPTY;
                if (!polyPosEmpty){
                        printedSquare = fallingPoly.getSquareType(col - polyX, row - polyY);
                    }
                }
                switch (printedSquare){
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
