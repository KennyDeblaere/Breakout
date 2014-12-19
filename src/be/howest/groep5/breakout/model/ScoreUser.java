package be.howest.groep5.breakout.model;

/**
 * Created by
 *      Kenny Deblaere
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
        if(score > 0)
            this.score = score;
        else
            this.score = 0;
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
