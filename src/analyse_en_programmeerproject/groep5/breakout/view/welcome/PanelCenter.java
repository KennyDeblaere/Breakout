package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.view.game.GamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenny on 28/11/2014.
 */
public class PanelCenter extends JPanel {
    private PanelContent panelContent;
    private PanelButton panelButton;
    private GamePanel gamePanel;


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
    }

    private void setComponents(){

        panelContent.setBorder(BorderFactory.createLineBorder(Color.RED));
        panelButton.setBackground(Color.GRAY);
    }

    public void addMainComponents(){
        add(panelButton);
        add(panelContent);
        revalidate();
        repaint();
    }

    public void addGamePanel(){
        remove(panelButton);
        remove(panelContent);
        add(gamePanel);
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
