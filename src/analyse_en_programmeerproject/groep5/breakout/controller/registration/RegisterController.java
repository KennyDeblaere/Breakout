package analyse_en_programmeerproject.groep5.breakout.controller.registration;

import analyse_en_programmeerproject.groep5.breakout.model.Register;
import analyse_en_programmeerproject.groep5.breakout.view.registration.DatePanel;
import analyse_en_programmeerproject.groep5.breakout.view.registration.SexPanel;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelCenter;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class RegisterController implements ActionListener {
    private PanelCenter c;
    private JTextField username, firstname, lastname, email;
    private DatePanel dateOfBirth;
    private SexPanel sex;
    private JPasswordField password, repeatedPassword;

    public RegisterController(PanelCenter panelCenter){
        c = panelCenter;
        }

    private void createComponents(){
        setUsername(c.getRegistration().getUsername());
        setPassword(c.getRegistration().getPassword());
        setRepeatedPassword(c.getRegistration().getRepeatedpassword());
        setFirstname(c.getRegistration().getFirstname());
        setLastname(c.getRegistration().getLastname());
        setEmail(c.getRegistration().getEmail());
        setDateOfBirth(c.getRegistration().getDateOfBirth());
        setSex(c.getRegistration().getSexPanel());
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
        createComponents();
        new Register(getUsername().getText(),getPassword().getText(),getRepeatedPassword().getText(),
                getFirstname().getText(),getLastname().getText(),getEmail().getText(), new Date(Integer.parseInt(dateOfBirth.getYear().getText()),
                Integer.parseInt(dateOfBirth.getMonth().getText()), Integer.parseInt(dateOfBirth.getDay().getText())),sex.getMale().isSelected());
        c.addMainComponents();
    }
}
