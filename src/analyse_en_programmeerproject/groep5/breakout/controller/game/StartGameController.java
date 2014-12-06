package analyse_en_programmeerproject.groep5.breakout.controller.game;

import analyse_en_programmeerproject.groep5.breakout.view.game.GamePanel;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelCenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kenny, Blackhat on 13/11/2014.
 */
public class StartGameController implements ActionListener {
    private PanelCenter c;

    public StartGameController(PanelCenter centerPanel, String difficultyLevel){
        this.c = centerPanel;
        Difficulty(difficultyLevel);
    }

    private void Difficulty(String difficulty){
        switch (difficulty) {
            case "Gemakkelijk": //c.addGamePanel(new GamePanel(c,3));
                break;
            case "Gemiddeld":  //c.addGamePanel(new GamePanel(c,5));
                break;
            case "Moeilijk":  //c.addGamePanel(new GamePanel(c,8));
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Database.DatabaseInstance.insertGameMode(new Gamemode());
        c.addGamePanel(new GamePanel(c));
        c.getGamePanel().startGame();
    }
}
