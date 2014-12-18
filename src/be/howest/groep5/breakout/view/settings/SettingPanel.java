package be.howest.groep5.breakout.view.settings;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Blackhat on 18/12/2014.
 */
public class SettingPanel extends JPanel implements ActionListener, ChangeListener{
    private JPanel setting;
    private JLabel titelLabel;
    private JSlider volume;
    private JComboBox soundList;
    private String[] soundStrings = {"Sound 1", "Sound 2", "Sound 3", "Sound 4", "Sound 5", "Sound 6", "Sound 7", "Sound 8", "Sound 9" };
    private String soundnumber;

    public SettingPanel(){
        super();
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        setting = new JPanel(new GridLayout(3,1));
        titelLabel = new JLabel("Instellingen");
        soundList = new JComboBox(soundStrings);
        volume = new JSlider(0,100,50);
    }

    private void setComponents() {
        titelLabel.setFont(new Font(null, Font.BOLD, 30));
        soundList.setSelectedIndex(0);
        //soundList.actionPerformed(this);
        volume.addChangeListener(this);
        setting.add(titelLabel);
        setting.add(soundList);
        setting.add(volume);
    }

    private void addComponents() {
        add(setting);
    }

    public static void setVolume(float value){
        value /= 100;
        try {
            Line line = AudioSystem.getLine(Port.Info.SPEAKER);
            line.open();
            FloatControl control =(FloatControl)line.getControl(FloatControl.Type.VOLUME);
            control.setValue(value);
            line.close();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stateChanged(ChangeEvent e) {
        int vol = volume.getValue();
        setVolume((float)vol);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
