package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.controller.game.StartGameController;

import javax.swing.*;

/**
 * Created by Kenny on 28/11/2014.
 */
public class PanelDifficulty extends JPanel {
    private PanelCenter panelCenter;
    private JRadioButton radioEasy, radioMedium, radioHard;
    private JButton playButton;
    private JLabel textLabel;

    public PanelDifficulty(PanelCenter c){
        super();
        panelCenter = c;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        addComponents();
        addActionListeners();

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

    private void addActionListeners(){
        playButton.addActionListener(new StartGameController(panelCenter));
    }

    private void addComponents() {
        add(textLabel);
        add(radioEasy);
        add(radioMedium);
        add(radioHard);
        add(playButton);
    }

}
