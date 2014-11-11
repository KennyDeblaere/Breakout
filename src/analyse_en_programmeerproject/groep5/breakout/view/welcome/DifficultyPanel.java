package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import javax.swing.*;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class DifficultyPanel extends JPanel {
    private JRadioButton radioEasy, radioMedium, radioHard;
    private JButton playButton;
    private JLabel textLabel;

    public DifficultyPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        addComponents();
    }

    private void createComponents() {
        textLabel = new JLabel("Kies de moeilijkheid");
        radioEasy = new JRadioButton("Makkelijk");
        radioMedium = new JRadioButton("Gemiddeld");
        radioHard = new JRadioButton("Moeilijk");
        playButton = new JButton("Start!");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioHard);
        buttonGroup.add(radioMedium);
        buttonGroup.add(radioEasy);
    }


    private void addComponents() {
        add(textLabel);
        add(radioEasy);
        add(radioMedium);
        add(radioHard);
        add(playButton);
    }
}
