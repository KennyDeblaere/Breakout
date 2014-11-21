package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class PanelMain extends JPanel{

    private PanelLogin login;
    private PanelButton button;
    private PanelContent content;
    private PanelStatus status;

    public PanelMain() {
        super();
        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        login = new PanelLogin();
        button = new PanelButton();
        content = new PanelContent();
        status = new PanelStatus();
    }

    private void setComponents() {
        login.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        content.setBorder(BorderFactory.createLineBorder(Color.RED));
        status.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }

    private void addComponents(){
        add(login, BorderLayout.NORTH);
        add(button, BorderLayout.WEST);
        add(content, BorderLayout.EAST);
        add(status, BorderLayout.NORTH);
    }
}
