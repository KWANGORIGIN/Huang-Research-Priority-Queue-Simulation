/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

/**
 *
 * @author Kevin Wang
 */
public abstract class TimeUpdater implements Callable<Integer> {
    int initialTimeInSeconds;
    int currentSeconds;
    int currentMinutes;
    CountdownWindow timerWindow;

    TimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow){
        this.initialTimeInSeconds = initialTimeInSeconds;
        this.currentSeconds = remainingSeconds;
        this.currentMinutes = remainingSeconds / 60;
        this.timerWindow = timerWindow;
    }

    TimeUpdater(int initialTimeInSeconds, int remainingSeconds){
        this.initialTimeInSeconds = initialTimeInSeconds;
        this.currentSeconds = remainingSeconds;
        this.currentMinutes = remainingSeconds / 60;
    }

    @Override
    public Integer call() throws Exception{
        System.out.println("Updated timer with current second: " + currentSeconds + " at time: " + LocalDateTime.now().toString());
        if(currentSeconds % 60 == 0){
            updateTimer();
            if(initialTimeInSeconds != currentSeconds){
                /*
                Current Issue with this implementation: seconds are not counting down until user hits "Ok" in the message dialog.
                Probably going to have to resolve with opening another window on another thread
                */
                showDialog();
            }

        }
        return --currentSeconds;
    }   
    
    abstract void showDialog();

    void updateTimer() {
        timerWindow.updateTimer(currentMinutes);
    }
    
}
