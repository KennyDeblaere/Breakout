package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.view.game.GamePanel;
import analyse_en_programmeerproject.groep5.breakout.view.highscores.AddHighscorePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenny on 28/11/2014.
 */
public class PanelCenter extends JPanel {
    private PanelContent panelContent;
    private PanelButton panelButton;
    private GamePanel gamePanel;
    private AddHighscorePanel highscorePanel;


    public PanelCenter(){
        super();
        createComponents();
        setComponents();
        addMainComponents();
    }

    private void createComponents(){
        panelContent = new PanelContent(this);
        panelButton = new PanelButton(panelContent);
        gamePanel = new GamePanel(this);
        highscorePanel = new AddHighscorePanel(0,this);
    }

    private void setComponents(){

        panelContent.setBorder(BorderFactory.createLineBorder(Color.RED));
        panelButton.setBackground(Color.GRAY);
    }

    public void addMainComponents(){
        remove(gamePanel);
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
        revalidate();
        repaint();
    }

    public void addHighScoreAddPanel(int score){
        highscorePanel = new AddHighscorePanel(score, this);
        remove(panelButton);
        remove(gamePanel);
        remove(panelContent);
        add(highscorePanel);
        revalidate();
        repaint();
    }



    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public PanelContent getPanelContent() {
        return panelContent;
    }
}
