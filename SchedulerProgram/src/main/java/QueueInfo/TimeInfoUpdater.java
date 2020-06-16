/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import Timer.CountdownWindow;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

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
    
//    @Override
//    void updateDisplay(JTextPane textPane){
//        textPane.setText("Due to some seniors that are considering the course,\nthere will be a delay of about "+ currentTime.toString() + " minute(s).");
//    }
    
}
