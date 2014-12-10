package be.howest.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class MainPanel extends JPanel{

    private PanelLogin panelLogin;
    private StatusPanel panelStatus;
    private CenterPanel panelCenter;


    public MainPanel() {
        super();
        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        panelStatus = new StatusPanel();
        panelCenter = new CenterPanel();
        panelLogin = new PanelLogin(panelCenter.getPanelContent());
    }

    private void setComponents() {
        panelLogin.setBackground(Color.GRAY);
        panelStatus.setBackground(Color.GRAY);
    }

    private void addComponents(){
        add(panelLogin, BorderLayout.NORTH);
        add(panelCenter);
        add(panelStatus, BorderLayout.SOUTH);
    }
}
