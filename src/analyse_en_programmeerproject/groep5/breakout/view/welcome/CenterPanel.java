package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.view.game.GamePanel;
import analyse_en_programmeerproject.groep5.breakout.view.registration.RegistrationPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class CenterPanel extends JPanel{
    private RegistrationPanel registration;
    private GamePanel game;

    public CenterPanel() {
        super();
        setPreferredSize(new Dimension(1000, 600));
        createComponents();
        addRegistrationPanel();

    }

    private void createComponents() {
        registration = new RegistrationPanel(this);
        game = new GamePanel(this);
    }
    public void addMainComponents() {
        remove(registration);
        remove(game);
        revalidate();
        repaint();
    }

    public void addGamePanel(){
        remove(registration);
        add(game);
        revalidate();
        repaint();
    }

    public void addRegistrationPanel() {
        remove(game);
        add(registration);
        revalidate();
        repaint();
    }

    public RegistrationPanel getRegistration() {
        return registration;
    }

    public GamePanel getGame() {
        return game;
    }


}
