/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author wanga
 */
public class noInfoTimer extends CountdownTimer {
    
    public noInfoTimer(int timeInMinutes){
        super(timeInMinutes);
    }
    
    public static void main(String[] args){
        CountdownTimer testTimer = new noInfoTimer(2);
        testTimer.runCountdownTimer();
    }
    
    @Override
    public void runCountdownTimer(){
        
        CountdownTimer = Executors.newScheduledThreadPool(1);
        
        CountdownWindow timerWindow = new CountdownWindow(this);
        timerWindow.setVisible(true);
        timerWindow.updateTimer(0);
        
        int remainingSeconds = timeInSeconds;
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
    
    class TimeUpdater implements Callable<Integer>{
        private int currentSeconds;
        private int currentMinutes;
        private CountdownWindow timerWindow;
        TimeUpdater(int remainingSeconds, CountdownWindow timerWindow){
            this.currentSeconds = remainingSeconds;
            this.currentMinutes = remainingSeconds / 60;
            this.timerWindow = timerWindow;
        }
        
        TimeUpdater(int remainingSeconds){
            this.currentSeconds = remainingSeconds;
            this.currentMinutes = remainingSeconds / 60;
        }

        @Override
        public Integer call() throws Exception{
            System.out.println("Updated timer with current second: " + currentSeconds + " at time: " + LocalDateTime.now().toString());
            if(currentSeconds % 60 == 0){
                
                if(timeInSeconds != currentSeconds){
                    /*
                    Current Issue with this implementation: seconds are not counting down until user hits "Ok" in the message dialog.
                    Probably going to have to resolve with opening another window on another thread
                    */
                    JOptionPane.showMessageDialog(timerWindow, "Thank you for your patience.", "Update", 1);
                }
                
            }
            return --currentSeconds;
        }

    }
    
}
