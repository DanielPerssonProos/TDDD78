package se.liu.ida.danpr535.tddd78.lab4;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Highscore> {

    public ScoreComparator() {
    }

    public int compare(Highscore o1, Highscore o2) {
            if (o1.getScore() < o2.getScore())
                return 1;
            else if (o1.getScore() == o2.getScore())
                return 0;
            else
                return -1;
        }
}
