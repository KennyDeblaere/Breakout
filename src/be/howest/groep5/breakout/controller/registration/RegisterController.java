package be.howest.groep5.breakout.controller.registration;

import be.howest.groep5.breakout.model.Register;
import be.howest.groep5.breakout.view.registration.DatePanel;
import be.howest.groep5.breakout.view.registration.SexPanel;
import be.howest.groep5.breakout.view.welcome.ContentPanel;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class RegisterController implements ActionListener {
    private ContentPanel c;
    private JTextField username, firstname, lastname, email;
    private DatePanel dateOfBirth;
    private SexPanel sex;
    private JPasswordField password, repeatedPassword;

    public RegisterController(ContentPanel centerPanel){
        c = centerPanel;
        }

    private void createComponents(){
        setValues(c.getRegistration().getUsername(),
                  c.getRegistration().getPassword(),
                  c.getRegistration().getRepeatedpassword(),
                  c.getRegistration().getFirstname(),
                  c.getRegistration().getLastname(),
                  c.getRegistration().getEmail(),
                  c.getRegistration().getDateOfBirth(),
                  c.getRegistration().getSexPanel());
    }

    public void setValues(JTextField username, JPasswordField password, JPasswordField repeatedPassword, JTextField firstname, JTextField lastname, JTextField email, DatePanel dateOfBirth, SexPanel sex){
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }


    private void message(String message){

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
        createComponents();

        new Register(getUsername().getText(),getPassword().getText(),getRepeatedPassword().getText(),
                getFirstname().getText(),getLastname().getText(),getEmail().getText(), new Date(Integer.parseInt(dateOfBirth.getYear().getText()),
                Integer.parseInt(dateOfBirth.getMonth().getText()), Integer.parseInt(dateOfBirth.getDay().getText())),sex.getMale().isSelected());
        JOptionPane.showMessageDialog(null, "Registratie succesvol verwerkt!","Registratie",JOptionPane.INFORMATION_MESSAGE);
        c.addDifficultyPanel(true);
    }
}
