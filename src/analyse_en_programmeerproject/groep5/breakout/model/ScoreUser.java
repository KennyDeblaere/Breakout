package analyse_en_programmeerproject.groep5.breakout.model;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class ScoreUser {
    private int scoreid, userid;

    public ScoreUser(int scoreid, int userid){
        setScoreid(scoreid);
        setUserid(getUserid());
    }

    public void setScoreid(int scoreid) {
        this.scoreid = scoreid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }
    public int getScoreid() {
        return scoreid;
    }
}
