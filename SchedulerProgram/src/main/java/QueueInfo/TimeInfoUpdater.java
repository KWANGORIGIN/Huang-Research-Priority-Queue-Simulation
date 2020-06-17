/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Wang
 */
public class TimeInfoUpdater extends TimeUpdater{

    public TimeInfoUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        super(initialTimeInSeconds, remainingSeconds, timerWindow);
    }

    @Override
    void showDialog() {
        JOptionPane.showMessageDialog(timerWindow, "Now " + currentMinutes + " minutes remaining.", "Update", 1);
    }
    
}
