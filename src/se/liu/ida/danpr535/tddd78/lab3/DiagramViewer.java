package se.liu.ida.danpr535.tddd78.lab3;

/**
 * Created by Daniel on 15-02-08.
 */
import javax.swing.*;
import java.awt.*;

public class DiagramViewer
{
    public static void main(String[] args) {

        DiagramComponent comp = new DiagramComponent();

        // Add several shapes to the component
        comp.addShape(new Circle(200, 200, 20, Color.GREEN));
        comp.addShape(new Circle(300, 300, 100, new Color(231, 255, 34)));
        comp.addShape(new Rectangle(100, 100, 20, 30, Color.BLUE));
        comp.addShape(new Text(400,300,12, Color.BLACK, "Hej jag heter Daniel"));

        JFrame frame = new JFrame("Mitt fönster");
        frame.setLayout(new BorderLayout());
        frame.add(comp, BorderLayout.CENTER);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
}