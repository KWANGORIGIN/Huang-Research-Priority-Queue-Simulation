/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

import Course.Course;
import Course.Section;
import SchedulingSystem.SchedulingSystem;
import Student.Student;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * JFrame that displays all available Sections for user to select from
 * @author Kevin Wang
 */
public class CourseInfoWindow extends javax.swing.JFrame{

    private Course currentCourse;
    private Section enrolledSection;
    private Student currentStudent;
    private ShoppingCartWindow shoppingCart;
    private SchedulingSystem schedulingSystem;

    /**
     * Creates new form CourseInfoWindow
     */
    public CourseInfoWindow() {
        initComponents();
    }

    /**
     * Correct constructor to be used to create a new form CourseInfoWindow
     * @param currentCourse
     * @param currentStudent
     * @param shoppingCart
     * @param schedulingSystem 
     */
    public CourseInfoWindow(Course currentCourse, Student currentStudent, ShoppingCartWindow shoppingCart, SchedulingSystem schedulingSystem) {
        initComponents();
        this.currentCourse = currentCourse;
        this.currentStudent = currentStudent;
        this.shoppingCart = shoppingCart;
        this.schedulingSystem = schedulingSystem;
        schedulingSystem.setPSU_Icon(this);
        populate_Table_with_Course_Info();
//        courseTable.setModel(new CourseInfoTable());
        courseTable.getModel().addTableModelListener(new CourseInfoTableListener());
//        populate_Table_with_Course_Info();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        courseTableScrollPane = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        addCourseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(891, 350));
        setPreferredSize(new java.awt.Dimension(891, 350));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Class", "Days", "Time", "Room", "Instructor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        courseTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        courseTable.setInheritsPopupMenu(true);
        courseTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        courseTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        courseTable.setShowGrid(true);
        courseTable.getTableHeader().setReorderingAllowed(false);
        courseTableScrollPane.setViewportView(courseTable);
        if (courseTable.getColumnModel().getColumnCount() > 0) {
            courseTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            courseTable.getColumnModel().getColumn(1).setResizable(false);
            courseTable.getColumnModel().getColumn(2).setResizable(false);
            courseTable.getColumnModel().getColumn(3).setResizable(false);
            courseTable.getColumnModel().getColumn(4).setResizable(false);
            courseTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        addCourseButton.setText("Add Course");
        addCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addCourseButton, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(courseTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                    .addGap(11, 11, 11)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(courseTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Adds course to shopping cart. Countdown timer will run if it is the third course being added.
     * @param evt 
     */
    private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseButtonActionPerformed

        //Gets enrolledSection
        int sectionRow = courseTable.getSelectedRow();//I don't think this gets the row based off checkmark...gotta sort that out
        System.out.println("Section row selected: " + sectionRow);
        if (sectionRow != -1) {//getSelectedRow returns -1 if no row is selected
            enrolledSection = currentCourse.getSection(sectionRow);

            //Add Course to student file
            boolean studentEnrolled = currentStudent.isStudentEnrolledInCourse(currentCourse, enrolledSection);
            if (studentEnrolled) {//If course is already in Shopping Cart
                Runnable r = new Runnable(){
                    @Override
                    public void run(){
                        JOptionPane.showMessageDialog(null, "Error! Course already in Shopping Cart.");
                    }
                };
                
                Thread warning = new Thread(r);
                warning.start();
            } else {
                System.out.println("********Succesfully enrolling student to course********");
                
                if(currentStudent.runTimerCondition() && schedulingSystem.timerEnabled()){
                    Runnable r = new Runnable(){
                        @Override
                        public void run() {
                            schedulingSystem.runTimer(shoppingCart, currentStudent);
                            currentStudent.enrollCourse(currentCourse, enrolledSection);
                        }
                    };

                    Thread t = new Thread(r);
                    t.start();
                }
                else{
                    currentStudent.enrollCourse(currentCourse, enrolledSection);
                }
            }

            //Close window
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_addCourseButtonActionPerformed

    /**
     * Event listener that handles when the JFrame is being closed. It ensures the ShoppingCart updates the enrolled courses and saves the data about the Student to its file.
     * @param evt 
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
        this.shoppingCart.printStudentEnrolledCourses();
        
        //Updates student file
        try (FileOutputStream outputFile = new FileOutputStream(currentStudent.getUsername() + ".ser")) {
            try (ObjectOutputStream output = new ObjectOutputStream(outputFile)) {
                output.writeObject(currentStudent);
                System.out.println("Student " + currentStudent.getUsername() + " successfully saved.");
            }
        } catch (FileNotFoundException noFile) {
            System.out.println("File not found");
        } catch (IOException ioException) {
            System.out.println("Error saving to file.");
            ioException.printStackTrace();
            System.out.println(ioException.getMessage());    
        }

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
            java.util.logging.Logger.getLogger(CourseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseInfoWindow().setVisible(true);
            }
        });
    }

    /**
     * Fills the table with all the Sections and their info for the particular Course
     */
    protected void populate_Table_with_Course_Info() {
//        CourseInfoTable model = (CourseInfoTable) courseTable.getModel();
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        this.setTitle(currentCourse.getDeptName() + "- " + currentCourse.getCourseName());
        
        for (int count = 0; count < currentCourse.getNumOfSections(); count++) {
            Object courseRow[] = new Object[6];
            courseRow[0] = false;
            courseRow[1] = currentCourse.getSection(count).getSectionName();
            courseRow[2] = currentCourse.getSection(count).getDays();
            courseRow[3] = currentCourse.getSection(count).getTime();
            courseRow[4] = currentCourse.getSection(count).getRoom();
            courseRow[5] = currentCourse.getSection(count).getInstructor();
            model.addRow(courseRow);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCourseButton;
    private javax.swing.JTable courseTable;
    private javax.swing.JScrollPane courseTableScrollPane;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
