/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingSystem;

import java.util.ArrayList;
import Course.Course;
import Course.Section;
import Student.Student;
import java.io.Serializable;
import QueueInfo.CountdownTimer;
import ShoppingCart.ShoppingCartWindow;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author wanga
 */
public class SchedulingSystem implements Serializable {

    private final ArrayList<Course> availableCourses;
    private static ArrayList<Student> systemUsers;
    private static String adminUsername;
    public static int lastInputtedRow;//Maybe get rid of? Just write to new row regardless? To avoid overwriting
    private CountdownTimer countdownTimer;
    private Student currentStudent;
    private boolean enableTimer;

    //No-argument constructor
    public SchedulingSystem() {
        availableCourses = new ArrayList<>();
        systemUsers = new ArrayList<>();
        adminUsername = "administrator";
        lastInputtedRow = 0;
        enableTimer();

        //Default 5 courses
        Course stressManagement = new Course("KINES 82", "Actions Methods for Stress Management");
        Section stressManagement_Section = new Section("001 LEC-Regular", "MoWe", "11:00 AM - 12:00 PM", "Nick 156", "Joseph Tristan");
        Section stressManagement_Section2 = new Section("002 LEC-Regular", "TuTh", "11:00 AM - 12:00 PM", "Nick 156", "Joseph Tristan");
        Section stressManagement_Section3 = new Section("003 LEC-Regular", "WeFr", "12:00 PM - 1:00 PM", "Nick 156", "Allen Urich");
        Section stressManagement_Section4 = new Section("004 Lec-Regular", "TuFr", "2:00 PM - 3:00 PM", "Nick 156", "Andrea Randolph");
        
        stressManagement.addSection(stressManagement_Section);
        stressManagement.addSection(stressManagement_Section2);
        stressManagement.addSection(stressManagement_Section3);
        stressManagement.addSection(stressManagement_Section4);
        
        Course materialScience = new Course("MATSE 259", "Properties and Processing of Engineering Materials");
        Section materialScience_Section = new Section("001 LEC-Regular", "TuTh", "10:35 AM - 11:50 AM", "AMIC 121", "Xiawa Wu");
        Section materialScience_Section2 = new Section("002 LEC-Regular", "TuTh", "12:05 PM - 1:20 PM", "AMIC 121", "Xiawa Wu");
        Section materialScience_Section3 = new Section("003 LEC-Regular", "MoWe", "1:00 PM - 2:00 PM", "AMIC 176", "Todd Palmer");
        
        materialScience.addSection(materialScience_Section);
        materialScience.addSection(materialScience_Section2);
        materialScience.addSection(materialScience_Section3);
        
        Course englishCourse = new Course("ENGL 202C", "Effective Writing: Technical Writing");
        Section englishCourse_Section = new Section("001-LEC Regular", "MoWeFr", "8:00 AM - 8:50 AM", "Nick 152", "Tammie Merino");
        Section englishCourse_Section2 = new Section("002-LEC Regular", "TuTh", "3:00 PM - 4:50 PM", "Nick 152", "Tammie Merino");
        Section englishCourse_Section3 = new Section("003-LEC Regular", "MoWeFr", "2:30 PM - 3:20 PM", "Nick 156", "Sharon Gallagher");
        
        englishCourse.addSection(englishCourse_Section);
        englishCourse.addSection(englishCourse_Section2);
        englishCourse.addSection(englishCourse_Section3);

        Course industrialEngineering = new Course("IE 405", "Deterministic Models in Operations Research");
        Section industrialEngineering_Section = new Section("001-LEC Regular", "MoWeFr", "11:15 AM - 12:05 PM", "AMIC 208", "Hsin-Li Chan");
        Section industrialEngineering_Section2 = new Section("002-LEC Regular", "TuTh", "10:35 AM - 11:50 AM", "AMIC 206", "Sarah Root");
        
        industrialEngineering.addSection(industrialEngineering_Section);
        industrialEngineering.addSection(industrialEngineering_Section2);

        Course compSci = new Course("CMPSC 121", "Introduction to Programming Techniques");
        Section compSci_Section = new Section("001-LEC Regular", "MoWe", "12:20 PM - 1:10 PM", "Reed Building 026", "Teck Meng Liaw");
        Section compSci_Section2 = new Section("002-LEC Regular", "MoWe", "3:35 PM - 4:25 PM", "Reed Building 117", "Thomas Rossi");
        
        compSci.addSection(compSci_Section);
        compSci.addSection(compSci_Section2);

        availableCourses.add(stressManagement);
        availableCourses.add(materialScience);
        availableCourses.add(englishCourse);
        availableCourses.add(industrialEngineering);
        availableCourses.add(compSci);

    }

