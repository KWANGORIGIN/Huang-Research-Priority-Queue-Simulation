
package QueueInfo;

/**
 *
 * @author wanga
 */
public class QueuePositionTimer extends CountdownTimer{
    
    public QueuePositionTimer(int timeInMinutes){
        super(timeInMinutes);
    }
    
    public static void main(String[] args){
//        CountdownWindow timerWindow = new CountdownWindow();
//        timerWindow.setVisible(true);
        
        CountdownTimer testTimer = new QueuePositionTimer(2);
        testTimer.runCountdownTimer();
        
    }

    @Override
    protected QueueInfo.TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        return new QueuePositionTimeUpdater(initialTimeInSeconds, remainingSeconds, timerWindow);
    }
    
}