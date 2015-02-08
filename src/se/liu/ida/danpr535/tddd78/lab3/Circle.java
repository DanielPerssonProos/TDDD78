package se.liu.ida.danpr535.tddd78.lab3;

import java.awt.Color;

/**
 * Created by Daniel on 15-02-06.
 */
public class Circle implements Shape {
    private int x;
    private int y;
    private int radius;
    private Color color;

    public Circle(int x, int y, int radius, Color color) {
        if (radius < 0) {
            throw new IllegalArgumentException("Negativ radie!");
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
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

    public int getRadius() {
        return radius;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void draw() {
        System.out.println("Ritar: " + this);
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
