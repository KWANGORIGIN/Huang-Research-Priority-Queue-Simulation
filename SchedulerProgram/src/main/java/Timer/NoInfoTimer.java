package Timer;

import QueueInfo.NoInfoTimeUpdater;
import QueueInfo.TimeUpdater;
import Timer.CountdownWindow;
import Timer.CountdownTimer;

/**
 *
 * @author wanga
 */
public class NoInfoTimer extends CountdownTimer {
    
    public NoInfoTimer(int timeInMinutes){
        super(timeInMinutes);
    }
    
    public static void main(String[] args){
        CountdownTimer testTimer = new NoInfoTimer(2);
        testTimer.runCountdownTimer();
    }

    @Override
    protected TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        return new NoInfoTimeUpdater(initialTimeInSeconds, remainingSeconds, timerWindow);
    }
    
}