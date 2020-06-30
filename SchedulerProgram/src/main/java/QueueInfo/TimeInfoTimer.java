/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Kevin Wang
 */
public class TimeInfoTimer extends CountdownTimer {

    public TimeInfoTimer(int timeInMinutes) {
        super(timeInMinutes);
    }

    public static void main(String[] args) {
//        CountdownWindow timerWindow = new CountdownWindow();
//        timerWindow.setVisible(true);

        CountdownTimer testTimer = new TimeInfoTimer(3);
        testTimer.runCountdownTimer();
    }

    @Override
    protected QueueInfo.TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        return new TimeInfoUpdater(initialTimeInSeconds, remainingSeconds, timerWindow);
    }

    @Override
    void updateDisplay(Integer currentTime, JTextPane timerDisplay) {

        timerDisplay.setText("Due to some seniors that are considering the course,\nthere will be a delay of about " + currentTime.toString() + " minute(s).");

    }

}
