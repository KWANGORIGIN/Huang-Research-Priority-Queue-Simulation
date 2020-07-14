/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import java.io.Serializable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author wanga
 */
public abstract class CountdownTimer implements Serializable {

    protected ScheduledExecutorService CountdownTimer;
    protected int timeInSeconds;
    protected int timeInMinutes;
    protected int timeToJump;
    protected boolean queueJump;

    public CountdownTimer(int timeInMinutes, int timeToJump) {
        this.timeInMinutes = timeInMinutes;
        this.timeInSeconds = timeInMinutes * 60;
        this.timeToJump = timeToJump * 60;
        queueJump = false;
    }

    public void runCountdownTimer() {

        CountdownTimer = Executors.newScheduledThreadPool(1);

        CountdownWindow timerWindow = new CountdownWindow(this);
        timerWindow.setVisible(true);
        timerWindow.updateTimer(timeInMinutes);
        int remainingSeconds = timeInSeconds;

        while (true) {
            ScheduledFuture<Integer> updatedTime = CountdownTimer.schedule(createTimeUpdater(timeInSeconds, remainingSeconds, timerWindow), 1, TimeUnit.SECONDS);
            try {
                remainingSeconds = updatedTime.get();
                if (remainingSeconds == 0) {
                    CountdownTimer.shutdown();
                    //CountdownTimer.awaitTermination(5, TimeUnit.SECONDS);
                    timerWindow.dispose();
                    break;
                } else if (((timeInSeconds - timeToJump) == remainingSeconds) && !queueJump) {
                    if (!(this instanceof NoInfoTimer)) {
                        queueJump = true;
                        remainingSeconds += timeToJump;
                        QueueJumpWindow jumpWindow = new QueueJumpWindow(this, remainingSeconds / 60);
                        jumpWindow.setVisible(true);
                    }
                }

            } catch (Exception e) {
                System.out.println("Oops");
            }
        }

    }

    protected abstract TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow);

    abstract void updateTimerDisplay(Integer currentTime, JTextPane timerDisplay);

    abstract void setQueueJumpDisplay(Integer currentTime, JTextPane queueJumpDisplay);

}