    /**
     * Adds new course to the Scheduling System
     *
     * @param newCourse
     */
    public void addCourse(Course newCourse) {
        availableCourses.add(newCourse);
        System.out.println("Successfully added: " + newCourse.getDeptName());
    }

    public void removeCourse() {

    }

    public ArrayList<Course> getCourses() {
        return this.availableCourses;
    }

    public void printSectionInfo() {
        for (int count = 0; count < availableCourses.size(); count++) {
            for (int counter = 0; counter < availableCourses.get(count).getNumOfSections(); counter++) {
                System.out.println(availableCourses.get(count).getSection(counter).getInstructor());
                availableCourses.get(count).getSection(counter).printSectionInfo();
            }
        }
    }

    /**
     * Prints all courses and their respective sections to the console
     */
    public void printCourses() {
        for (Course availableCourse : availableCourses) {
            System.out.println("/********************************");
            System.out.println("COURSE");
            System.out.println("********************************/");
            System.out.println(availableCourse.getDeptName() + ": " + availableCourse.getCourseName());
            for (int sectionNum = 0; sectionNum < availableCourse.getNumOfSections(); sectionNum++) {
                System.out.println("/********************************");
                System.out.println("SECTION: " + sectionNum);
                System.out.println("********************************/");
                Section tempSection = availableCourse.getSection(sectionNum);
                System.out.println("Section Name: " + tempSection.getSectionName());
                System.out.println("Section Days of Week: " + tempSection.getDays());
                System.out.println("Section Meeting times: " + tempSection.getTime());
                System.out.println("Section Room: " + tempSection.getRoom());
                System.out.println("Section Instructor: " + tempSection.getInstructor());
            }
        }
    }

    /**
     * Checks whether the entered username is the Admin
     *
     * @param username
     * @return true if username is the adminUsername or false if not
     */
    public static boolean isAdmin(String username) {
        return username.equals(adminUsername);
    }

    //Getters
    /**
     * Gets a Course based on its name
     *
     * @param deptName
     * @return Course if Course was found by department name, null if Course was
     * not found
     */
    public Course getCourse(String deptName) {
        for (int count = 0; count < availableCourses.size(); count++) {
            if (availableCourses.get(count).getDeptName().matches(deptName)) {
                return availableCourses.get(count);
            }
        }
        return null;
    }

    public void setTimer(CountdownTimer countdownTimer) {
        this.countdownTimer = countdownTimer;
    }

    public CountdownTimer getTimer() {
        return countdownTimer;
    }

    public void runTimer(ShoppingCartWindow shoppingCart, Student currentStudent) {
        countdownTimer.runCountdownTimer(this, currentStudent, shoppingCart);
    }

    public void enableTimer() {
        this.enableTimer = true;
    }

    public void disableTimer() {
        this.enableTimer = false;
    }

    public boolean timerEnabled() {
        return this.enableTimer;
    }

    public void setCurrentStudent(Student student) {
        this.currentStudent = student;
    }

    public Student getCurrentStudent() {
        return this.currentStudent;
    }

    /*
    exportToExcel Helper methods
     */
    private void setHeaders(XSSFRow newRow) {
        for (int column = 0; column < 19; column++) {
            Cell cell = newRow.createCell(column);

            switch (column) {
                case 0:
                    cell.setCellValue("Username");
                    break;
                case 1:
                    cell.setCellValue("Log In Time");
                    break;
                case 2:
                    cell.setCellValue("Countdown Timer started");
                    break;
                case 3:
                    cell.setCellValue("Queue Jump Time");
                    break;
                case 4:
                    cell.setCellValue("Timer Setting: Timer Type");
                    break;
                case 5:
                    cell.setCellValue("Timer Setting: Time to wait");
                    break;
                case 6:
                    cell.setCellValue("Timer Setting: Timer until Queue Jump");
                    break;
                case 7:
                    cell.setCellValue("Countdown Timer ended");
                    break;
                case 8:
                    cell.setCellValue("First Course");
                    break;
                case 9:
                    cell.setCellValue("First Course Added");
                    break;
                case 10:
                    cell.setCellValue("Second Course");
                    break;
                case 11:
                    cell.setCellValue("Second Course Added");
                    break;
                case 12:
                    cell.setCellValue("Third Course");
                    break;
                case 13:
                    cell.setCellValue("Third Course Added");
                    break;
                case 14:
                    cell.setCellValue("Fourth Course");
                    break;
                case 15:
                    cell.setCellValue("Fourth Course added");
                    break;
                case 16:
                    cell.setCellValue("Fifth Course");
                    break;
                case 17:
                    cell.setCellValue("Fifth Course added");
                    break;
                case 18:
                    cell.setCellValue("Logged Out");
                    break;
            }
        }
    }

