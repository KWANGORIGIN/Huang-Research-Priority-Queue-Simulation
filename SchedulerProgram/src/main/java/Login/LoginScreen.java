/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import SchedulingSystem.*;
import ShoppingCart.ShoppingCartWindow;
import Student.Student;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Kevin Wang
 */
public class LoginScreen extends javax.swing.JFrame {
    private SchedulingSystem schedulingSystem;
    
    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
        initComponents();
    }
    
    public LoginScreen(SchedulingSystem schedulingSystem){
        initComponents();
        this.schedulingSystem = schedulingSystem;
        
        usernameTextField.addKeyListener(new KeyAdapter(){
                
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    loginButton.doClick();
                }
            }
            
        });
        
        passwordField.addKeyListener(new KeyAdapter(){
                
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    loginButton.doClick();
                }
            }
            
        });
        
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

        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        usernameLabel.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(93, 114, 0, 0);
        getContentPane().add(usernameLabel, gridBagConstraints);

        passwordLabel.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 114, 0, 0);
        getContentPane().add(passwordLabel, gridBagConstraints);

        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 4, 0, 145);
        getContentPane().add(usernameTextField, gridBagConstraints);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 55;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 130, 145);
        getContentPane().add(loginButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 4, 0, 145);
        getContentPane().add(passwordField, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        if(SchedulingSystem.isAdmin(usernameTextField.getText())){
            //Opens adminWindow to add and remove Courses to the Scheduling System
            AdministratorWindow adminWindow = new AdministratorWindow(schedulingSystem);
            adminWindow.setVisible(true);
        }
        else{
            //Imports or creates workbook students.xlsx depending on if file exists
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            XSSFRow newRow;
            Cell cell;
            
            try(FileInputStream in = new FileInputStream("students.xlsx")){
                workbook = new XSSFWorkbook(in);
                sheet = workbook.getSheet("Student Details");

                in.close();
                System.out.println("Successfully opened students.xlsx");

            }catch(FileNotFoundException e){
                System.out.println("File not found. Creating new file...");

                //Creates a blank workbook and sheet
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Student Details");
                
                //Creates titles for columns
                newRow = sheet.createRow(0);
                cell = newRow.createCell(0);
                cell.setCellValue("Username");
                cell = newRow.createCell(1);
                cell.setCellValue("Login Timestamp");
                cell = newRow.createCell(2);
                cell.setCellValue("Course Added TimeStamp");
                
//                //Resets last inputted row to 0
//                SchedulingSystem.lastInputtedRow = 0;

                System.out.println("Successfully created students.xlsx");
            }catch(IOException e){
                System.out.println("Unknown error opening file.");
            }
            
            //Adds usernameTextField input to student details sheet as entered
            String username = usernameTextField.getText();

            //Creates new Student or imports existing Student
            Student student = new Student();
            int rowPosition = 0;
            try(FileInputStream input = new FileInputStream(username + ".ser")){//attempts to load in existing Student
                try(ObjectInputStream inputStudent = new ObjectInputStream(input)){

                    student = (Student) inputStudent.readObject();
                    
                    rowPosition = student.getRowPosition();
                    
                }
            }catch(FileNotFoundException fileNotFound){//if existing student not found, then creates new student and saves to file
                rowPosition = SchedulingSystem.lastInputtedRow + 1;
                student = new Student(username, rowPosition);
                
                //Saves new Student object
                try(FileOutputStream outputFile = new FileOutputStream(username + ".ser")){
                    try(ObjectOutputStream output = new ObjectOutputStream(outputFile)){
                        output.writeObject(student);
                        System.out.println("Student " + username + " successfully saved.");
                    }
                }catch(FileNotFoundException noFile){
                    System.out.println("File not found");
                }catch(IOException ioException){
                    System.out.println("Error saving to file.");
                }
                
            }catch(ClassNotFoundException classNotFound){
                JOptionPane.showMessageDialog(null, "Error reading Student from file.");
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "Unknown error trying to load in student. File possibly corrupted.");
            }
                
            /*
            Might deprecate
            */
            //Input validation
//            if(!username.matches("[a-z]+/d+")){
//                JOptionPane.showMessageDialog(null, "Invalid username");
//                username = "Invalid Username!";
//            }
            
            
            newRow = sheet.createRow(rowPosition);
            cell = newRow.createCell(0);
            cell.setCellValue(username);

            //Adds timestamp
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String dateTime = dtf.format(now);
            Cell timeCell = newRow.createCell(1);
            timeCell.setCellValue(dateTime);

            //Autosizes columns
            for(int count = 0; count < newRow.getLastCellNum(); count++){
                sheet.autoSizeColumn(count);
            }

            //Saves to file
            try(FileOutputStream out = new FileOutputStream(new File("students.xlsx"))){
                workbook.write(out);
                out.close();

                //Success message
                System.out.println("Succesfully outputted to students.xlsx");
            }catch(FileNotFoundException noFile){
                System.out.println("Unable to create file.");
                /*
                Include Error dialog message asking user if Excel file is open
                
                */
                JOptionPane.showMessageDialog(null, "Error: Unable to write to students.xlsx. Please close students.xlsx if it is currently open.");
                
            }catch(IOException e){
                System.out.println("Error closing fileoutputstream.");
            }

            //Creates ShoppingCartWindow screen
            ShoppingCartWindow cart = new ShoppingCartWindow(student, schedulingSystem);
            cart.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
