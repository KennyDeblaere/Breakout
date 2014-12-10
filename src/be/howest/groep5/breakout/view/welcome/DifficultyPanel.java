package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.controller.game.StartGameController;

import javax.swing.*;

/**
 * Created by Blackhat on 04/12/2014.
 */
public class DifficultyPanel extends JPanel{
    private CenterPanel panelCenter;
    private JButton playButton;
    private JLabel textLabel, titelLabel;
    private JComboBox difList;
    private String difficultyLevel;
    private String[] difficultyStrings = {"Gemakkelijk", "Gemiddeld", "Moeilijk" };
    private boolean singleplayer;

    public DifficultyPanel(CenterPanel c, boolean singleplayer){
        super();
        panelCenter = c;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.singleplayer = singleplayer;

        createComponents();
        setComponents();
        setTitle(singleplayer);
        addComponents();
        addActionListeners();
    }

    private void createComponents() {
        titelLabel = new JLabel();
        textLabel = new JLabel("Kies de moeilijkheid");
        playButton = new JButton("Start!");
        difList = new JComboBox(difficultyStrings);
    }

    private void setComponents(){
        difList.setSelectedIndex(0);

    }

    private void addComponents() {
        add(titelLabel);
        add(textLabel);
        add(difList);
        add(playButton);
    }

    private void setTitle(boolean singleplayer) {
        if (singleplayer){
            titelLabel.setText("Single Player");
        } else {
            titelLabel.setText("CO-OP");
        }
    }

    public boolean isSingleplayer() {
        return singleplayer;
    }

    private void addActionListeners(){
        playButton.addActionListener(new StartGameController(panelCenter, difList, isSingleplayer()));
    }
}
