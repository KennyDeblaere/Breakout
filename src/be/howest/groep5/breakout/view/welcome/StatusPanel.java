package be.howest.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class StatusPanel extends JPanel {
        private JLabel statusLabel;

        public StatusPanel() {
            super();
            setPreferredSize(new Dimension((int)getMaximumSize().getWidth(),40));
            createComponents();
            addComponents();
        }

        private void createComponents() {
            statusLabel = new JLabel("Status: RUN");
        }

        private void addComponents() {
            add(statusLabel);
        }

}
