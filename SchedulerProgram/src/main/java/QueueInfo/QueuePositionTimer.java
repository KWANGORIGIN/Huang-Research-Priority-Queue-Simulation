package QueueInfo;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author wanga
 */
public class QueuePositionTimer extends CountdownTimer {

    public QueuePositionTimer(int timeInMinutes, int timeToJump) {
        super(timeInMinutes, timeToJump);
    }

    public static void main(String[] args) {
        CountdownTimer testTimer = new QueuePositionTimer(2, 2);
        testTimer.runCountdownTimer();
    }

    @Override
    protected QueueInfo.TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        return new QueuePositionTimeUpdater(initialTimeInSeconds, remainingSeconds, timerWindow);
    }

    @Override
    void updateTimerDisplay(Integer currentTime, JTextPane timerDisplay) {
        timerDisplay.setText("Due to some seniors that are considering the course,\nyou are in position " + currentTime.toString() + " of the line.");
    }
    
    @Override
    void setQueueJumpDisplay(Integer currentTime, JTextPane queueJumpDisplay){
        queueJumpDisplay.setText("Due to a new senior in the system that is considering the same course\nyou are now in position " + currentTime.toString() + " of the line.\nThank you for your patience.");
    }

}
