package se.liu.ida.danpr535.tddd78.lab4;

/**
 * Created by Daniel on 15-02-11.
 */
public class Poly {
    private SquareType[][] appearance;
    private int size;
    private SquareType polyType;

    public Poly(SquareType[][] appearance, SquareType polyType) {
        this.appearance = appearance;
	    this.size = appearance.length;
        this.polyType = polyType;
    }



    public SquareType getSquareType(int x, int y){
        return appearance[x][y];
    }

    public int getSize() {
	return size;
    }
}
