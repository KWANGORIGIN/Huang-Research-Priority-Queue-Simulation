/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

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