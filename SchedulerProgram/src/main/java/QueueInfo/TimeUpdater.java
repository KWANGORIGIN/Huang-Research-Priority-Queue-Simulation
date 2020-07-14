/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import javax.swing.SwingUtilities; 

/**
 *
 * @author Kevin Wang
 */
public abstract class TimeUpdater implements Callable<Integer> {

    int initialTimeInSeconds;
    int currentSeconds;
    int currentMinutes;
    CountdownWindow timerWindow;

    TimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        this.initialTimeInSeconds = initialTimeInSeconds;
        this.currentSeconds = remainingSeconds;
        this.currentMinutes = remainingSeconds / 60;
        this.timerWindow = timerWindow;
    }

    TimeUpdater(int initialTimeInSeconds, int remainingSeconds) {
        this.initialTimeInSeconds = initialTimeInSeconds;
        this.currentSeconds = remainingSeconds;
        this.currentMinutes = remainingSeconds / 60;
    }

    @Override
    public Integer call() throws Exception {

        System.out.println("Updated timer with current second: " + currentSeconds + " at time: " + LocalDateTime.now().toString());
        if (currentSeconds % 60 == 0) {
            System.out.println("Current seconds: " + currentSeconds);
            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    try {
                        updateTimer();
                    } catch (Exception e) {
                        System.out.println("Error with thread");
                    }
                }

            });

            if (initialTimeInSeconds != currentSeconds) {
                showDialog();
            }

        }

        return currentSeconds - 1;
    }

//    void printDialogToUser() {
//
//        showDialog();
//
//    }

    abstract void showDialog();
    void updateTimer() {
        timerWindow.updateTimer(currentMinutes);
    }

}
