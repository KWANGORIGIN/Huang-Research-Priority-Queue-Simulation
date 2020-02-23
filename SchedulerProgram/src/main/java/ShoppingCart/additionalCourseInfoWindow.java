/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

import Course.Course;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wanga
 */
public class additionalCourseInfoWindow extends javax.swing.JFrame {

    /**
     * Creates new form additionalCourseInfoWindow
     */
    public additionalCourseInfoWindow() {
        initComponents();
        populate_Table_with_Courses();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(891, 300));

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Section", "Starting Date", "Room", "Instructor"
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
        courseTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        courseTable.setInheritsPopupMenu(true);
        courseTable.setSelectionBackground(new java.awt.Color(0, 51, 102));
        courseTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        courseTable.setShowGrid(true);
        courseTable.getTableHeader().setReorderingAllowed(false);
        courseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseTableMouseClicked(evt);
            }
        });
        courseTableScrollPane.setViewportView(courseTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 893, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(courseTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                    .addGap(11, 11, 11)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(courseTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void courseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTableMouseClicked
        //TODO
    }//GEN-LAST:event_courseTableMouseClicked

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
            java.util.logging.Logger.getLogger(additionalCourseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(additionalCourseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(additionalCourseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(additionalCourseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new additionalCourseInfoWindow().setVisible(true);
            }
        });
    }
    
    protected void populate_Table_with_Courses(){
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        Course newCourse = new Course("CMPSC 121", 1, "Dr. Someone");
        Object courseRow[] = new Object[5];
        courseRow[0] = newCourse.getCourseName();
        courseRow[1] = 001;
        courseRow[2] = "Date";
        courseRow[3] = newCourse.getRoomNum();
        courseRow[4] = newCourse.getInstructor();
        model.addRow(courseRow);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable courseTable;
    private javax.swing.JScrollPane courseTableScrollPane;
    // End of variables declaration//GEN-END:variables
}