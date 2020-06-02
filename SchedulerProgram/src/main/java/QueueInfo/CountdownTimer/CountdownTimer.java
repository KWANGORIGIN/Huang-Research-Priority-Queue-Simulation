/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo.CountdownTimer;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;
/**
 *
 * @author wanga
 */
public class CountdownTimer {
    
    private ScheduledExecutorService CountdownTimer; 
    private int timeInSeconds;
    private int timeInMinutes;
    
    public CountdownTimer(int timeInMinutes){
       this.timeInMinutes = timeInMinutes;
       this.timeInSeconds = timeInMinutes * 60;
    }
    
    public void runCountdownTimer(){
        
        CountdownTimer = Executors.newScheduledThreadPool(1);
        
        CountdownWindow timerWindow = new CountdownWindow();
        timerWindow.setVisible(true);
        int remainingSeconds = timeInSeconds;
        int remainingMinutes = timeInMinutes;
        while(true){
            
            ScheduledFuture<Integer> updatedTime = CountdownTimer.schedule(new TimeUpdater(remainingSeconds, timerWindow), 1, TimeUnit.SECONDS);
            
            try{
                remainingSeconds = updatedTime.get();
                if(remainingSeconds == 0){
                    CountdownTimer.shutdown();
                    //CountdownTimer.awaitTermination(5, TimeUnit.SECONDS);
                    timerWindow.dispose();
                    break;
                }
            }catch(Exception e){
                System.out.println("Oops");
            }
            
        }
        
    }
    
    public static void main(String[] args){
//        CountdownWindow timerWindow = new CountdownWindow();
//        timerWindow.setVisible(true);
        
        CountdownTimer testTimer = new CountdownTimer(2);
        testTimer.runCountdownTimer();
        
    }
    
    class TimeUpdater implements Callable<Integer>{
        private int currentSeconds;
        private int currentMinutes;
        private CountdownWindow timerWindow;
        TimeUpdater(int remainingSeconds, CountdownWindow timerWindow){
            this.currentSeconds = remainingSeconds;
            this.currentMinutes = remainingSeconds / 60;
            this.timerWindow = timerWindow;
        }

        @Override
        public Integer call() throws Exception{
            System.out.println("Updated timer with current second: " + currentSeconds + " at time: " + LocalDateTime.now().toString());
            if(currentSeconds % 60 == 0){//Updates timerWindow every minute
                timerWindow.updateTimer(currentMinutes);
            }
            return --currentSeconds;
        }

    }
    
    
}

