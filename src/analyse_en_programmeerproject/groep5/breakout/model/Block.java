package analyse_en_programmeerproject.groep5.breakout.model;

import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class Block {
    private Color color;
    private int horizontalLength, verticalLength, numberOfHitsBeforeVanish, powerid;

    public Block(Color color, int horizontalLength, int verticalLength, int numberOfHitsBeforeVanish, int powerid){
        setColor(color);
        setHorizontalLength(horizontalLength);
        setVerticalLength(verticalLength);
        setNumberOfHitsBeforeVanish(numberOfHitsBeforeVanish);
        setPowerid(powerid);
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void setHorizontalLength(int horizontalLength) {
        this.horizontalLength = horizontalLength;
    }
    public void setNumberOfHitsBeforeVanish(int numberOfHitsBeforeVanish) {
        this.numberOfHitsBeforeVanish = numberOfHitsBeforeVanish;
    }
    public void setPowerid(int powerid) {
        this.powerid = powerid;
    }
    public void setVerticalLength(int verticalLength) {
        this.verticalLength = verticalLength;
    }

    public Color getColor() {
        return color;
    }
    public int getHorizontalLength() {
        return horizontalLength;
    }
    public int getNumberOfHitsBeforeVanish() {
        return numberOfHitsBeforeVanish;
    }
    public int getPowerid() {
        return powerid;
    }
    public int getVerticalLength() {
        return verticalLength;
    }
}
