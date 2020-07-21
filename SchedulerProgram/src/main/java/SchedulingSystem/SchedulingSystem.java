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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.poi.ss.usermodel.Cell;
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
    
    //No-argument constructor
    public SchedulingSystem(){
        availableCourses = new ArrayList<>();
        systemUsers = new ArrayList<>();
        adminUsername = "administrator";
        lastInputtedRow = 0;
    }
    
    /**
     * Adds new course to the Scheduling System
     * @param newCourse 
     */
    public void addCourse(Course newCourse){
        availableCourses.add(newCourse);
        System.out.println("Successfully added: " + newCourse.getDeptName());
    }
    
    public void removeCourse(){
        
    }
    
    public void printSectionInfo(){
        for(int count = 0; count < availableCourses.size(); count++){
            for(int counter = 0; counter < availableCourses.get(count).getNumOfSections(); counter++){
                availableCourses.get(count).getSection(counter).printSectionInfo();
            }
        }
    }
    
    /**
     * Prints all courses and their respective sections to the console
     */
    public void printCourses(){
        for (Course availableCourse : availableCourses) {
            System.out.println("/********************************");
            System.out.println("COURSE");
            System.out.println("********************************/");
            System.out.println(availableCourse.getDeptName() + ": " + availableCourse.getCourseName());
            for(int sectionNum = 0; sectionNum < availableCourse.getNumOfSections(); sectionNum++){
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
     * @param username
     * @return true if username is the adminUsername or false if not
     */
    public static boolean isAdmin(String username){
        return username.equals(adminUsername);
    }
    
    //Getters
    /**
     * Gets a Course based on its name
     * @param deptName
     * @return Course if Course was found by department name, null if Course was not found
     */
    public Course getCourse(String deptName){
        for(int count = 0; count < availableCourses.size(); count++){
            if(availableCourses.get(count).getDeptName().matches(deptName)){
                return availableCourses.get(count);
            }
        }
        return null;
    }
    
    public void setTimer(CountdownTimer countdownTimer){
        this.countdownTimer = countdownTimer;
    }
    
    public CountdownTimer getTimer(){
        return countdownTimer;
    }
    
    public void runTimer(ShoppingCartWindow shoppingCart, Student currentStudent){
        countdownTimer.runCountdownTimer(this, currentStudent, shoppingCart);
    }
    
    public void setCurrentStudent(Student student){
        this.currentStudent = student;
    }
    
    public Student getCurrentStudent(){
        return this.currentStudent;
    }
    
    /*
    exportToExcel Helper method
    */
    private void setHeaders(XSSFRow newRow){
        for(int column = 0; column < 19; column++){
            Cell cell = newRow.createCell(column);
            
            switch(column){
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
                    cell.setCellValue("Logged Out");
                    break;
            } 
        } 
    }
    
    public void exportToExcel(){
                
        //Imports or creates workbook students.xlsx depending on if file exists
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow newRow;
        Cell cell;

        try (FileInputStream in = new FileInputStream("students.xlsx")) {
            workbook = new XSSFWorkbook(in);
            sheet = workbook.getSheet("Student Details");

            in.close();
            System.out.println("Successfully opened students.xlsx");

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Creating new file...");

            //Creates a blank workbook and sheet
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Student Details");

            //Creates titles for columns
            newRow = sheet.createRow(0);
            setHeaders(newRow);

            System.out.println("Successfully created students.xlsx");
        } catch (IOException e) {
            System.out.println("Unknown error opening file.");
        }

        XSSFRow currentStudentRow = sheet.getRow(currentStudent.getRowPosition());

        //Adds timestamp
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        Cell timeCell = currentStudentRow.createCell(2);
        timeCell.setCellValue(dateTime);

        //Autosizes columns
        for (int count = 0; count < currentStudentRow.getLastCellNum(); count++) {//changed from newRow...add contingencies later
            sheet.autoSizeColumn(count);
        }

        //Saves to file
        try (FileOutputStream out = new FileOutputStream(new File("students.xlsx"))) {
            workbook.write(out);
            out.close();

            //Success message
            System.out.println("Succesfully outputted to students.xlsx");
        } catch (FileNotFoundException noFile) {
            System.out.println("Unable to create Student file.");
        } catch (IOException e) {
            System.out.println("Error closing fileoutputstream.");
        }
    }
    
}
