package analyse_en_programmeerproject.groep5.breakout.controller.login;

import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kenny on 13/11/2014.
 */
public class CancelController implements ActionListener {
    private PanelLogin topPanel;

    public CancelController(PanelLogin topPanel){
        this.topPanel = topPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        topPanel.addComponents();
    }
}
