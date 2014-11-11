package analyse_en_programmeerproject.groep5.breakout.model;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class Power {
    public String function;

    public Power(String function){
        setFunction(function);
    }

    public void setFunction(String function) {
        this.function = function;
    }
    public String getFunction() {
        return function;
    }
}
