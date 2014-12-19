package be.howest.groep5.breakout.A_test;

import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import be.howest.groep5.breakout.view.welcome.*;
import static org.junit.Assert.*;

/**
 * Created by Blackhat on 19/12/2014.
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
}
