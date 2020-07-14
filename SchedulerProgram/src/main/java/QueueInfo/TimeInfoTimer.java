/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import javax.swing.JTextPane;

/**
 *
 * @author Kevin Wang
 */
public class TimeInfoTimer extends CountdownTimer {

    public TimeInfoTimer(int timeInMinutes, int timeToJump) {
        super(timeInMinutes, timeToJump);
    }

    public static void main(String[] args) {
//        CountdownWindow timerWindow = new CountdownWindow();
//        timerWindow.setVisible(true);

        CountdownTimer testTimer = new TimeInfoTimer(3, 2);
        testTimer.runCountdownTimer();
    }

    @Override
    protected QueueInfo.TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        return new TimeInfoUpdater(initialTimeInSeconds, remainingSeconds, timerWindow);
    }

    @Override
    void updateTimerDisplay(Integer currentTime, JTextPane timerDisplay) {

        timerDisplay.setText("Due to some seniors that are considering the course,\nthere will be a delay of about " + currentTime.toString() + " minute(s).");

    }
    
    @Override
    void setQueueJumpDisplay(Integer currentTime, JTextPane queueJumpDisplay){
        
        queueJumpDisplay.setText("Due to a new senior in the system that is considering the same course,\nthere will be a delay of about " + currentTime.toString() + " minute(s).\nThank you for your patience.");
    }

}
