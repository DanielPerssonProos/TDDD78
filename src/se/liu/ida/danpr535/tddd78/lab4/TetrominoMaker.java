package se.liu.ida.danpr535.tddd78.lab4;

/**
 * Created by Daniel on 15-02-11.
 */
public final class TetrominoMaker {

    private TetrominoMaker() {
    }

    public static int getNumberOfTypes() {
        return 7;
    }

    /**
     * Even if the list squareTypes consists of 9 different SquareTypes,
     getNumberOfTypes() is only set to 7. Since I put the EMPTY and OUTSIDE
     SquareTypes at the very last when I declared them, they will not be
     able to be chosen. This because only a number between 0-6 will be
     generated and used as index.
     * @return how many poly types that exists.
     */
    public static Poly getPoly(int n) {
        /*
         */
        SquareType polyType = SquareType.values()[n];
        switch (polyType){
            case I:
                return getI();
            case J:
                return getJ();
            case L:
                return getL();
            case O:
                return getO();
            case S:
                return getS();
            case T:
                return getT();
            case Z:
                return getZ();
            default:
                //This method is never called on with a value n that extends to the OUTSIDE or EMPTY SquareType.
                //Therefore this case should never be reached.
                throw new RuntimeException("Invalid index");
        }
    }

    private static Poly getI(){
        SquareType[][] blueprint = new SquareType[4][4];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (col == 1){
                    blueprint[row][col] = SquareType.I;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly iPoly = new Poly(blueprint,SquareType.I);
        return iPoly;
    }

    private static Poly getJ(){
        SquareType[][] blueprint = new SquareType[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (col == 1 || (col == 0 && row == 0)){
                    blueprint[row][col] = SquareType.J;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly jPoly = new Poly(blueprint,SquareType.J);
        return jPoly;
    }
    private static Poly getL(){
        SquareType[][] blueprint = new SquareType[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (col == 1 || (col == 0 && row == 2)){
                    blueprint[row][col] = SquareType.L;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly lPoly = new Poly(blueprint,SquareType.L);
        return lPoly;
    }

    private static Poly getO(){
        SquareType[][] blueprint = new SquareType[2][2];

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                blueprint[row][col] = SquareType.O;
            }
        }
        Poly oPoly = new Poly(blueprint,SquareType.O);
        return oPoly;
    }

    private static Poly getS(){
        SquareType[][] blueprint = new SquareType[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if ((col == 0 && row > 0) || (col == 1 && row < 2)){
                    blueprint[row][col] = SquareType.S;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly sPoly = new Poly(blueprint,SquareType.S);
        return sPoly;
    }

    private static Poly getT(){
        SquareType[][] blueprint = new SquareType[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (col == 1 || (col == 0 && row == 1)){
                    blueprint[row][col] = SquareType.T;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly tPoly = new Poly(blueprint,SquareType.T);
        return tPoly;
    }

    private static Poly getZ(){
        SquareType[][] blueprint = new SquareType[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if ((col == 0 && row < 2) || (col == 1 && row > 0)){
                    blueprint[row][col] = SquareType.Z;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly zPoly = new Poly(blueprint,SquareType.Z);
        return zPoly;
    }


}
