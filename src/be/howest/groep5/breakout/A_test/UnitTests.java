package be.howest.groep5.breakout.A_test;

import org.junit.Test;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import be.howest.groep5.breakout.model.game.Ball;
import be.howest.groep5.breakout.model.game.BlockCreator;
import be.howest.groep5.breakout.model.game.Paddle;
import be.howest.groep5.breakout.model.game.PowerCreator;
import static org.junit.Assert.*;
/**
 * Created by Dries Dekoninck on 13/11/2014.
 */

public class UnitTests extends Exception{

    //-------------- DATABASE TESTS ----------------------

    @Test
    public void testGetConnection() {
        Connection connection;
        boolean exception = false;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/breakout";
            connection = DriverManager.getConnection(url, "root", "");
        }catch(Exception e){
            exception = true;
        }
        if(exception) {
            fail("Database connection failed!");
        }
    }

    //-------------- GAME MODEL TESTS --------------------
    @Test
    public void testBall() {
        boolean exception = false;
        try {
            Ball b = new Ball(true, 3,100);
        } catch (Exception e){
            exception = true;
        }
        if(exception) {
            fail("Ball Class failed!");
        }
    }

    @Test
    public void testBlockCreator() {
        boolean exception = false;
        try {
            BlockCreator block = new BlockCreator(5, 5, 3, Color.RED, true, false, 100, 20, 20);
        } catch (Exception e){
            exception = true;
        }
        if(exception) {
            fail("BlockCreator Class failed!");
        }
    }

    @Test
    public void testPaddle() {
        boolean exception = false;
        try {
            Paddle p = new Paddle(500, 10, 100,1);
        } catch (Exception e){
            exception = true;
        }
        if(exception) {
            fail("Paddle Class failed!");
        }
    }

    @Test
    public void testPowerCreator() {
        Ball b = new Ball(true, 0,100);
        Paddle p = new Paddle(500, 10, 100,1);
        boolean exception = false;
        try {
            PowerCreator power = new PowerCreator(1, true, b, p, 100,100);
        } catch (Exception e){
            exception = true;
        }
        if(exception) {
            fail("PowerCreator Class failed!");
        }
    }

    //-------------- MODEL TESTS -------------------------
    @Test
    public void testBlock() {
        boolean exception = false;
        try {

        } catch (Exception e){
            exception = true;
        }
        if(exception) {
            fail("Block Class failed!");
        }
    }
}
