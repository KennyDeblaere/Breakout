package analyse_en_programmeerproject.groep5.breakout.model;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class ScoreUser {
    private int score;
    private String username;

    public ScoreUser(int score, String username){
        setScore(score);
        setUserName(username);
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void setUserName(String username) {
        this.username = username;
    }

    public String getUserName() {
        return username;
    }
    public int getScore() {
        return score;
    }
}
