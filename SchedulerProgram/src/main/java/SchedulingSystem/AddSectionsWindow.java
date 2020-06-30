/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingSystem;

import Course.Course;
import Course.Section;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author wanga
 */
public class AddSectionsWindow extends javax.swing.JFrame {
    private Course workingCourse;
    private int numOfSections;
    private int currentSectionNum;
    private SchedulingSystem schedulingSystem;
    
    /**
     * Creates new form addLectureWindow
     */
    public AddSectionsWindow() {
        initComponents();
    }
    
    public AddSectionsWindow(Course newCourse, int numOfSections, SchedulingSystem schedulingSystem){
        initComponents();
        workingCourse = newCourse;
        this.numOfSections = numOfSections;
        currentSectionNum = 1;
        currentSection.setText("Current Section Num being added: " + currentSectionNum + " out of " + numOfSections + " Sections.");
        this.schedulingSystem = schedulingSystem;
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

        sectionNameLabel = new javax.swing.JLabel();
        sectionNameTextField = new javax.swing.JTextField();
        daysLabel = new javax.swing.JLabel();
        addSectionButton = new javax.swing.JButton();
        daysTextField = new javax.swing.JTextField();
        roomLabel = new javax.swing.JLabel();
        roomTextField = new javax.swing.JTextField();
        instructorLabel = new javax.swing.JLabel();
        instructorTextField = new javax.swing.JTextField();
        currentSection = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        timeTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        sectionNameLabel.setText("Section Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 205, 0, 0);
        getContentPane().add(sectionNameLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 93;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 20, 0, 204);
        getContentPane().add(sectionNameTextField, gridBagConstraints);

        daysLabel.setText("Days:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 205, 0, 0);
        getContentPane().add(daysLabel, gridBagConstraints);

        addSectionButton.setText("Add Section");
        addSectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSectionButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 31, 64, 204);
        getContentPane().add(addSectionButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 151;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 0, 204);
        getContentPane().add(daysTextField, gridBagConstraints);

        roomLabel.setText("Room:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 205, 0, 0);
        getContentPane().add(roomLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 147;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 4, 0, 204);
        getContentPane().add(roomTextField, gridBagConstraints);

        instructorLabel.setText("Instructor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 205, 0, 0);
        getContentPane().add(instructorLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 126;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 4, 0, 204);
        getContentPane().add(instructorTextField, gridBagConstraints);

        currentSection.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.ipadx = 155;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(86, 205, 0, 204);
        getContentPane().add(currentSection, gridBagConstraints);

        timeLabel.setText("Time:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 205, 0, 0);
        getContentPane().add(timeLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 152;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 3, 0, 204);
        getContentPane().add(timeTextField, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addSectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSectionButtonActionPerformed
        /*Insert info
        Then clear data as many times as there are sections and update counter so that I know how many more sections to add data for
        */
        
        //Updates which section number the admin is currently adding to the working course
        currentSection.setText("Current Section Num being added: " + (currentSectionNum + 1) + " out of " + numOfSections + " Sections.");

        //Gets info
        String sectionName = sectionNameTextField.getText();
        String days = daysTextField.getText();
        String time = timeTextField.getText();
        String room = roomTextField.getText();
        String instructor = instructorTextField.getText();

        Section newSection = new Section(sectionName, days, time, room, instructor);
        workingCourse.addSection(newSection);

        //Clears inputs
        sectionNameTextField.setText("");
        daysTextField.setText("");
        timeTextField.setText("");
        roomTextField.setText("");
        instructorTextField.setText("");
        currentSectionNum++;
        
        if(currentSectionNum > numOfSections){
            //Add Course to Scheduling System
            schedulingSystem.addCourse(workingCourse);
            //Close window
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_addSectionButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //Outputs scheduling system to file
        
        try(FileOutputStream outputFile = new FileOutputStream("SchedulingSystem.ser")){
            try(ObjectOutputStream output = new ObjectOutputStream(outputFile)){
                output.writeObject(schedulingSystem);
                System.out.println("Changes from this session have been saved.");
            }
            
        }catch(FileNotFoundException fileNotFound){
            System.out.println("File not found");
        }catch(IOException ioException){
            System.out.println("Error saving to file.");
        }
        
        AdministratorWindow adminWindow = new AdministratorWindow(schedulingSystem);
        adminWindow.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(AddSectionsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSectionsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSectionsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSectionsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSectionsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSectionButton;
    private javax.swing.JLabel currentSection;
    private javax.swing.JLabel daysLabel;
    private javax.swing.JTextField daysTextField;
    private javax.swing.JLabel instructorLabel;
    private javax.swing.JTextField instructorTextField;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JTextField roomTextField;
    private javax.swing.JLabel sectionNameLabel;
    private javax.swing.JTextField sectionNameTextField;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField timeTextField;
    // End of variables declaration//GEN-END:variables
}
