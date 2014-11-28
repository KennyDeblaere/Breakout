package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.controller.startbuttons.SingleplayerController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class PanelButton extends JPanel{
    private JPanel ButtonPanel;
    private JButton single, co, high, about;
    private PanelContent panelContent;

    public PanelButton(PanelContent panelContent) {
        super();
        this.panelContent = panelContent;
        setPreferredSize(new Dimension(300, 600));
        createComponents();
        setComponents();
        addListeners();
        addComponents();
    }

    private void createComponents() {
        ButtonPanel = new JPanel(new GridLayout(4,1,0,30));
        single = new JButton("Single Player");
        co = new JButton("co-op");
        high = new JButton("Highscore");
        about = new JButton("About");
    }

    private void setComponents() {
        single.setPreferredSize(new Dimension(150, 50));
        co.setPreferredSize(new Dimension(150, 50));
        high.setPreferredSize(new Dimension(150, 50));
        about.setPreferredSize(new Dimension(150, 50));
        ButtonPanel.add(single);
        ButtonPanel.add(co);
        ButtonPanel.add(high);
        ButtonPanel.add(about);
    }

    private void addListeners(){
        single.addActionListener(new SingleplayerController(panelContent));
    }

    private void addComponents() {
        add(ButtonPanel);
    }
}
