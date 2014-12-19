package be.howest.groep5.breakout.model;

import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.controller.registration.RegisterController;

import javax.swing.*;
import java.util.Date;


/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class Register {
    private String username, firstname, lastname, password, email;
    private Date dateOfBirth;
    private boolean man;

    public Register(String username, String password, String repeatedPassword, String firstname, String lastname, String email, Date dateOfBirth, boolean man){
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.man = man;

        register();
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setMan(boolean man) {
        this.man = man;
    }

    public String getEmail() {
        return email;
    }
    public String getFirstname() {
        return firstname;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public String getLastname() {
        return lastname;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public boolean isMan() {
        return man;
    }




    public void register(){

        Database.DatabaseInstance.insertUser(new User(getUsername(), getPassword(), getFirstname(), getLastname(), getEmail(), 0, getDateOfBirth(), isMan()));
        System.out.println(isMan());
    }
}
