package be.howest.groep5.breakout.controller.game;

import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.model.Gamemode;
import be.howest.groep5.breakout.view.game.GamePanel;
import be.howest.groep5.breakout.view.welcome.CenterPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class StartGameController implements ActionListener {
    private CenterPanel panelCenter;
    private JComboBox difficulty;
    private boolean singleplayer;
    private Robot r;
    public StartGameController(CenterPanel centerPanel, JComboBox difficultyLevel, boolean singleplayer){
        this.panelCenter = centerPanel;
        difficulty = difficultyLevel;
        this.singleplayer = singleplayer;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Database.DatabaseInstance.insertGameMode(new Gamemode(singleplayer, difficulty.getSelectedIndex()));
        panelCenter.addGamePanel(new GamePanel(panelCenter, singleplayer, difficulty.getSelectedIndex(), panelCenter));
        panelCenter.getGamePanel().startGame();
        panelCenter.setGameMode(singleplayer);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
    }
}
