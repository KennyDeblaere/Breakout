package be.howest.groep5.breakout.A_test;

import be.howest.groep5.breakout.view.highscores.PanelHighScore;
import be.howest.groep5.breakout.view.welcome.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class UnitTestView extends Exception{

    @Test
    public void testMainPanel() {
        boolean exception = false;
        try{
            MainPanel main = new MainPanel();
        }catch(Exception e){
            exception = true;
        }
        if(exception) {
            fail("MainPanel not found!");
        }
    }
    @Test
    public void testStatusPanel() {
        boolean exception = false;
        try{
            StatusPanel statusPanel = new StatusPanel();
        }catch(Exception e){
            exception = true;
        }
        if(exception) {
            fail("StatusPanel not found!");
        }
    }
    @Test
    public void testImagePanel() {
        boolean exception = false;
        try{
            ImagePanel imagePanel = new ImagePanel("Icon.png");
        }catch(Exception e){
            exception = true;
        }
        if(exception) {
            fail("ImagePanel not found!");
        }
    }
    @Test
    public void testHowToPlayPanel() {
        boolean exception = false;
        try{
            HowToPlayPanel howToPlayPanel = new HowToPlayPanel();
        }catch(Exception e){
            exception = true;
        }
        if(exception) {
            fail("HowToPlayPanel not found!");
        }
    }
    @Test
    public void testAboutPanel() {
        boolean exception = false;
        try{
            AboutPanel aboutPanel = new AboutPanel();
        }catch(Exception e){
            exception = true;
        }
        if(exception) {
            fail("AboutPanel not found!");
        }
    }
    @Test
    public void testPanelHighScore() {
        boolean exception = false;
        try{
            PanelHighScore panelHighScore = new PanelHighScore();
        }catch(Exception e){
            exception = true;
        }
        if(exception) {
            fail("PanelHighScore not found!");
        }
    }
}
