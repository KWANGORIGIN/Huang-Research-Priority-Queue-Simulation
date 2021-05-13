package QueueInfo;

import javax.swing.JLabel;
import javax.swing.JTextPane;

/**
 * NoInfoTimer that is used when the No Info option is selected in AdminWindow
 * @author Kevin Wang
 */
public class NoInfoTimer extends CountdownTimer {

    /**
     * Constructor for NoInfoTimer
     * @param timeInMinutes
     * @param timeToJump 
     */
    public NoInfoTimer(int timeInMinutes, int timeToJump) {
        super(timeInMinutes, timeToJump);
    }
    
    /**
     * Main method used for debugging
     * @param args 
     */
    public static void main(String[] args) {
//        CountdownTimer testTimer = new NoInfoTimer(2, 2);
//        testTimer.runCountdownTimer();
    }

    @Override
    protected TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        return new NoInfoTimeUpdater(initialTimeInSeconds, remainingSeconds, timerWindow);
    }

    @Override
    void updateTimerDisplay(Integer currentTime, JTextPane timerDisplay) {
        String fontFamily = timerDisplay.getFont().getFamily();
        timerDisplay.setText("<body style=\"font-size: 18px\"; \"font-family: " + fontFamily + "\"<body> Due to some seniors that are considering the course,<br><br>there will be a delay for registration for the class.");
        
    }
    
    /**
     * Blank because for a NoInfoTimer there is no QueueJumpDisplay to show
     * @param currentTime
     * @param queueJumpDisplay
     * 
     */
    @Override
    void setQueueJumpDisplay(Integer currentTime, JTextPane queueJumpDisplay){
        
    }

}
