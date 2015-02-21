package se.liu.ida.danpr535.tddd78.lab4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighscoreList {
    private static final HighscoreList INSTANCE = new HighscoreList();
    private static ArrayList<Highscore> highscores = new ArrayList<>();

    private HighscoreList() {
    }

    public static HighscoreList getInstance() {
        return INSTANCE;
    }

    public void insertHighscore(Highscore highscore){
        highscores.add(highscore);
        Collections.sort(highscores, new ScoreComparator());
    }
    public List getHighscores(){
        return highscores;
    }
}
