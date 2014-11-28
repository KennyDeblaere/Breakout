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
        panelLogin = new PanelLogin();
        panelStatus = new PanelStatus();
        panelCenter = new PanelCenter();

    }

    private void setComponents() {
        panelLogin.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panelStatus.setBorder(BorderFactory.createLineBorder(Color.BLUE));

    }

    private void addComponents(){
        add(panelLogin, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelStatus, BorderLayout.SOUTH);
    }
}
