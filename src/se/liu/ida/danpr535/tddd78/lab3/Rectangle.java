package se.liu.ida.danpr535.tddd78.lab3;

import java.awt.*;

/**
 * Created by Daniel on 15-02-06.
 */
public class Rectangle extends AbstractShape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(y, x, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        //System.out.println("Ritar: " + this);
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", color=" + color +
                '}';
    }
}
