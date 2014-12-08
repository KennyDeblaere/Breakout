package analyse_en_programmeerproject.groep5.breakout.view.registration;

import analyse_en_programmeerproject.groep5.breakout.controller.registration.CancelController;
import analyse_en_programmeerproject.groep5.breakout.controller.registration.RegisterController;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.ContentPanel;


import javax.swing.*;
import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class RegistrationPanel extends JPanel {
    private JTextField username, firstname, lastname, email;
    private JPasswordField password, repeatedpassword;
    private SexPanel sexPanel;
    private DatePanel dateOfBirth;
    private ContentPanel content;
    private JLabel usernamelbl, firstnamelbl, lastnamelbl, emaillbl, passwordlbl, repeatedpasswordlbl, sexlbl, dateOfBirthlbl;
    private JButton cancel, register;

    private void createComponents(){
        username = new JTextField(10);
        firstname = new JTextField(10);
        lastname = new JTextField(10);
        email = new JTextField(10);

        password = new JPasswordField(10);
        repeatedpassword = new JPasswordField(10);

        sexPanel = new SexPanel();
        dateOfBirth = new DatePanel();

        usernamelbl = new JLabel("Gebruikersnaam: ");
        firstnamelbl = new JLabel("Voornaam: ");
        lastnamelbl = new JLabel("Naam: ");
        emaillbl = new JLabel("E-mail: ");
        passwordlbl = new JLabel("Wachtwoord: ");
        repeatedpasswordlbl = new JLabel("Herhaal wachtwoord: ");
        sexlbl = new JLabel("Geslacht: ");
        dateOfBirthlbl = new JLabel("Geboortedatum: ");

        cancel = new JButton("Annuleren");
        register = new JButton("Registreren");
    }

    private void addComponents(){
        add(usernamelbl);
        add(username);
        add(passwordlbl);
        add(password);
        add(repeatedpasswordlbl);
        add(repeatedpassword);
        add(firstnamelbl);
        add(firstname);
        add(lastnamelbl);
        add(lastname);
        add(sexlbl);
        add(sexPanel);
        add(dateOfBirthlbl);
        add(dateOfBirth);
        add(emaillbl);
        add(email);
        add(register);
        add(cancel);

    }

    private void addActionListeners(){
        register.addActionListener(new RegisterController(content));
        cancel.addActionListener(new CancelController(content));
    }

    public JTextField getUsername() {
        return username;
    }
    public JPasswordField getPassword() {
        return password;
    }
    public JPasswordField getRepeatedpassword() {
        return repeatedpassword;
    }
    public JTextField getFirstname() {
        return firstname;
    }
    public JTextField getLastname() {
        return lastname;
    }
    public JTextField getEmail() {
        return email;
    }
    public DatePanel getDateOfBirth() {
        return dateOfBirth;
    }
    public SexPanel getSexPanel() {
        return sexPanel;
    }

    public RegistrationPanel(ContentPanel c){
        this.content = c;
        setLayout(new GridLayout(9,2,5,5));
        //setPreferredSize(new Dimension(500,300));
        createComponents();
        addComponents();
        addActionListeners();
    }

}
