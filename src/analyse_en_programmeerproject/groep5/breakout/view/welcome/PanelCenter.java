package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenny on 28/11/2014.
 */
public class PanelCenter extends JPanel {
    private PanelContent panelContent;
    private PanelButton panelButton;


    public PanelCenter(){
        super();
        createComponents();
        setComponents();
        addMainComponents();
    }

    private void createComponents(){
        panelButton = new PanelButton();
        panelContent = new PanelContent();
    }

    private void setComponents(){

        panelContent.setBorder(BorderFactory.createLineBorder(Color.RED));
        panelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void addMainComponents(){
        add(panelButton);
        add(panelContent);
        revalidate();
        repaint();
    }

    public PanelContent getPanelContent() {
        return panelContent;
    }
}
