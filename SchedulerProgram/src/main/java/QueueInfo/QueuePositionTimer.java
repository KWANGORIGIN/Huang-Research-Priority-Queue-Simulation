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
//        CountdownTimer testTimer = new QueuePositionTimer(2, 2);
//        testTimer.runCountdownTimer();
    }

    @Override
    protected TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        return new QueuePositionTimeUpdater(initialTimeInSeconds, remainingSeconds, timerWindow);
    }

    @Override
    void updateTimerDisplay(Integer currentTime, JTextPane timerDisplay) {
        String fontFamily = timerDisplay.getFont().getFamily();
        timerDisplay.setText("<body style=\"font-size: 18px\";\"font-family: " + fontFamily + "\"<body> Due to some seniors that are considering the course,<br><br>you are in position <b><u>" + currentTime.toString() + " of the line</b></u>.</body>");
    }
    
    @Override
    void setQueueJumpDisplay(Integer currentTime, JTextPane queueJumpDisplay){
        String fontFamily = queueJumpDisplay.getFont().getFamily();
        queueJumpDisplay.setText("<body style=\"font-size: 18px\";\"font-family: " + fontFamily + "\"<body> Due to a new senior in the system that is considering the same course, <br><br> you are now in position <b><u>" + currentTime.toString() + " of the line</b></u>. <br><br> Thank you for your patience.</body>");
    }

}
