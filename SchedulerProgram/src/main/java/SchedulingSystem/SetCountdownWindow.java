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
 *
 * @author wanga
 */
public class SetCountdownWindow extends javax.swing.JFrame {
    private SchedulingSystem schedulingSystem;
    CountdownTimer timer;
    int numOfMinutes;
    
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

        minutesLabel = new javax.swing.JLabel();
        minutesTextField = new javax.swing.JTextField();
        setTimer = new javax.swing.JButton();
        timerCheckbox = new javax.swing.JCheckBox();
        positionCheckbox = new javax.swing.JCheckBox();
        noInfoCheckbox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        minutesLabel.setText("Minutes/Queue Position:");

        setTimer.setText("Set");
        setTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTimerActionPerformed(evt);
            }
        });

        timerCheckbox.setText("Timer");
        timerCheckbox.setBorderPaintedFlat(true);
        timerCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerCheckboxActionPerformed(evt);
            }
        });

        positionCheckbox.setText("Queue Position");
        positionCheckbox.setBorderPaintedFlat(true);
        positionCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionCheckboxActionPerformed(evt);
            }
        });

        noInfoCheckbox.setText("No Info");
        noInfoCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noInfoCheckboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(minutesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noInfoCheckbox)
                    .addComponent(positionCheckbox)
                    .addComponent(setTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timerCheckbox)
                    .addComponent(minutesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minutesLabel)
                    .addComponent(minutesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timerCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(positionCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noInfoCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setTimer)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTimerActionPerformed
        numOfMinutes = Integer.parseInt(minutesTextField.getText());
        if(timer != null){
            schedulingSystem.setTimer(timer);

            AdministratorWindow adminWindow = new AdministratorWindow(schedulingSystem);
            adminWindow.setVisible(true);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_setTimerActionPerformed

    private void timerCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerCheckboxActionPerformed
        
        if(positionCheckbox.isSelected()){
            positionCheckbox.setSelected(false);
        }
        
        if(noInfoCheckbox.isSelected()){
            noInfoCheckbox.setSelected(false);
        }
        
        timer = new TimeInfoTimer(numOfMinutes);
        
    }//GEN-LAST:event_timerCheckboxActionPerformed

    private void positionCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionCheckboxActionPerformed
        
        if(timerCheckbox.isSelected()){
            timerCheckbox.setSelected(false);
        }
        
        if(noInfoCheckbox.isSelected()){
            noInfoCheckbox.setSelected(false);
        }
        
        timer = new QueuePositionTimer(numOfMinutes);
        
    }//GEN-LAST:event_positionCheckboxActionPerformed

    private void noInfoCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noInfoCheckboxActionPerformed
        if(positionCheckbox.isSelected()){
            positionCheckbox.setSelected(false);
        }
        
        if(timerCheckbox.isSelected()){
            timerCheckbox.setSelected(false);
        }
        
        timer = new NoInfoTimer(numOfMinutes);
        
    }//GEN-LAST:event_noInfoCheckboxActionPerformed

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
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JTextField minutesTextField;
    private javax.swing.JCheckBox noInfoCheckbox;
    private javax.swing.JCheckBox positionCheckbox;
    private javax.swing.JButton setTimer;
    private javax.swing.JCheckBox timerCheckbox;
    // End of variables declaration//GEN-END:variables
}
