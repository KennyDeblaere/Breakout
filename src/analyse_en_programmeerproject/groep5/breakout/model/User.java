package analyse_en_programmeerproject.groep5.breakout.model;

import java.util.Date;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class User {
    private String username, firstname, lastname, password, email;
    private int xp;
    private Date dateOfBirth;
    private boolean man;

    public User(String username, String password, String firstname, String lastname, String email, int xp, Date dateOfBirth, boolean man){
        setUsername(username);
        setPassword(password);
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setXp(xp);
        setDateOfBirth(dateOfBirth);
        setMan(man);
    }


    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setMan(boolean man) {
        this.man = man;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }

    public boolean isMan() {
        return man;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public String getEmail() {
        return email;
    }
    public String getFirstname() {
        return firstname;
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
    public int getXp() {
        return xp;
    }

}
