package se.liu.ida.danpr535.tddd78.lab4;

import java.util.Random;

/**
 * Created by Daniel on 15-02-11.
 */
public class TetrominoMaker {

    public TetrominoMaker() {
    }

    public int getNumberOfTypes() {
        return 7;
    }

    public Poly getPoly(int n) {
        SquareType[] squareTypes = SquareType.values();
        //Random random = new Random();
        SquareType polyType = squareTypes[n];
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
                throw new RuntimeException("Invalid index");
        }
    }

    private Poly getI(){
        SquareType[][] blueprint = new SquareType[4][4];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (row == 1){
                    blueprint[row][col] = SquareType.I;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly iPoly = new Poly(blueprint);
        return iPoly;
    }

    private Poly getJ(){
        SquareType[][] blueprint = new SquareType[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (row == 1 || (row == 0 && col == 0)){
                    blueprint[row][col] = SquareType.J;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly jPoly = new Poly(blueprint);
        return jPoly;
    }

    private Poly getL(){
        SquareType[][] blueprint = new SquareType[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (row == 1 || (row == 0 && col == 2)){
                    blueprint[row][col] = SquareType.J;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly jPoly = new Poly(blueprint);
        return jPoly;
    }

    private Poly getO(){
        SquareType[][] blueprint = new SquareType[2][2];

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                blueprint[row][col] = SquareType.O;
            }
        }
        Poly oPoly = new Poly(blueprint);
        return oPoly;
    }

    private Poly getS(){
        SquareType[][] blueprint = new SquareType[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if ((row == 0 && col > 0) || (row == 1 && col < 2)){
                    blueprint[row][col] = SquareType.S;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly sPoly = new Poly(blueprint);
        return sPoly;
    }

    private Poly getT(){
        SquareType[][] blueprint = new SquareType[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (row == 1 || (row == 0 && col == 1)){
                    blueprint[row][col] = SquareType.T;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly tPoly = new Poly(blueprint);
        return tPoly;
    }

    private Poly getZ(){
        SquareType[][] blueprint = new SquareType[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if ((row == 0 && col < 2) || (row == 1 && col > 0)){
                    blueprint[row][col] = SquareType.Z;
                } else blueprint[row][col] = SquareType.EMPTY;
            }
        }
        Poly zPoly = new Poly(blueprint);
        return zPoly;
    }


}
