package QueueInfo;

/**
 *
 * @author wanga
 */
public class NoInfoTime extends CountdownTimer {
    
    public NoInfoTime(int timeInMinutes){
        super(timeInMinutes);
    }
    
    public static void main(String[] args){
        CountdownTimer testTimer = new NoInfoTime(2);
        testTimer.runCountdownTimer();
    }

    @Override
    protected TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        return new NoInfoTimeUpdater(initialTimeInSeconds, remainingSeconds, timerWindow);
    }
    
}