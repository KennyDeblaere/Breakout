package analyse_en_programmeerproject.groep5.breakout.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Benjamin on 6/11/2014.
 */
public class MainPanel extends JPanel {
    //private MenuCenterPanel centerPanel;
    //private DifficultyPanel difficulty;
    private CenterPanel centerPanel;
    private MenuTopPanel topPanel;


    public MainPanel() {
        setLayout(new BorderLayout(0,200));

        createComponents();
        addComponents();
    }

    private void createComponents(){
        //centerPanel = new MenuCenterPanel();
        //difficulty = new DifficultyPanel();
        topPanel = new MenuTopPanel();
        centerPanel = new CenterPanel();
    }

    private void addComponents() {
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        //add(centerPanel, BorderLayout.CENTER);
        //add(difficulty, BorderLayout.CENTER);
    }
}
