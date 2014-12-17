package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.view.game.GamePanel;
import be.howest.groep5.breakout.view.game.ScorePanel;
import be.howest.groep5.breakout.view.highscores.AddHighscorePanel;
import be.howest.groep5.breakout.view.welcome.DifficultyPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 04/12/2014.
 */
public class CenterPanel extends JPanel {
    private DifficultyPanel difficultyPanel;
    private ContentPanel panelContent;
    private ButtonPanel panelButton;
    private GamePanel gamePanel;
    private ScorePanel scorePanel;
    private AddHighscorePanel highscorePanel;
    private boolean singlePlayer;


    public CenterPanel(){
        super();
        createComponents();
        setComponents();
        addMainComponents();
    }

    private void createComponents(){
        panelContent = new ContentPanel(this);
        panelButton = new ButtonPanel(panelContent);
        gamePanel = new GamePanel(this, 1, singlePlayer,0);
        scorePanel = new ScorePanel(gamePanel);
        highscorePanel = new AddHighscorePanel(0,this);
    }

    private void setComponents(){
        setBorder(BorderFactory.createLineBorder(Color.black,5));
    }

    public void addMainComponents(){
        removePanel();
        add(panelButton);
        add(panelContent);
        re();
    }

    public void addGamePanel(GamePanel gamePanel){
        removePanel();
        this.gamePanel = gamePanel;
        scorePanel = new ScorePanel(this.gamePanel);
        add(this.gamePanel);
        add(this.scorePanel);
        re();
    }

    public void addHighScoreAddPanel(int score){
        removePanel();
        highscorePanel = new AddHighscorePanel(score, this);
        add(highscorePanel);
        re();
    }

    private void re(){
        revalidate();
        repaint();
    }

    private void removePanel(){
        remove(highscorePanel);
        remove(panelButton);
        remove(gamePanel);
        remove(scorePanel);
        remove(panelContent);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public ContentPanel getPanelContent() {
        return panelContent;
    }
}
