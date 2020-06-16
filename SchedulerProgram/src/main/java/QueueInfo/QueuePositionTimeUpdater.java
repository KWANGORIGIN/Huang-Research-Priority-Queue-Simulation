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
public class QueuePositionTimeUpdater extends TimeUpdater{

    public QueuePositionTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        super(initialTimeInSeconds, remainingSeconds, timerWindow);
    }

    @Override
    void showDialog() {
        JOptionPane.showMessageDialog(timerWindow, "Now at position " + currentMinutes + " in the line.", "Update", 1);
    }
    
}
