package analyse_en_programmeerproject.groep5.breakout.model;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class Power {
    private String function;
    private boolean powerup;


    public Power(String function, boolean powerup){
        setFunction(function);
        setPowerup(powerup);
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setPowerup(boolean powerup) {
        this.powerup = powerup;
    }

    public String getFunction() {
        return function;
    }

    public boolean isPowerup() {
        return powerup;
    }
}
