package analyse_en_programmeerproject.groep5.breakout.model;

import java.util.Date;

/**
 * Created by Kenny Deblaere.
 */
public class Score {
    private int score, gamemodeid;
    private Date date;

    public Score(int score, Date date, int gamemodeid)
    {
       setScore(score);
       setDate(date);
        setGamemodeid(gamemodeid);
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setGamemodeid(int gamemodeid) {
        this.gamemodeid = gamemodeid;
    }

    public int getScore() {
        return score;
    }
    public Date getDate() {
        return date;
    }
    public int getGamemodeid() {
        return gamemodeid;
    }
}
