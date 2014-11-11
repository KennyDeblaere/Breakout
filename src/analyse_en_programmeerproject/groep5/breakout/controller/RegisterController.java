package analyse_en_programmeerproject.groep5.breakout.controller;

import analyse_en_programmeerproject.groep5.breakout.view.registration.DatePanel;
import analyse_en_programmeerproject.groep5.breakout.view.registration.SexPanel;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class RegisterController implements ActionListener {
    private JTextField username, firstname, lastname, email;
    private DatePanel dateOfBirth;
    private SexPanel sex;
    private JPasswordField password, repeatedPassword;

    public RegisterController(JTextField username, JPasswordField password, JPasswordField repeatedPassword, JTextField firstname,
                              JTextField lastname, JTextField email, DatePanel dateOfBirth, SexPanel man){
        setUsername(username);
        setPassword(password);
        setRepeatedPassword(repeatedPassword);
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setDateOfBirth(dateOfBirth);
        }

    public void setUsername(JTextField username) {
        this.username = username;
    }
    public void setFirstname(JTextField firstname) {
        this.firstname = firstname;
    }
    public void setLastname(JTextField lastname) {
        this.lastname = lastname;
    }
    public void setPassword(JPasswordField password) {
        this.password = password;
    }
    public void setEmail(JTextField email) {
        this.email = email;
    }
    public void setDateOfBirth(DatePanel dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setRepeatedPassword(JPasswordField repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
    public void setSex(SexPanel sex) {
        this.sex = sex;
    }
    public JTextField getEmail() {
        return email;
    }
    public JTextField getFirstname() {
        return firstname;
    }

    public JPanel getDateOfBirth() {
        return dateOfBirth;
    }
    public JTextField getLastname() {
        return lastname;
    }
    public JTextField getPassword() {
        return password;
    }
    public JTextField getUsername() {
        return username;
    }
    public JTextField getRepeatedPassword() {
        return repeatedPassword;
    }
    public JPanel getSex() {
        return sex;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //DatabaseInstance.insertUser(new User(getUsername(), getPassword(), getFirstname(), getLastname(), getEmail(), 0, getDateOfBirth(), isMan()));
        //DatabaseInstance.fillUsers();
        //System.out.println(getUsername().getText());

        System.out.println(sex.getMale().isSelected());

        //new Registration(getUsername().getText());
        /*new Register(getUsername().getText(),getPassword().getText(),getRepeatedPassword().getText(),
                getFirstname().getText(),getLastname().getText(),getEmail().getText(), new Date(Integer.parseInt(dateOfBirth.getYear().getText()),
                Integer.parseInt(dateOfBirth.getMonth().getText()), Integer.parseInt(dateOfBirth.getDay().getText())),sex.getMale().isSelected());*/
    }
}
