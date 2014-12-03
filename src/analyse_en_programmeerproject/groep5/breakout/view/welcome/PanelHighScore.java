package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.swing.*;

/**
 * Created by Blackhat on 3/12/2014.
 */
public class PanelHighScore extends JPanel{
    private JLabel titelLabel;


    public PanelHighScore(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        setComponents();
        addComponents();
    }
    private void createComponents() {
        titelLabel = new JLabel("High Score");
    }

    private void setComponents(){

    }

    private void addComponents() {
        add(titelLabel);
    }
}
