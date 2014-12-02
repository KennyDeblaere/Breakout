package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.swing.*;

/**
 * Created by Blackhat on 2/12/2014.
 */
public class PanelAbout extends JPanel{
    private PanelCenter panelCenter;
    private JLabel textLabel, titelLabel;


    public PanelAbout(PanelCenter c){
        super();
        panelCenter = c;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        setComponents();
        addComponents();
    }
    private void createComponents() {
        titelLabel = new JLabel("About");
        textLabel = new JLabel("Created by: \n " +
                "Deblaere Kenny - CCCP \n" +
                "Dekoninck Dries - CCCP \n" +
                "Vansteelandt Benjamin - SSD");
    }

    private void setComponents(){

    }

    private void addComponents() {
        add(titelLabel);
        add(textLabel);
    }
}
