package analyse_en_programmeerproject.groep5.breakout.controller.game;

import analyse_en_programmeerproject.groep5.breakout.view.game.GamePanel;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelCenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kenny, Blackhat on 13/11/2014.
 */
public class StartGameController implements ActionListener {
    private PanelCenter panelCenter;
    private int rijen;

    public StartGameController(PanelCenter centerPanel, String difficultyLevel){
        this.panelCenter = centerPanel;
        Difficulty(difficultyLevel);
    }

    private void Difficulty(String difficulty){
        switch (difficulty) {
            case "Gemakkelijk": rijen = 3;
                break;
            case "Gemiddeld":  rijen = 5;
                break;
            case "Moeilijk":  rijen = 8;
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Database.DatabaseInstance.insertGameMode(new Gamemode());
        panelCenter.addGamePanel(new GamePanel(panelCenter, rijen));
        panelCenter.getGamePanel().startGame();
    }
}
