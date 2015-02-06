package se.liu.ida.danpr535.tddd78.lab1;

import javax.swing.*;

/**
 * Created by Daniel on 2015-01-20.
 */
public class Exercise3 {
    //private final static int tabell = 5;

    public static void main(String[] args) {
        String input =
                JOptionPane.showInputDialog("Please input a value");
        int tabellnummer = Integer.parseInt(input);
        for (int i = 1; i < 13; i++) {
            System.out.println(i + " * " + tabellnummer + " = " + i*tabellnummer);
        }
    }
}
