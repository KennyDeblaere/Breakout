package be.howest.groep5.breakout.view.registration;

import javax.swing.*;
import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class DatePanel extends JPanel {
    private JTextField day,month,year;

    public JTextField getDay() {
        return day;
    }
    public JTextField getMonth() {
        return month;
    }
    public JTextField getYear() {
        return year;
    }

    private void createComponents(){
        day = new JTextField(5);
        month = new JTextField(5);
        year = new JTextField(5);
    }

    private void addComponents(){
        add(day);
        add(month);
        add(year);
    }

    public DatePanel(){
        setLayout(new FlowLayout((FlowLayout.LEFT)));
        createComponents();
        addComponents();
    }
}
