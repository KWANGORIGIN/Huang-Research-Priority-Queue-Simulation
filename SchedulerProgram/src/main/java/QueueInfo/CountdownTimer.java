/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import SchedulingSystem.SchedulingSystem;
import ShoppingCart.ShoppingCartWindow;
import Student.Student;
import java.io.Serializable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.swing.JTextPane;

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

    public void runCountdownTimer(SchedulingSystem schedulingSystem, Student currentStudent, ShoppingCartWindow shoppingCart) {

        CountdownTimer = Executors.newScheduledThreadPool(1);
        
        CountdownWindow timerWindow = new CountdownWindow(this, schedulingSystem, currentStudent, shoppingCart);
        schedulingSystem.getCurrentStudent().setCountdownTimerStartedTime();
        timerWindow.setVisible(true);
        timerWindow.updateTimer(timeInMinutes);
        int remainingSeconds = timeInSeconds;

        while (true) {
            ScheduledFuture<Integer> updatedTime = CountdownTimer.schedule(createTimeUpdater(timeInSeconds, remainingSeconds, timerWindow), 1, TimeUnit.SECONDS);
            try {
                remainingSeconds = updatedTime.get();
                if (remainingSeconds == 0) {
                    CountdownTimer.shutdown();
                    schedulingSystem.getCurrentStudent().setCountdowntimerEndedTime();
                    //CountdownTimer.awaitTermination(5, TimeUnit.SECONDS);
                    timerWindow.dispose();
                    break;
                } else if (((timeInSeconds - timeToJump) == remainingSeconds) && !queueJump) {
                    if (!(this instanceof NoInfoTimer)) {
                        currentStudent.setQueueJumpTime();
                        queueJump = true;
                        remainingSeconds += timeToJump;
                        
                        final CountdownTimer timer = this;
                        final int secondsRemaining = remainingSeconds;
                        
                        
                        System.out.println("Thread: " + Thread.currentThread().getName());
                        /*
                        Did not work to resolve timer being stopped when jumpWindow opens
                        */
                        Runnable r = new Runnable(){
                            
                            @Override
                            public void run(){
                                QueueJumpWindow jumpWindow = new QueueJumpWindow(timer, secondsRemaining / 60);
                                jumpWindow.setVisible(true);
                                System.out.println("Thread: " + Thread.currentThread().getName());
                            }
    
                        };
                        
                        Thread t = new Thread(r);
                        t.start();
                        
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
    
    public String getType(){
        return this.getClass().getName();
    }
    
    public String getDuration(){
        return Integer.toString(timeInMinutes);
    }
    
    public String getQueueJumpTime(){
        return Integer.toString(timeToJump / 60);
    }

}
