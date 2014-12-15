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

public class UnitTests {

    //-------------- DATABASE TESTS ----------------------

    @Test
    public void testGetConnection() throws Exception {
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
    public void testBall() throws Exception {
        boolean exception = false;
        try {
            Ball b = new Ball(true, 0, 3);
        } catch (Exception e){
            exception = true;
        }
        if(exception) {
            fail("Ball Class failed!");
        }
    }

    @Test
    public void testBlockCreator() throws Exception {
        boolean exception = false;
        try {
            BlockCreator block = new BlockCreator(5, 5, 3, Color.RED, true, 100, 20, 20);
        } catch (Exception e){
            exception = true;
        }
        if(exception) {
            fail("BlockCreator Class failed!");
        }
    }

    @Test
    public void testPaddle() throws Exception {
        boolean exception = false;
        try {
            Paddle p = new Paddle(500, 10, 1);
        } catch (Exception e){
            exception = true;
        }
        if(exception) {
            fail("Paddle Class failed!");
        }
    }

    @Test
    public void testPowerCreator() throws Exception {
        Ball b = new Ball(true, 0, 3);
        Paddle p = new Paddle(500, 10, 1);
        boolean exception = false;
        try {
            PowerCreator power = new PowerCreator(1, true, b, p);
        } catch (Exception e){
            exception = true;
        }
        if(exception) {
            fail("PowerCreator Class failed!");
        }
    }

    //-------------- MODEL TESTS -------------------------
    @Test
    public void testBlock() throws Exception {
        boolean exception = false;
        try {

        } catch (Exception e){
            exception = true;
        }
        if(exception) {
            fail("Block Class failed!");
        }
    } // TODO tests van model
}
