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
 * Abstract class that defines methods for several CountdownTimers. It contains all the logic for running a Countdown timer.
 * @author wanga
 */
public abstract class CountdownTimer implements Serializable {

    protected ScheduledExecutorService CountdownTimer;
    protected int timeInSeconds;
    protected int timeInMinutes;
    protected int timeToJump;
    protected boolean queueJump;

    /**
     * CountdownTimer constructor. Ex.) If timeToJump = 5 while timeInMinutes = 10 then after 5 minutes the timer should jump from 5 to 10 minutes as per Dr. Huang's specification
     * @param timeInMinutes integer of how long the timer should run for in minutes
     * @param timeToJump integer that represents when the timer should jump. 
     */
    public CountdownTimer(int timeInMinutes, int timeToJump) {
        this.timeInMinutes = timeInMinutes;
        this.timeInSeconds = timeInMinutes * 60;
        this.timeToJump = timeToJump * 60;
        queueJump = false;
    }

    /**
     * Method that runs the countdown timer.
     * @param schedulingSystem SchedulingSystem object
     * @param currentStudent Student who is currently running the system
     * @param shoppingCart ShoppingCartWindow that is currently open
     */
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
    
    /**
     * Creates a time updater that helps update the time on the CountdownWindow
     * @param initialTimeInSeconds integer of the initial time in seconds
     * @param remainingSeconds integer of the remaining seconds
     * @param timerWindow CountdownWindow to be updated
     * @return 
     */
    protected abstract TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow);

    /**
     * Updates timer display. Provides a message that contains information if not a NoInfoTimer
     * @param currentTime Integer object of current time
     * @param timerDisplay JTextPane of timerDisplay to be updated
     */
    abstract void updateTimerDisplay(Integer currentTime, JTextPane timerDisplay);

    /**
     * Updates timer display when queue jump occurs. Provides a message that contains information if not a NoInfoTimer
     * @param currentTime
     * @param queueJumpDisplay 
     */
    abstract void setQueueJumpDisplay(Integer currentTime, JTextPane queueJumpDisplay);
    
    /**
     * Gets String about type of timer
     * @return String about type of timer
     */
    public String getType(){
        return this.getClass().getName();
    }
    
    /**
     * Gets String of the timer's duration
     * @return String of the timer's duration
     */
    public String getDuration(){
        return Integer.toString(timeInMinutes);
    }
    
    /**
     * Gets String of when queue jump is to occur
     * @return String of when queue jump is to occur
     */
    public String getQueueJumpTime(){
        return Integer.toString(timeToJump / 60);
    }

}
