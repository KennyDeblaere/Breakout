package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.view.game.GamePanel;
import be.howest.groep5.breakout.view.game.ScorePanel;
import be.howest.groep5.breakout.view.highscores.AddHighscorePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 04/12/2014.
 */
public class CenterPanel extends JPanel {
    private ContentPanel panelContent;
    private ButtonPanel panelButton;
    private GamePanel gamePanel;
    private ScorePanel scorePanel;
    private AddHighscorePanel highscorePanel;


    public CenterPanel(){
        super();
        createComponents();
        setComponents();
        addMainComponents();
    }

    private void createComponents(){
        panelContent = new ContentPanel(this);
        panelButton = new ButtonPanel(panelContent);
        gamePanel = new GamePanel(this, 1, true,0);
        scorePanel = new ScorePanel(true);
        highscorePanel = new AddHighscorePanel(0,this);
    }

    private void setComponents(){
        setBorder(BorderFactory.createLineBorder(Color.black,5));
    }

    public void addMainComponents(){
        remove(gamePanel);
        remove(scorePanel);
        remove(highscorePanel);
        add(panelButton);
        add(panelContent);
        revalidate();
        repaint();
    }

    public void addGamePanel(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        remove(panelButton);
        remove(highscorePanel);
        remove(panelContent);
        add(this.gamePanel);
        add(this.scorePanel);
        revalidate();
        repaint();
    }

    public void addHighScoreAddPanel(int score){
        highscorePanel = new AddHighscorePanel(score, this);
        remove(panelButton);
        remove(gamePanel);
        remove(scorePanel);
        remove(panelContent);
        add(highscorePanel);
        revalidate();
        repaint();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public ContentPanel getPanelContent() {
        return panelContent;
    }
}
