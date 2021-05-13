/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueInfo;

import javax.swing.JTextPane;

/**
 * CountdownTimer for when Timer option is selected in SetCountdownWindow
 * @author Kevin Wang
 */
public class TimeInfoTimer extends CountdownTimer {

    public TimeInfoTimer(int timeInMinutes, int timeToJump) {
        super(timeInMinutes, timeToJump);
    }

    public static void main(String[] args) {
//        CountdownWindow timerWindow = new CountdownWindow();
//        timerWindow.setVisible(true);

//        CountdownTimer testTimer = new TimeInfoTimer(3, 2);
//        testTimer.runCountdownTimer();
    }

    @Override
    protected TimeUpdater createTimeUpdater(int initialTimeInSeconds, int remainingSeconds, CountdownWindow timerWindow) {
        return new TimeInfoUpdater(initialTimeInSeconds, remainingSeconds, timerWindow);
    }

    @Override
    void updateTimerDisplay(Integer currentTime, JTextPane timerDisplay) {
        String fontFamily = timerDisplay.getFont().getFamily();
        timerDisplay.setText("<body style=\"font-size: 18px\";\"font-family: " + fontFamily + "\"<body> Due to some seniors that are considering the course,<br><br>there will be a delay of about " + "<b><u>" + currentTime.toString() + " minute(s)</u></b>.</body>");

    }
    
    @Override
    void setQueueJumpDisplay(Integer currentTime, JTextPane queueJumpDisplay){
        String fontFamily = queueJumpDisplay.getFont().getFamily();
        queueJumpDisplay.setText("<body style=\"font-size: 18px\";\"font-family: " + fontFamily + "\"<body> Due to a new senior in the system that is considering the same course,<br><br> there will be a delay of about <b><u>" + currentTime.toString() + " minute(s)</b></u>.<br><br>Thank you for your patience.</body>");
    }

}
