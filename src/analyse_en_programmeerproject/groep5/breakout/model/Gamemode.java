package analyse_en_programmeerproject.groep5.breakout.model;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class Gamemode {
    public static int EASY = 0, MIDDLE = 1, HARD = 2;
    private boolean singleplayer;

    public Gamemode(boolean singleplayer){
        setSingleplayer(singleplayer);
    }

    public void setSingleplayer(boolean singleplayer) {
        this.singleplayer = singleplayer;
    }
    public boolean isSingleplayer() {
        return singleplayer;
    }
}
