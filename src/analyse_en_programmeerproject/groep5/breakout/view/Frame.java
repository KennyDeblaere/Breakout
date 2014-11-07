package analyse_en_programmeerproject.groep5.breakout.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenny Deblaere.
 */
public class Frame extends JFrame {

    public Frame(){
        super();
        setTitle("Breakout (c) 2014 groep 5 ");
        setContentPane(new RegistrationPanel());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
}
