package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.controller.startbuttons.ButtonController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class ButtonPanel extends JPanel{
    private JPanel ButtonPanel;
    private JButton single, co, high, howto, about;
    private ContentPanel panelContent;

    public ButtonPanel(ContentPanel panelContent) {
        super();
        this.panelContent = panelContent;
        setPreferredSize(new Dimension(300, 600));
        createComponents();
        setComponents();
        addComponents();
        addListeners();
    }

    private void createComponents() {
        ButtonPanel = new JPanel(new GridLayout(5,1,0,30));
        single = new JButton("Single Player");
        co = new JButton("co-op");
        high = new JButton("Highscore");
        howto = new JButton("How To Play");
        about = new JButton("About");
    }

    private void setComponents() {
        setBackground(Color.GRAY);
        single.setPreferredSize(new Dimension(150, 50));
        co.setPreferredSize(new Dimension(150, 50));
        high.setPreferredSize(new Dimension(150, 50));
        about.setPreferredSize(new Dimension(150, 50));
        howto.setPreferredSize(new Dimension(150, 50));
        ButtonPanel.setBackground(Color.GRAY);
        ButtonPanel.add(single);
        ButtonPanel.add(co);
        ButtonPanel.add(high);
        ButtonPanel.add(howto);
        ButtonPanel.add(about);
    }

    private void addComponents() {
        add(ButtonPanel);
    }

    private void addListeners(){
        single.addActionListener(new ButtonController(panelContent, "Single"));
        co.addActionListener(new ButtonController(panelContent,"CO"));
        high.addActionListener(new ButtonController(panelContent, "High"));
        howto.addActionListener(new ButtonController(panelContent, "Howto"));
        about.addActionListener(new ButtonController(panelContent, "About"));
    }
}
