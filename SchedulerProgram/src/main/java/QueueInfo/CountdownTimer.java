/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
/**
 *
 * @author wanga
 */
public abstract class CountdownTimer {
    
    protected ScheduledExecutorService CountdownTimer; 
    protected int timeInSeconds;
    protected int timeInMinutes;
    protected boolean queueJump;
    
    public CountdownTimer(int timeInMinutes){
       this.timeInMinutes = timeInMinutes;
       this.timeInSeconds = timeInMinutes * 60;
       queueJump = false;
    }
    
    public void runCountdownTimer(){
        
        CountdownTimer = Executors.newScheduledThreadPool(1);
        
        CountdownWindow timerWindow = new CountdownWindow(this);
        timerWindow.setVisible(true);
        
        if(this instanceof NoInfoTime){
            timerWindow.updateTimer(0);
        }
        
        int remainingSeconds = timeInSeconds;
        while(true){
            
            ScheduledFuture<Integer> updatedTime = CountdownTimer.schedule(createTimeUpdater(timeInSeconds, remainingSeconds, timerWindow), 1, TimeUnit.SECONDS);
            //ScheduledFuture<Integer> updatedTime = CountdownTimer.schedule(new TimeUpdater(remainingSeconds, timerWindow), 1, TimeUnit.SECONDS);
            
            try{
                remainingSeconds = updatedTime.get();
                if(remainingSeconds == 0){
                    CountdownTimer.shutdown();
                    //CountdownTimer.awaitTermination(5, TimeUnit.SECONDS);
                    timerWindow.dispose();
                    break;
                }
                else if(((timeInSeconds - 120) == remainingSeconds) && !queueJump){
                    queueJump = true;
                    timeInSeconds += 120;
                    QueueJumpWindow jumpWindow = new QueueJumpWindow();
                    jumpWindow.setVisible(true);
                }
                
            }catch(Exception e){
                System.out.println("Oops");
            }
            
        }
        
    }
    
    protected abstract TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow);
      
}

