package QueueInfo;

import javax.swing.JLabel;
import javax.swing.JTextPane;

/**
 *
 * @author wanga
 */
public class NoInfoTimer extends CountdownTimer {

    public NoInfoTimer(int timeInMinutes, int timeToJump) {
        super(timeInMinutes, timeToJump);
    }

    public static void main(String[] args) {
        CountdownTimer testTimer = new NoInfoTimer(2, 2);
        testTimer.runCountdownTimer();
    }

    @Override
    protected TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        return new NoInfoTimeUpdater(initialTimeInSeconds, remainingSeconds, timerWindow);
    }

    @Override
    void updateTimerDisplay(Integer currentTime, JTextPane timerDisplay) {
        
        timerDisplay.setText("Due to some seniors that are considering the course,\nthere will be a delay for registration for the class.");
        
    }
    
    @Override
    void setQueueJumpDisplay(Integer currentTime, JTextPane queueJumpDisplay){
        
    }

}
