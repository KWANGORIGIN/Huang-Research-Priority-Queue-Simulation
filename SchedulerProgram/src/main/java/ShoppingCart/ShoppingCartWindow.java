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
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author wanga
 */
public class ShoppingCartWindow extends javax.swing.JFrame {
    private Student student;
    SchedulingSystem schedulingSystem;
    
    public ShoppingCartWindow(){
        initComponents();
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
        this.student = student;
        this.schedulingSystem = schedulingSystem;
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

        invalidCourseNameDialogWindow = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        shoppingCartTable = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchbar = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Date/Time", "Room", "Instructor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setInheritsPopupMenu(true);
        jTable1.setSelectionBackground(java.awt.SystemColor.textHighlightText);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        shoppingCartTable.setViewportView(jTable1);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shoppingCartTable, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shoppingCartTable, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        searchbar.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
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
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        String searchInput = searchbar.getText();
        if(searchInput.matches("[A-Za-z]+\\s\\d+")){//Space between course name and number(#): courseName #
            Course searchedCourse = schedulingSystem.getCourse(searchInput.toUpperCase());
            //System.out.println(searchedCourse.getCourseName());
            if(searchedCourse == null){
                JOptionPane.showMessageDialog(null, "Invalid course name.");
            }
            else{
               CourseInfoWindow courseWindow = new CourseInfoWindow(searchedCourse, student, this);
               courseWindow.setVisible(true); 
            }
        }
        else if(searchInput.matches("[A-Za-z]+\\d+")){//No space between course name and number(#): courseName#
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
               CourseInfoWindow courseWindow = new CourseInfoWindow(searchedCourse, student, this);
               courseWindow.setVisible(true); 
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid course name.");
        }
        
    }//GEN-LAST:event_searchButtonActionPerformed

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
    
    protected void printStudentEnrolledCourses(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        System.out.println(student.numOfEnrolledCourses());
        model.setRowCount(0);//This initializes the number of rows to 0 in case updating rows in table. Essentially clears jTable data
        
        for(int count = 0; count < student.numOfEnrolledCourses(); count++){
            Course tempCourse = student.getEnrolledCourse(count);
            System.out.println(tempCourse.getCourseName());
            Object courseRow[] = new Object[4];
            courseRow[0] = tempCourse.getDeptName();
            courseRow[1] = student.getEnrolledSection(count).getDays() + "          " + student.getEnrolledSection(count).getTime();//Change spacing later
            courseRow[2] = student.getEnrolledSection(count).getRoom();
            courseRow[3] = student.getEnrolledSection(count).getInstructor();
            model.addRow(courseRow);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog invalidCourseNameDialogWindow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchbar;
    private javax.swing.JScrollPane shoppingCartTable;
    // End of variables declaration//GEN-END:variables
}
