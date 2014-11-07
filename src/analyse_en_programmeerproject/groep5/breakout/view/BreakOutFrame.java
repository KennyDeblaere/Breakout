package analyse_en_programmeerproject.groep5.breakout.view;

import javax.swing.*;

/**
 * Created by Benjamin on 6/11/2014.
 */
public class BreakOutFrame extends JFrame {
    public BreakOutFrame() {
        super();

        setTitle("Breakout (c) 2014 groep 5");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        MainPanel menu = new MainPanel();
        setContentPane(menu);
    }
}
