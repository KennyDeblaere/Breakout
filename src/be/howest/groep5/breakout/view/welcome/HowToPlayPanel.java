package be.howest.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dries Dekoninck on 16/12/2014.
 */
public class HowToPlayPanel extends JPanel{
    private JPanel howtoplay;
    private JLabel titelLabel, howto;
    private ImagePanel imagePanel;

    public HowToPlayPanel(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        titelLabel = new JLabel("How to play?");
        howtoplay = new JPanel();
        howto = new JLabel();
        imagePanel = new ImagePanel("screenshot.jpg");
    }

    private void setComponents(){
        titelLabel.setFont(new Font(null, Font.BOLD, 30));
        howto.setText(convertToMultiline(
                        "Game opties: \n" +
                        "1) Kies in het menu \"Singleplayer\" of \"CO-OP\" \n" +
                        "2) Selecteer de gewenste moeilijkheidsgraad en klik op de \"Start\"-knop \n\n" +
                        "Speel het spel: \n" +
                        "3) Probeer alle blokjes weg te krijgen door deze te raken \n" +
                        "4) Het balletje mag niet op de grond vallen, gebruik hiervoor het balkje onderaan \n" +
                        "5) Naast het speelscherm zie je je eigen score (indien \"CO-OP\" zie je de score van je tegenspeler) \n" +
                        "6) In het zijpaneel zie je ook het aantal levens en de timer van hoelang de powerups/downs \ndie je hebt geraakt gelden \n\n" +
                        "Na het spel: \n" +
                        "7) Sla je score op om in de rangschikking te worden opgenomen"));
        imagePanel.setPreferredSize(new Dimension(600,400));
        howtoplay.setPreferredSize(new Dimension(600, 250));
        howtoplay.add(howto);
    }

    private void addComponents() {
        add(titelLabel);
        add(howtoplay);
        add(imagePanel);
    }

    private String convertToMultiline(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}
