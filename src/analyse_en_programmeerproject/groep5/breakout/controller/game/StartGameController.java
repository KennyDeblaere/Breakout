package analyse_en_programmeerproject.groep5.breakout.controller.game;

import analyse_en_programmeerproject.groep5.breakout.data.Database;
import analyse_en_programmeerproject.groep5.breakout.model.Gamemode;
import analyse_en_programmeerproject.groep5.breakout.view.game.GamePanel;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelCenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kenny, Blackhat on 13/11/2014.
 */
public class StartGameController implements ActionListener {
    private PanelCenter panelCenter;
    private JComboBox difficulty;

    public StartGameController(PanelCenter centerPanel, JComboBox difficultyLevel){
        this.panelCenter = centerPanel;
        difficulty = difficultyLevel;
    }

    private int countNumberOfStartingRows(int difficulty){
        switch (difficulty) {
            case 0: return 3;
                break;
            case 1:  return  5;
                break;
            case 2:  return  8;
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Database.DatabaseInstance.insertGameMode(new Gamemode(true, countNumberOfStartingRows(difficulty.getSelectedIndex())));
        panelCenter.addGamePanel(new GamePanel(panelCenter, countNumberOfStartingRows(difficulty.getSelectedIndex())));
        panelCenter.getGamePanel().startGame();
    }
}
