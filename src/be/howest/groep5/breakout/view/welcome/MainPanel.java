package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.model.multimedia.Multimedia;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class MainPanel extends JPanel{

    private PanelLogin panelLogin;
    private StatusPanel panelStatus;
    private CenterPanel panelCenter;
    private Multimedia multimedia = new Multimedia();
    private Image background;


    public MainPanel() {
        super();
        createComponents();
        setComponents();
        addComponents();
        setBackground();
    }

    private void createComponents() {
        panelStatus = new StatusPanel();
        panelCenter = new CenterPanel();
        panelLogin = new PanelLogin(panelCenter.getPanelContent());
    }

    private void setComponents() {
        //panelLogin.setBackground(Color.GRAY);
        //panelStatus.setBackground(Color.GRAY);
        //Maakt de panels doorzictig
        panelLogin.setOpaque(false);
        panelStatus.setOpaque(false);
    }

    private void addComponents(){
        add(panelLogin, BorderLayout.NORTH);
        add(panelCenter);
        add(panelStatus, BorderLayout.SOUTH);
    }

    private void setBackground() {
        background = multimedia.getMainBackground();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }
}
