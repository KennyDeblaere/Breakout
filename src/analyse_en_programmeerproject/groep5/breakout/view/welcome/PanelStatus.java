package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class PanelStatus extends JPanel {
        private JLabel statusLabel;
        private String info;

        public PanelStatus(String info) {
            super();
            this.info = info;
            setPreferredSize(new Dimension((int)getMaximumSize().getWidth(),40));
            createComponents();
            addComponents();
        }

        private void createComponents() {
            statusLabel = new JLabel("Status: " + info);
        }

        private void addComponents() {
            add(statusLabel);
        }
}
