package se.liu.ida.danpr535.tddd78.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is used to keep track of the highscores entered on an ordered way. Contains an ordered list of highscores.
 * The singleton approach was used to create this class. This means that only one instance is ever created, and that
 * instance is contained within a field in the class.
 */

public final class HighscoreList {
    private static final HighscoreList INSTANCE = new HighscoreList();
    private static List<Highscore> highscores = new ArrayList<>();

    private HighscoreList() {
    }

    public static HighscoreList getInstance() {
        return INSTANCE;
    }

    public void insertHighscore(Highscore highscore){
        highscores.add(highscore);
        Collections.sort(highscores, new ScoreComparator());
    }
    public List<Highscore> getHighscores(){
        return highscores;
    }
}
