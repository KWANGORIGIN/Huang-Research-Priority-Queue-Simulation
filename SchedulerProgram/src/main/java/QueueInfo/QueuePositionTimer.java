package QueueInfo;

import javax.swing.JTextPane;

/**
 *
 * @author wanga
 */
public class QueuePositionTimer extends CountdownTimer{
    
    public QueuePositionTimer(int timeInMinutes){
        super(timeInMinutes);
    }
    
    public static void main(String[] args){
        CountdownTimer testTimer = new QueuePositionTimer(2);
        testTimer.runCountdownTimer();
    }

    @Override
    protected QueueInfo.TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        return new QueuePositionTimeUpdater(initialTimeInSeconds, remainingSeconds, timerWindow);
    }
    
    @Override
    void updateDisplay(Integer currentTime, JTextPane timerDisplay) {
        timerDisplay.setText("Due to some seniors that are considering the course,\nyou are in position " + currentTime.toString() + " of the line.");
    }
    
}