    private void exportStudentInfo(XSSFRow row) {
        for (int column = 0; column < 19; column++) {
            Cell cell = row.createCell(column);

            switch (column) {
                case 0:
                    cell.setCellValue(currentStudent.getUsername());
                    break;
                case 1:
                    cell.setCellValue(currentStudent.getLogInTime());
                    break;
                case 2:
                    cell.setCellValue(currentStudent.getCountdownTimerStartedTime());
                    break;
                case 3:
                    cell.setCellValue(currentStudent.getQueueJumpTime());
                    break;
                case 4:
                    cell.setCellValue(currentStudent.getTimerType());
                    break;
                case 5:
                    cell.setCellValue(currentStudent.getTimeToWait());
                    break;
                case 6:
                    cell.setCellValue(currentStudent.getTimeToQueueJump());
                    break;
                case 7:
                    cell.setCellValue(currentStudent.getCountdowntimerEndedTime());
                    break;
                case 8:
                    currentStudent.exportCourseSignUpTimes(row, column);
                    column += 9;
                    break;
                case 18:
                    cell.setCellValue(currentStudent.getLoggedOutTime());
                    break;
            }
        }
    }

    public int findLastInputtedRow(XSSFSheet sheet) {
        int row = 0;
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            row++;
        }
        return row;
    }

    public void exportToExcel() {

        //Imports or creates workbook students.xlsx depending on if file exists
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow newRow;
        Cell cell;

        try {
            try (FileInputStream in = new FileInputStream("students.xlsx")) {
                workbook = new XSSFWorkbook(in);
                sheet = workbook.getSheet("Student Details");

                in.close();
                System.out.println("Successfully opened students.xlsx");
                JOptionPane.showMessageDialog(null, "Successfully opened new students.xlsx");
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Creating new file...");

                //Creates a blank workbook and sheet
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Student Details");

                //Creates titles for columns
                newRow = sheet.createRow(0);
                setHeaders(newRow);

                System.out.println("Successfully created students.xlsx");
                JOptionPane.showMessageDialog(null, "Successfully created new students.xlsx");
            } catch (IOException e) {
                System.out.println("Unknown error opening file.");
                JOptionPane.showMessageDialog(null, "Unknown error opening file.");
            }

            lastInputtedRow = findLastInputtedRow(sheet);
            currentStudent.setRowPosition(lastInputtedRow);
            XSSFRow currentStudentRow = sheet.createRow(lastInputtedRow);
            exportStudentInfo(currentStudentRow);

            //Autosizes columns
            for (int count = 0; count < currentStudentRow.getLastCellNum(); count++) {
                sheet.autoSizeColumn(count);
            }

            //Saves to file
            try (FileOutputStream out = new FileOutputStream(new File("students.xlsx"))) {
                workbook.write(out);
                workbook.close();
                out.close();

                //Success message
                System.out.println("Succesfully outputted to students.xlsx");
//                JOptionPane.showMessageDialog(null, "Succesfully outputted to students.xlsx");
            } catch (FileNotFoundException noFile) {
                System.out.println("Unable to create Student file.");
                JOptionPane.showMessageDialog(null, "Unable to create Student file.");

            } catch (IOException e) {
                System.out.println("Error closing fileoutputstream.");
                JOptionPane.showMessageDialog(null, "Error closing fileoutputstream.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            e.printStackTrace();
            e.getMessage();
            e.toString();
        }

    }
    
    public void setPSU_Icon(JFrame targetWindow){
        String iconPath = "C:/Users/wanga/Documents/NetBeansProjects/Dynamic-queue-scheduler/SchedulerProgram/src/main/resources/psuIcon.jpg";
        
        Image icon = Toolkit.getDefaultToolkit().getImage(iconPath);
        targetWindow.setIconImage(icon);
    }

}
