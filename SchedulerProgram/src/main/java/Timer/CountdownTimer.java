/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timer;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author wanga
 */
public class CountdownTimer {
    
    private final ScheduledExecutorService CountdownTimer = Executors.newScheduledThreadPool(1);
    int timeInSeconds;
    
    CountdownTimer(int timeInSeconds){
       this.timeInSeconds = timeInSeconds;
    }
    
    public void runCountdownTimer(){
        
        int amountOfTime = timeInSeconds;
        while(true){
            
            ScheduledFuture<Integer> updatedTime = CountdownTimer.schedule(new TimeUpdater(amountOfTime), 1, TimeUnit.SECONDS);
            
            try{
                amountOfTime = updatedTime.get();
                if(amountOfTime == 0){
                    CountdownTimer.shutdown();
                    break;
                }
            }catch(Exception e){
                System.out.println("Oops");
            }
            
        }
        
    }
    
    public static void main(String[] args){
        CountdownWindow timerWindow = new CountdownWindow();
        timerWindow.setVisible(true);
        
        CountdownTimer testTimer = new CountdownTimer(5);
        
        
        
        
        
        
    }
    
    
    
    
}

class TimeUpdater implements Callable<Integer>{
    
    private int currentTime;
    TimeUpdater(int currentTime){
        this.currentTime = currentTime;
    }
    
    @Override
    public Integer call() throws Exception{
        System.out.println(currentTime);
        return --currentTime;
    }
    
}