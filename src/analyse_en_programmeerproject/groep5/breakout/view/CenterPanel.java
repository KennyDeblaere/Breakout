package analyse_en_programmeerproject.groep5.breakout.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Benjamin on 6/11/2014.
 */
public class CenterPanel extends JPanel {
    private MenuCenterPanel menuPanel;
    private DifficultyPanel difficultyPanel;

    public CenterPanel() {
        createComponents();
        addComponents();
    }

    private void createComponents() {
        menuPanel = new MenuCenterPanel();
        difficultyPanel = new DifficultyPanel();
    }

    private void setComponents() {
    }

    private void addComponents() {
        add(menuPanel);
        add(difficultyPanel);
    }
}
