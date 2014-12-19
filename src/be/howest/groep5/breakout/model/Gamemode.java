package be.howest.groep5.breakout.model;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class Gamemode {
    private int difficulty;
    private boolean singleplayer;

    public Gamemode(boolean singleplayer, int difficulty){
        setDifficulty(difficulty);
        setSingleplayer(singleplayer);
    }

    public void setSingleplayer(boolean singleplayer) {
        this.singleplayer = singleplayer;
    }
    public void setDifficulty(int difficulty) {
        if(difficulty >= 0 && difficulty <= 2)
            this.difficulty = difficulty;
        else
            this.difficulty = 0;
    }

    public boolean isSingleplayer() {
        return singleplayer;
    }
    public int getDifficulty() {
        return difficulty;
    }
}
