package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.controller.game.StartGameController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kenny on 28/11/2014.
 */
public class PanelDifficulty extends JPanel implements ActionListener{
    private PanelCenter panelCenter;
    private JButton playButton;
    private JLabel textLabel, titelLabel;
    private JComboBox difList;
    private String difficultyLevel;
    private String[] difficultyStrings = { "Gemakkelijk", "Gemiddeld", "Moeilijk" };
    private boolean singleplayer;

    public PanelDifficulty(PanelCenter c){
        super();
        panelCenter = c;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        addComponents();
    }

    private void createComponents() {
        titelLabel = new JLabel();
        textLabel = new JLabel("Kies de moeilijkheid");
        playButton = new JButton("Start!");
        difList = new JComboBox(difficultyStrings);
        difList.setSelectedIndex(0);
        difList.addActionListener(this);
    }

    private void addActionListeners(){
        System.out.println("addActionListener: " + difficultyLevel);
        playButton.addActionListener(new StartGameController(panelCenter, difficultyLevel));
    }

    private void addComponents() {
        add(titelLabel);
        add(textLabel);
        add(difList);
        add(playButton);
    }

    public void setSingleplayer(boolean singleplayer) {
        this.singleplayer = singleplayer;
        if (singleplayer){
            titelLabel.setText("Single Player");
        } else {
            titelLabel.setText("CO-OP");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        difficultyLevel = (String)cb.getSelectedItem();
        System.out.println("actionPerformed = " + difficultyLevel);
        addActionListeners();
    }
}
