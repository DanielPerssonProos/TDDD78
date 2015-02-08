package se.liu.ida.danpr535.tddd78.lab3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Daniel on 15-02-08.
 */
public class DiagramComponent extends JComponent {
    private ArrayList<Shape> shapes;

    public DiagramComponent() {
        this.shapes = new ArrayList<Shape>();
    }

    public void addShape(Shape s){
        shapes.add(s);
    }

    public void getShapes() {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    @Override protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        for (Shape shape : shapes) {
            shape.draw(g);
        }
        // Rita upp alla former här!
    }
}
