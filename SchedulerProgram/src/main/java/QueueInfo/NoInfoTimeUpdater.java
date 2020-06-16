/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 *
 * @author Kevin Wang
 */
public class NoInfoTimeUpdater extends TimeUpdater {
    
    public NoInfoTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        super(initialTimeInSeconds, remainingSeconds, timerWindow);
    }

    @Override
    void showDialog() {
        JOptionPane.showMessageDialog(timerWindow, "Thank you for your patience.", "Update", 1);
    }
    
    @Override
    void updateTimer(){
        
    }
    
    
}
