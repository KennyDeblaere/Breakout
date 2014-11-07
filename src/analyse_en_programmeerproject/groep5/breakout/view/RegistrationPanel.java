package analyse_en_programmeerproject.groep5.breakout.view;

import analyse_en_programmeerproject.groep5.breakout.controller.RegisterController;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * Created by Kenny Deblaere.
 */
public class RegistrationPanel extends JPanel {
    private JTextField username, firstname, lastname, email;
    private JPasswordField password, repeatedpassword;
    private SexPanel sexPanel;
    private DatePanel dateOfBirth;
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
        register.addActionListener(new RegisterController(username, password,
                repeatedpassword, firstname, lastname, email,
                dateOfBirth, sexPanel));


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

    public RegistrationPanel(){
        setLayout(new GridLayout(9,2,5,5));
        setPreferredSize(new Dimension(500,300));
        createComponents();
        addComponents();
    }

}
