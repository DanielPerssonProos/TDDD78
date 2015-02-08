package se.liu.ida.danpr535.tddd78.lab3;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Daniel on 15-02-06.
 */
public class TestShape {
    public static void main(String[] args) {
        final ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5, 5, 5, Color.GREEN));
        shapes.add(new Circle(7, 7, 7, new Color(231, 255, 34)));
        shapes.add(new Rectangle(10,10,20,30,Color.BLUE));
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
