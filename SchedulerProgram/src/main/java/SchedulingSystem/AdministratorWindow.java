/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingSystem;

import Login.LoginScreen;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.SwingUtilities;

/**
 * JFrame that acts as the Administrator Window for the program. It allows the user to do several things such as enabling/disabling the timer, 
 * setting the Countdown timer, and the duration of that CountdownTimer.
 * @author Kevin Wang
 */
public class AdministratorWindow extends javax.swing.JFrame {
    private SchedulingSystem schedulingSystem;
    
    /**
     * Creates new form AdministratorWindow
     */
    public AdministratorWindow() {
        initComponents();
    }
    
    /**
     * Constructor to be used for creating a new form AdministratorWindow
     * @param schedulingSystem SchedulingSystem object that is being used throughout the system
     */
    public AdministratorWindow(SchedulingSystem schedulingSystem){
        initComponents();
        this.schedulingSystem = schedulingSystem;
        this.schedulingSystem.enableTimer();
        
        schedulingSystem.setPSU_Icon(this);
        
        ItemListener disableTimerListener = new ItemListener(){
            
            @Override
            public void itemStateChanged(ItemEvent itemEvent){
                int state = itemEvent.getStateChange();
        
                if (state == ItemEvent.SELECTED) {
                    schedulingSystem.disableTimer();
                } else {
                    schedulingSystem.enableTimer();
                }
                
            }
            
        };
        
        disableTimerButton.addItemListener(disableTimerListener);
        
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addCourseButton = new javax.swing.JButton();
        adminWelcomeLabel = new javax.swing.JLabel();
        changeQueueTime = new javax.swing.JButton();
        listAllCoursesButton = new javax.swing.JButton();
        startExperiment = new javax.swing.JButton();
        disableTimerButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addCourseButton.setText("Add Course");
        addCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonActionPerformed(evt);
            }
        });

        adminWelcomeLabel.setFont(new java.awt.Font("Source Code Pro Semibold", 0, 14)); // NOI18N
        adminWelcomeLabel.setText("Welcome Admin. What would you like to do?");

        changeQueueTime.setText("Set Queue Info");
        changeQueueTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeQueueTimeActionPerformed(evt);
            }
        });

        listAllCoursesButton.setText("List all Courses");
        listAllCoursesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAllCoursesButtonActionPerformed(evt);
            }
        });

        startExperiment.setText("Start Experiment");
        startExperiment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startExperimentActionPerformed(evt);
            }
        });

        disableTimerButton.setText("Disable Timer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listAllCoursesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startExperiment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminWelcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changeQueueTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(disableTimerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(adminWelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(addCourseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disableTimerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeQueueTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listAllCoursesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startExperiment)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * (Should not be needed since default courses are currently hardcoded). Opens AddCourseWindow to add a course to the Scheduling System.
     * @param evt 
     */
    private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseButtonActionPerformed
        AddCourseWindow newAddCourseWindow = new AddCourseWindow(schedulingSystem);
        newAddCourseWindow.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_addCourseButtonActionPerformed

    /**
     * Opens SetCountdownWindow to set countdown timer
     * @param evt 
     */
    private void changeQueueTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeQueueTimeActionPerformed
        //Get number of minutes and seconds for Timer countdown
        SetCountdownWindow newCountdownWindow = new SetCountdownWindow(schedulingSystem);
        newCountdownWindow.setVisible(true);
        
        //Closes this administrator window instance
        this.dispose();
        
    }//GEN-LAST:event_changeQueueTimeActionPerformed

    /**
     * Lists all Courses that the scheduling system contains
     * @param evt 
     */
    private void listAllCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAllCoursesButtonActionPerformed
        schedulingSystem.printCourses();
        CourseListWindow courseListWindow = new CourseListWindow(schedulingSystem.getCourses());
        courseListWindow.setVisible(true);
    }//GEN-LAST:event_listAllCoursesButtonActionPerformed

    /**
     * Starts the experiment based off set parameters
     * @param evt 
     */
    private void startExperimentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startExperimentActionPerformed
        
        SwingUtilities.invokeLater(new Runnable(){
            
            public void run(){
                //Creates LoginScreen and makes it visible to user
                LoginScreen loginScreen = new LoginScreen(schedulingSystem);
                loginScreen.setVisible(true);
            }
        
        });
        
        //Closes this administrator window instance
        this.dispose();
    }//GEN-LAST:event_startExperimentActionPerformed

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
            java.util.logging.Logger.getLogger(AdministratorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministratorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministratorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministratorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministratorWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCourseButton;
    private javax.swing.JLabel adminWelcomeLabel;
    private javax.swing.JButton changeQueueTime;
    private javax.swing.JToggleButton disableTimerButton;
    private javax.swing.JButton listAllCoursesButton;
    private javax.swing.JButton startExperiment;
    // End of variables declaration//GEN-END:variables
}
