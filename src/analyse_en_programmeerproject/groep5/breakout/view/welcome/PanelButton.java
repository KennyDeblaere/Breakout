package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class PanelButton extends JPanel{
    private JPanel ButtonPanel;
    private JButton Single, Co, High, About;

    public PanelButton() {
        super();
        setPreferredSize(new Dimension(300, 600));
        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        ButtonPanel = new JPanel(new GridLayout(4,1,0,30));
        Single = new JButton("Single Player");
        Co = new JButton("Co-op");
        High = new JButton("Highscore");
        About = new JButton("About");
    }

    private void setComponents() {
        Single.setPreferredSize(new Dimension(150,50));
        Co.setPreferredSize(new Dimension(150,50));
        High.setPreferredSize(new Dimension(150,50));
        About.setPreferredSize(new Dimension(150,50));
        ButtonPanel.add(Single);
        ButtonPanel.add(Co);
        ButtonPanel.add(High);
        ButtonPanel.add(About);
    }

    private void addComponents() {
        add(ButtonPanel);
    }
}
