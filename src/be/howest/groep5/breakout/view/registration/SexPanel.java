package be.howest.groep5.breakout.view.registration;

import javax.swing.*;

/**
 * Created by Kenny Deblaere.
 */
public class SexPanel extends JPanel {
    private JRadioButton male, female;

    public JRadioButton getMale() {
        return male;
    }
    public JRadioButton getFemale() {
        return female;
    }

    private void createComponents(){
        male = new JRadioButton("Man",true);
        female = new JRadioButton("Vrouw");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);
    }
    private void addComponents(){
        add(male);
        add(female);
    }
    public SexPanel(){
        createComponents();
        addComponents();
    }
}
