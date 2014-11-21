package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class PanelStatus extends JPanel {
        private JPanel StatusPanel;
        private JLabel StatusLabel;

        public PanelStatus() {
            super();
            setPreferredSize(new Dimension((int)getMaximumSize().getWidth(),40));
            createComponents();
            setComponents();
            addComponents();
        }

        private void createComponents() {
            StatusPanel = new JPanel();
            StatusLabel = new JLabel("Status: RUN");
        }

        private void setComponents() {
            StatusPanel.add(StatusLabel);
        }

        private void addComponents() {

            add(StatusPanel);
        }
}
