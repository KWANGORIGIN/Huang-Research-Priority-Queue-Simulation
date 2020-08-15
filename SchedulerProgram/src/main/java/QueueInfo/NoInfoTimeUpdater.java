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
public class NoInfoTimeUpdater extends TimeUpdater {
    
    public NoInfoTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        super(initialTimeInSeconds, remainingSeconds, timerWindow);
    }

    @Override
    void showDialog() {
        Runnable messageDialog = new Runnable(){
            
            @Override
            public void run(){
                JOptionPane.showMessageDialog(timerWindow, "Thank you for your patience.", "Update", 1);
            }
            
        };
        
        Thread message = new Thread(messageDialog);
        message.start();  
    }
    
    void updateTimer(){
        
    }

}
