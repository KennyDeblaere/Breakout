package analyse_en_programmeerproject.groep5.breakout.data;

import analyse_en_programmeerproject.groep5.breakout.model.*;

import java.awt.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Kenny Deblaere.
 */
public class Database {
    public static Database DatabaseInstance = new Database();

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }


    private Database(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //String url = "jdbc:mysql://student.howest.be/mysqlstudent/kennydeblaab7yah";
            //connection = DriverManager.getConnection(url, "kennydeblaab7yah", "ce8iaw2IeLax");
            String url = "jdbc:mysql://localhost/breakout";
            connection = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> fillUsers(){
        List<User> users = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = getConnection().createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from user");
            while (rs.next()){
                users.add(new User(rs.getString("username"), rs.getString("password"),
                        rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),
                        rs.getInt("xp"), rs.getDate("dateOfBirth"), rs.getBoolean("sex")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
    public List<Block> fillBlocks(){
        List<Block> blocks = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = getConnection().createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from block");
            while (rs.next()){
                Field field = Class.forName("java.awt.Color").getField(rs.getString("color"));
                blocks.add(new Block((Color)field.get(null),rs.getInt("horizontalLength"), rs.getInt("verticalLength"),
                        rs.getInt("numberOfHitsBeforeVanish"), rs.getInt("powerid")));
            }
        } catch (IllegalAccessException | NoSuchFieldException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return blocks;
    }
    public List<Power> fillPowers(){
        List<Power> powers = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = getConnection().createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from power");
            while (rs.next()){
                powers.add(new Power(rs.getString("function")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return powers;
    }
    public List<Score> fillScores(){
        List<Score> scores = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = getConnection().createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from score");
            while (rs.next()){
                scores.add(new Score(rs.getInt("score"), rs.getDate("date"), rs.getInt("gamemodeid")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return scores;
    }
    public List<ScoreUser> fillScoreUsers(){
        List<ScoreUser> scoreUsers = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = getConnection().createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from score_user");
            while (rs.next()){
                scoreUsers.add(new ScoreUser(rs.getInt("userid"), rs.getInt("scoreid")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return scoreUsers;
    }

    public void insertUser(User user){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String query = "INSERT INTO `user` (`firstname`, `lastname`, `username`, `password`, `dateOfBirth`, `sex`, `email`, `xp`) VALUES" +
                    "(?, ?, ?, ?, ?, ?, ?, 0)";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setDate(5, new Date(user.getDateOfBirth().getTime()));
            preparedStatement.setBoolean(6, user.isMan());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
