package be.howest.groep5.breakout.model.observer;

/**
 * Created by Benjamin on 18/12/2014.
 */
public interface ScoreObserver {
    public void update(int p1score, int p2score, int numberOfLifes);
}
