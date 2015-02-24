package se.liu.ida.danpr535.tddd78.lab4;

/**
 * Objects of this class is used to keep track of highscores in a structured way, with fields for the Name and Score.
 */

public class Highscore {
    private String name;
    private int score;

    public Highscore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
