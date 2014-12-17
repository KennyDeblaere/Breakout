package be.howest.groep5.breakout.controller;

import be.howest.groep5.breakout.data.Database;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Kenny, Dries Dekoninck on 15/12/2014.
 */
public class LogoutOnCloseController extends WindowAdapter {

    public LogoutOnCloseController() {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        Database.DatabaseInstance.updateHostNameUserLogout(Database.DatabaseInstance.getUserId());

    }
}
