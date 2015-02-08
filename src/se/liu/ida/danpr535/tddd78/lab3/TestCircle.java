package se.liu.ida.danpr535.tddd78.lab3;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Daniel on 15-02-06.
 */
public class TestCircle {
    public static void main(String[] args) {
        final ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(5,5,5,new Color(0,255,0)));
        circles.add(new Circle(7,7,7,new Color(231, 255, 34)));
        for (Circle circle : circles) {
            System.out.println("X: " + Integer.toString(circle.getX()) + ", Y: " + Integer.toString(circle.getY()));
        }
    }
}
