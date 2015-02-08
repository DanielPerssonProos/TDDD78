package se.liu.ida.danpr535.tddd78.lab3;

import java.awt.*;

/**
 * Created by Daniel on 15-02-06.
 */
public class Circle extends AbstractShape {
    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(y, x, color);
        if (radius < 0) {
            throw new IllegalArgumentException("Negativ radie!");
        }
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw(Graphics g) {
        //System.out.println("Ritar: " + this);
        int width = radius * 2;
        int height = width;
        g.setColor(color);
        g.drawOval(x, y, width, height); // calculated from radius!
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", color=" + color +
                '}';
    }
}
