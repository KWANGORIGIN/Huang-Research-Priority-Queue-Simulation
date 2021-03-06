/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingSystem;

import QueueInfo.CountdownTimer;
import QueueInfo.NoInfoTimer;
import QueueInfo.QueuePositionTimer;
import QueueInfo.TimeInfoTimer;
import java.awt.event.WindowEvent;

/**
 * JFrame that is used to set the countdown timer
 * @author Kevin Wang
 */
public class SetCountdownWindow extends javax.swing.JFrame {
    private SchedulingSystem schedulingSystem;
    CountdownTimer timer;
    int numOfMinutesTimer, numOfMinutesQueueJump;
    
    /**
     * Creates new form SetCountdownWindow
     */
    public SetCountdownWindow() {
        initComponents();
        timer = null;
    }
    
    public SetCountdownWindow(SchedulingSystem schedulingSystem){
        initComponents();
        this.schedulingSystem = schedulingSystem;
        timer = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        minutesLabel = new javax.swing.JLabel();
        minutesTextField = new javax.swing.JTextField();
        setTimer = new javax.swing.JButton();
        timerCheckbox = new javax.swing.JCheckBox();
        positionCheckbox = new javax.swing.JCheckBox();
        noInfoCheckbox = new javax.swing.JCheckBox();
        jumpTimeLabel = new javax.swing.JLabel();
        jumpTimeTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        minutesLabel.setText("Minutes/Queue Position:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(135, 88, 0, 0);
        getContentPane().add(minutesLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 72;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(132, 4, 0, 0);
        getContentPane().add(minutesTextField, gridBagConstraints);

        setTimer.setText("Set");
        setTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTimerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 62, 0);
        getContentPane().add(setTimer, gridBagConstraints);

        timerCheckbox.setText("Timer");
        timerCheckbox.setBorderPaintedFlat(true);
        timerCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerCheckboxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 0, 0);
        getContentPane().add(timerCheckbox, gridBagConstraints);

        positionCheckbox.setText("Queue Position");
        positionCheckbox.setBorderPaintedFlat(true);
        positionCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionCheckboxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 127);
        getContentPane().add(positionCheckbox, gridBagConstraints);

        noInfoCheckbox.setText("No Info");
        noInfoCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noInfoCheckboxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(noInfoCheckbox, gridBagConstraints);

        jumpTimeLabel.setText("Time until Queue Jump:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 93, 0, 0);
        getContentPane().add(jumpTimeLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 72;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 4, 0, 0);
        getContentPane().add(jumpTimeTextField, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTimerActionPerformed

        if(timer != null){
            schedulingSystem.setTimer(timer);

            AdministratorWindow adminWindow = new AdministratorWindow(schedulingSystem);
            adminWindow.setVisible(true);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_setTimerActionPerformed

    private void timerCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerCheckboxActionPerformed
        setTimerDuration();
        
        if(positionCheckbox.isSelected()){
            positionCheckbox.setSelected(false);
        }
        
        if(noInfoCheckbox.isSelected()){
            noInfoCheckbox.setSelected(false);
        }
        
        timer = new TimeInfoTimer(numOfMinutesTimer, numOfMinutesQueueJump);
        
    }//GEN-LAST:event_timerCheckboxActionPerformed

    private void positionCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionCheckboxActionPerformed
        setTimerDuration();
        
        if(timerCheckbox.isSelected()){
            timerCheckbox.setSelected(false);
        }
        
        if(noInfoCheckbox.isSelected()){
            noInfoCheckbox.setSelected(false);
        }
        
        timer = new QueuePositionTimer(numOfMinutesTimer, numOfMinutesQueueJump);
        
    }//GEN-LAST:event_positionCheckboxActionPerformed

    private void noInfoCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noInfoCheckboxActionPerformed
        setTimerDuration();
        
        if(positionCheckbox.isSelected()){
            positionCheckbox.setSelected(false);
        }
        
        if(timerCheckbox.isSelected()){
            timerCheckbox.setSelected(false);
        }
        
        timer = new NoInfoTimer(numOfMinutesTimer, numOfMinutesQueueJump);
        
    }//GEN-LAST:event_noInfoCheckboxActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
//        AdministratorWindow adminWindow = new AdministratorWindow(schedulingSystem);
//        adminWindow.setVisible(true);
    }//GEN-LAST:event_formWindowClosed
    
    void setTimerDuration(){
        numOfMinutesTimer = Integer.parseInt(minutesTextField.getText());
        numOfMinutesQueueJump = Integer.parseInt(jumpTimeTextField.getText());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SetCountdownWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetCountdownWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetCountdownWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetCountdownWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetCountdownWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jumpTimeLabel;
    private javax.swing.JTextField jumpTimeTextField;
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JTextField minutesTextField;
    private javax.swing.JCheckBox noInfoCheckbox;
    private javax.swing.JCheckBox positionCheckbox;
    private javax.swing.JButton setTimer;
    private javax.swing.JCheckBox timerCheckbox;
    // End of variables declaration//GEN-END:variables
}
