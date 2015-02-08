package se.liu.ida.danpr535.tddd78.lab3;

import java.awt.*;

/**
 * Created by Daniel on 15-02-08.
 */
public abstract class AbstractShape implements Shape {

    protected int x;
    protected int y;
    protected Color color;

    public AbstractShape(int y, int x, Color color) {
        this.y = y;
        this.x = x;
        this.color = color;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        AbstractShape that = (AbstractShape) other;

        if (x != that.x) return false;
        if (y != that.y) return false;
        if (!color.equals(that.color)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + color.hashCode();
        return result;
    }
}