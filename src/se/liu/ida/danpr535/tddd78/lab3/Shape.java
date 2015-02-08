package se.liu.ida.danpr535.tddd78.lab3;

import java.awt.*;

/**
 * Created by Daniel on 15-02-08.
 */
public interface Shape {
    int getX();

    int getY();

    Color getColor();

    public void draw(Graphics g);

}
