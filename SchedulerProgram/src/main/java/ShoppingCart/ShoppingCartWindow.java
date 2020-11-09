/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

import SchedulingSystem.SchedulingSystem;
import javax.swing.table.DefaultTableModel;
import Course.Course;
import Student.Student;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author wanga
 */
public class ShoppingCartWindow extends javax.swing.JFrame {
    private Student student;
    SchedulingSystem schedulingSystem;
    
    public ShoppingCartWindow(){
        initComponents();
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        
        String iconPath = "C:/Users/wanga/Documents/NetBeansProjects/Dynamic-queue-scheduler/SchedulerProgram/src/main/resources/psuIcon.jpg";
//        String iconPath = getClass().getResource("/psuIcon.jpg").toString();
//        System.out.println(iconPath);
        
        Image icon = Toolkit.getDefaultToolkit().getImage(iconPath);
        this.setIconImage(icon);
        
//        enrolledCoursesTable.setRowHeight(0, 32);
        
    }
    
    public ShoppingCartWindow(SchedulingSystem schedulingSystem){
        initComponents();
        //printStudentEnrolledCourses();
        this.schedulingSystem = schedulingSystem;
    }
    
    /**
     * Creates new form ShoppingCart
     * @param student
     * @param schedulingSystem
     */
    public ShoppingCartWindow(Student student, SchedulingSystem schedulingSystem){
        initComponents();
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        
        this.student = student;
        this.schedulingSystem = schedulingSystem;
        
        searchbar.addKeyListener(new KeyAdapter(){//Anonymous inner class
            
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    searchButton.doClick();
                }
            }
            
        });
        
        enrollButton.setEnabled(false);//Disables JButton
        
        Runnable buttonEnabler = new Runnable(){
            @Override
            public void run(){
                while(student.numOfEnrolledCourses() != 5){
//                    System.out.println("Not Enabled yet");
                }
                enrollButton.setEnabled(true);
            }
        };
        
        Thread buttonThread = new Thread(buttonEnabler);
        buttonThread.start();
        
        schedulingSystem.setPSU_Icon(this);
        printStudentEnrolledCourses();
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

        invalidCourseNameDialogWindow = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        shoppingCartTable = new javax.swing.JScrollPane();
        enrolledCoursesTable = new javax.swing.JTable();
        searchbar = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        enrollButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("\"Invalid course name!\"");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout invalidCourseNameDialogWindowLayout = new javax.swing.GroupLayout(invalidCourseNameDialogWindow.getContentPane());
        invalidCourseNameDialogWindow.getContentPane().setLayout(invalidCourseNameDialogWindowLayout);
        invalidCourseNameDialogWindowLayout.setHorizontalGroup(
            invalidCourseNameDialogWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invalidCourseNameDialogWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        invalidCourseNameDialogWindowLayout.setVerticalGroup(
            invalidCourseNameDialogWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invalidCourseNameDialogWindowLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        enrolledCoursesTable.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        enrolledCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Days", "Time", "Room", "Instructor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enrolledCoursesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        enrolledCoursesTable.setInheritsPopupMenu(true);
        enrolledCoursesTable.setRowHeight(32);
        enrolledCoursesTable.setSelectionBackground(java.awt.SystemColor.textHighlightText);
        enrolledCoursesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        enrolledCoursesTable.setShowGrid(true);
        enrolledCoursesTable.getTableHeader().setReorderingAllowed(false);
        enrolledCoursesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrolledCoursesTableMouseClicked(evt);
            }
        });
        shoppingCartTable.setViewportView(enrolledCoursesTable);
        if (enrolledCoursesTable.getColumnModel().getColumnCount() > 0) {
            enrolledCoursesTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1506;
        gridBagConstraints.ipady = 449;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        getContentPane().add(shoppingCartTable, gridBagConstraints);

        searchbar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        searchbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 426;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        getContentPane().add(searchbar, gridBagConstraints);
        searchbar.getAccessibleContext().setAccessibleName("");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
        getContentPane().add(searchButton, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        enrollButton.setText("Enroll");
        enrollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 544;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 10);
        jPanel1.add(enrollButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 74, 16, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void enrolledCoursesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrolledCoursesTableMouseClicked
        
        //Deprecated. Misunderstood original requirements
//        if(evt.getClickCount() == 2){//If double click on a row
//            JTable target = (JTable) evt.getSource();
//            int row = target.getSelectedRow();
//            System.out.println("Row Selected: " + row);//for debugging
//            
//            //Opens up new window with additional course information
//            new CourseInfoWindow().setVisible(true);
//            
//        }
        
        
    }//GEN-LAST:event_enrolledCoursesTableMouseClicked

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        //CountdownTimer timer = schedulingSystem.getTimer();
        
        String searchInput = searchbar.getText();
        if(searchInput.matches("[A-Za-z]+\\s\\d+[A-Za-z]*")){//Space between course name and number(#): courseName #
            Course searchedCourse = schedulingSystem.getCourse(searchInput.toUpperCase());
            //System.out.println(searchedCourse.getCourseName());
            if(searchedCourse == null){
                JOptionPane.showMessageDialog(null, "Invalid course name.");
            }
            else{
               
               ShoppingCartWindow windowRef = this;
               SwingUtilities.invokeLater(new Runnable(){
                   
                   public void run(){
                       CourseInfoWindow courseWindow = new CourseInfoWindow(searchedCourse, student, windowRef, schedulingSystem);
                       courseWindow.setVisible(true); 
//                       windowRef.dispose();
                   }
                   
               });
               
            }
        }
        else if(searchInput.matches("[A-Za-z]+\\d+[A-Za-z]*")){//No space between course name and number(#): courseName#
            //Add space between courseName and number
            for(int count = 0; count < searchInput.length(); count++){
                if(Character.isDigit(searchInput.charAt(count))){
                    StringBuilder tempString = new StringBuilder(searchInput);
                    tempString.insert(count, ' ');
                    searchInput = tempString.toString();
                    break;
                }
            }
            
            Course searchedCourse = schedulingSystem.getCourse(searchInput.toUpperCase());
            if(searchedCourse == null){
                JOptionPane.showMessageDialog(null, "Invalid course name.");
            }
            else{
               CourseInfoWindow courseWindow = new CourseInfoWindow(searchedCourse, student, this, schedulingSystem);
               courseWindow.setVisible(true); 
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid course name.");
        }
        
        //Clears searchbar
        searchbar.setText("");
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarActionPerformed

    private void enrollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollButtonActionPerformed
        
        ThankYouWindow thankYouWindow = new ThankYouWindow(schedulingSystem);
        thankYouWindow.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_enrollButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ShoppingCartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShoppingCartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShoppingCartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShoppingCartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShoppingCartWindow().setVisible(true);
            }
        });
    }
    
    public void printStudentEnrolledCourses(){
        DefaultTableModel model = (DefaultTableModel) enrolledCoursesTable.getModel();
        System.out.println("Num of enrolled courses: " + student.numOfEnrolledCourses());
        model.setRowCount(0);//This initializes the number of rows to 0 in case updating rows in table. Essentially clears jTable data
        student.printEnrolledCoursesToTable(model);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enrollButton;
    private javax.swing.JTable enrolledCoursesTable;
    private javax.swing.JDialog invalidCourseNameDialogWindow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchbar;
    private javax.swing.JScrollPane shoppingCartTable;
    // End of variables declaration//GEN-END:variables
}
