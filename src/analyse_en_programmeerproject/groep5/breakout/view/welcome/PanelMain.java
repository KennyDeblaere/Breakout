package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class PanelMain extends JPanel{

    private PanelLogin panelLogin;
    private PanelStatus panelStatus;
    private PanelCenter panelCenter;


    public PanelMain() {
        super();
        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        panelStatus = new PanelStatus("RUN");
        panelCenter = new PanelCenter();
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
