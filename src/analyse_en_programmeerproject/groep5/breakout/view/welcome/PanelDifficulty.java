package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.controller.game.StartGameController;
import javafx.scene.text.Font;

import javax.swing.*;

/**
 * Created by Kenny on 28/11/2014.
 */
public class PanelDifficulty extends JPanel {
    private PanelCenter panelCenter;
    private JRadioButton radioEasy, radioMedium, radioHard;
    private JButton playButton;
    private JLabel textLabel, titelLabel;
    private boolean singleplayer;

    public PanelDifficulty(PanelCenter c){
        super();
        panelCenter = c;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        addComponents();
        addActionListeners();

    }

    private void createComponents() {
        titelLabel = new JLabel();
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
        add(titelLabel);
        add(textLabel);
        add(radioEasy);
        add(radioMedium);
        add(radioHard);
        add(playButton);
    }

    public boolean isSingleplayer() {
        return singleplayer;
    }

    public void setSingleplayer(boolean singleplayer) {
        this.singleplayer = singleplayer;
        if (singleplayer){
            titelLabel.setText("Single Player");
        } else {
            titelLabel.setText("CO-OP");
        }
    }
}
