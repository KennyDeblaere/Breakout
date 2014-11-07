package analyse_en_programmeerproject.groep5.breakout.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenny Deblaere.
 */
public class DatePanel2 extends JPanel {
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

    public DatePanel2(){
        setLayout(new FlowLayout((FlowLayout.LEFT)));
        createComponents();
        addComponents();
    }
}
