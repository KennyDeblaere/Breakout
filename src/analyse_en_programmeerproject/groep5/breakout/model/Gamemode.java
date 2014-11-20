package analyse_en_programmeerproject.groep5.breakout.model;

/**
 * Created by
 *      Kenny Deblaere.
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
        this.difficulty = difficulty;
    }

    public boolean isSingleplayer() {
        return singleplayer;
    }
    public int getDifficulty() {
        return difficulty;
    }
}
