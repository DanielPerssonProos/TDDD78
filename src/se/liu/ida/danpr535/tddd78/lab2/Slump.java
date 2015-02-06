package se.liu.ida.danpr535.tddd78.lab2;

import java.util.Random;

/**
 * Created by Daniel on 2015-01-20.
 */
public class Slump {
    public static void main(String[] args) {
        Random rnd = new Random();
        for (int i = 0; i < 25; i++) {
            System.out.println(rnd.nextInt(100));
        }
    }
}
