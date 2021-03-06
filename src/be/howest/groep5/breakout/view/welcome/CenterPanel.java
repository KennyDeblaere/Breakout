package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.model.multimedia.Multimedia;
import be.howest.groep5.breakout.view.game.GamePanel;
import be.howest.groep5.breakout.view.game.ScorePanel;
import be.howest.groep5.breakout.view.highscores.AddHighscorePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class CenterPanel extends JPanel {
    private DifficultyPanel difficultyPanel;
    private ContentPanel panelContent;
    private ButtonPanel panelButton;
    private GamePanel gamePanel;
    private ScorePanel scorePanel;
    private AddHighscorePanel highscorePanel;
    private Multimedia multimedia;
    private Image background;
    private boolean isSinglePlayer;


    public CenterPanel(){
        super();
        createComponents();
        setComponents();
        addMainComponents();
        repaint();
    }

    private void createComponents(){
        panelContent = new ContentPanel(this);
        panelButton = new ButtonPanel(panelContent);
        gamePanel = new GamePanel(this,isSinglePlayer,0, this);
        scorePanel = new ScorePanel(gamePanel);
        multimedia = new Multimedia();
        background = multimedia.getSubbackground();
        highscorePanel = new AddHighscorePanel(0,this);
    }

    private void setComponents(){
        setBorder(BorderFactory.createLineBorder(Color.black,5));
    }

    public void addMainComponents(){
        removePanel();
        add(panelButton);
        add(panelContent);
        reDraw();
    }

    public void addGamePanel(GamePanel gamePanel){
        removePanel();
        this.gamePanel = gamePanel;
        gamePanel.setScorePanel(this.scorePanel);
        final GamePanel p = this.gamePanel;
        (new Thread() {
            @Override
            public void run() {
                scorePanel = new ScorePanel(p);
            }
        }).start();
        add(this.gamePanel);
        add(this.scorePanel);
        reDraw();
    }

    public void addHighScoreAddPanel(int score){
        removePanel();
        highscorePanel = new AddHighscorePanel(score, this);
        add(highscorePanel);
        reDraw();
    }

    private void reDraw(){
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

    public void setGameMode(Boolean isSinglePlayer) {
        this.isSinglePlayer = isSinglePlayer;
    }
    public Boolean getGameMode() { return isSinglePlayer; }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }
}
