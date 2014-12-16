package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.controller.game.StartGameController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 04/12/2014.
 */
public class DifficultyPanel extends JPanel{
    private CenterPanel panelCenter;
    private JPanel difficultyPanel;
    private JButton playButton;
    private JLabel textLabel, titelLabel, emptyLabel;
    private JComboBox difList;
    private String[] difficultyStrings = {"Gemakkelijk", "Gemiddeld", "Moeilijk" };
    private boolean singleplayer;

    public DifficultyPanel(CenterPanel c, boolean singleplayer){
        super();
        panelCenter = c;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        difficultyPanel = new JPanel(new GridLayout(5,1,0,20));
        this.singleplayer = singleplayer;

        createComponents();
        setComponents();
        setTitle(singleplayer);
        addComponents();
        addActionListeners();
    }

    private void createComponents() {
        titelLabel = new JLabel();
        emptyLabel = new JLabel();
        titelLabel.setFont(new Font(null, Font.BOLD, 20));
        textLabel = new JLabel("Kies de moeilijkheid");
        playButton = new JButton("Start!");
        difList = new JComboBox(difficultyStrings);
    }

    private void setComponents(){
        difList.setSelectedIndex(0);
        difficultyPanel.add(emptyLabel);
        difficultyPanel.add(titelLabel);
        difficultyPanel.add(textLabel);
        difficultyPanel.add(difList);
        difficultyPanel.add(playButton);
    }

    private void addComponents() {
        add(difficultyPanel);
    }

    private void setTitle(boolean singleplayer) {
        if (singleplayer){
            titelLabel.setText("Single Player");
        } else {
            titelLabel.setText("  CO - OP");
        }
    }

    public boolean isSingleplayer() {
        return singleplayer;
    }

    private void addActionListeners(){
        playButton.addActionListener(new StartGameController(panelCenter, difList, isSingleplayer()));
    }
}
