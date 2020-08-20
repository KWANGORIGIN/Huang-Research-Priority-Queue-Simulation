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
 *
 * @author wanga
 */
public class AdministratorWindow extends javax.swing.JFrame {
    private SchedulingSystem schedulingSystem;
    
    /**
     * Creates new form adminWindow
     */
    public AdministratorWindow() {
        initComponents();
    }
    
    public AdministratorWindow(SchedulingSystem schedulingSystem){
        initComponents();
        this.schedulingSystem = schedulingSystem;
        this.schedulingSystem.enableTimer();
        
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
        removeCourseButton = new javax.swing.JButton();
        adminWelcomeLabel = new javax.swing.JLabel();
        changeQueueTime = new javax.swing.JButton();
        listAllCoursesButton = new javax.swing.JButton();
        startExperiment = new javax.swing.JButton();
        disableTimerButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        addCourseButton.setText("Add Course");
        addCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonActionPerformed(evt);
            }
        });

        removeCourseButton.setText("Remove Course");
        removeCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCourseButtonActionPerformed(evt);
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
                    .addComponent(removeCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(6, 6, 6)
                .addComponent(removeCourseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disableTimerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeQueueTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listAllCoursesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startExperiment)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void removeCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCourseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeCourseButtonActionPerformed

    private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseButtonActionPerformed
        AddCourseWindow newAddCourseWindow = new AddCourseWindow(schedulingSystem);
        newAddCourseWindow.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_addCourseButtonActionPerformed

    private void changeQueueTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeQueueTimeActionPerformed
        //Get number of minutes and seconds for Timer countdown
        SetCountdownWindow newCountdownWindow = new SetCountdownWindow(schedulingSystem);
        newCountdownWindow.setVisible(true);
        
        //Closes this administrator window instance
        this.dispose();
        
    }//GEN-LAST:event_changeQueueTimeActionPerformed

    private void listAllCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAllCoursesButtonActionPerformed
        schedulingSystem.printCourses();
        CourseListWindow courseListWindow = new CourseListWindow(schedulingSystem.getCourses());
        courseListWindow.setVisible(true);
    }//GEN-LAST:event_listAllCoursesButtonActionPerformed

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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
                                        
        //Outputs info to Excel sheet
        
        
    }//GEN-LAST:event_formWindowClosed

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
    private javax.swing.JButton removeCourseButton;
    private javax.swing.JButton startExperiment;
    // End of variables declaration//GEN-END:variables
}
