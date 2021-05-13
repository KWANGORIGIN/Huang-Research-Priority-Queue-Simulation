/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.io.Serializable;
import Course.*;
import QueueInfo.CountdownTimer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 * Student class that is used to hold data about the user
 * @author Kevin Wang
 */
public class Student implements Serializable {

    private String username;
    private int excelRowPosition;
    private LinkedHashMap<Course, Section> enrolledCourses;
    
    private String logInTime;
    private String countdownTimerStartedTime;
    private String queueJumpTime;
    private CountdownTimer timer;
    private String countdownTimerEndedTime;
    private LinkedHashMap<Course, String> timeCourseSignedUp = new LinkedHashMap();
    private String loggedOutTime;
    
    //Constructor (used in LoginScreen)
    public Student(String username, int rowPosition, CountdownTimer timer) {
        this.username = username;
        excelRowPosition = rowPosition;
        this.enrolledCourses = new LinkedHashMap();
        this.timer = timer;
    }
    
    /*
    Set Time Helper Method
    */
    /**
     * Returns the current time as a String formatted as "MM/dd/yyyy HH:mm:ss"
     * @return 
     */
    private String setTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    
    /**
     * Sets the time the user logged in
     */
    public void setLogInTime(){
        this.logInTime = setTime();
    }
    
    /**
     * Gets the time the user logged in as a String
     * @return 
     */
    public String getLogInTime(){
        return this.logInTime;
    }
    
    /**
     * Sets the time the countdown timer started
     */
    public void setCountdownTimerStartedTime(){
        this.countdownTimerStartedTime = setTime();
    }
    
    /**
     * Gets the time the countdown timer started as a String
     * @return 
     */
    public String getCountdownTimerStartedTime(){
        return this.countdownTimerStartedTime;
    }
    
    /**
     * Sets the time the queue jump occurred
     */
    public void setQueueJumpTime(){
        this.queueJumpTime = setTime();
    }
    
    /**
     * Gets the time the countdown timer started as a String
     * @return 
     */
    public String getQueueJumpTime(){
        return this.queueJumpTime;
    }
    
    /**
     * Sets the time the countdown timer ended
     */
    public void setCountdowntimerEndedTime(){
        this.countdownTimerEndedTime = setTime();
    }
    
    /**
     * Gets the time the countdown timer started as a String
     * @return 
     */
    public String getCountdowntimerEndedTime(){
        return this.countdownTimerEndedTime;
    }
    
    /**
     * Gets the timer type assigned to this Student
     * @return 
     */
    public String getTimerType(){
        if(timerDisabled()){
            return timerDisabledMessage();
        }
        return this.timer.getType();
    }
    
    /**
     * Gets the timer duration as a String
     * @return 
     */
    public String getTimeToWait(){
        if(timerDisabled()){
            return timerDisabledMessage();
        }
        return this.timer.getDuration();
    }
    
    /**
     * Gets the time the queue jump will occur as a String
     * @return 
     */
    public String getTimeToQueueJump(){
        if(timerDisabled()){
            return timerDisabledMessage();
        }
        return this.timer.getQueueJumpTime();
    }
    
    /**
     * Checks if timer is disabled
     * @return 
     */
    public boolean timerDisabled(){
        if(this.timer == null){
            return true;
        }
        return false;
    }
    
    /**
     * Returns "Timer Disabled" String
     * @return 
     */
    public String timerDisabledMessage(){
        return "Timer Disabled";
    }
    
    /**
     * Saves time newCourse is signed up
     * @param newCourse 
     */
    public void addCourseSignUpTime(Course newCourse){
        this.timeCourseSignedUp.put(newCourse, setTime());
    }
    
    /**
     * Exports the times each courses was signed up for to the Excel file
     * @param row
     * @param columnPosition 
     */
    public void exportCourseSignUpTimes(XSSFRow row, int columnPosition){
        Cell cell;
        System.out.println("Number of course times: " + timeCourseSignedUp.size());
        
        for(Map.Entry<Course, String> entry : timeCourseSignedUp.entrySet()){
            cell = row.createCell(columnPosition);
            cell.setCellValue(entry.getKey().getDeptName() + ": " + entry.getKey().getCourseName());
            columnPosition++;
            cell = row.createCell(columnPosition);
            cell.setCellValue(entry.getValue());
            columnPosition++;
            System.out.println(entry.getValue());
        }
    }
    
    /**
     * Prints to Console all the Courses the Student is enrolled in. Used mostly for debugging.
     */
    public void printCoursesEnrolled(){
        for(Map.Entry<Course, String> entry : timeCourseSignedUp.entrySet()){
            System.out.println(entry.getKey().getCourseName() + ": " + entry.getValue());
        }
    }
    
    /**
     * Sets the time the user logged out
     */
    public void setLoggedOutTime(){
        this.loggedOutTime = setTime();
    }
    
    /**
     * Gets the timer the user logged out as String
     * @return 
     */
    public String getLoggedOutTime(){
        return this.loggedOutTime;
    }

    public Student() {
        this.username = "";
        excelRowPosition = -1;
    }

    /**
     * Checks whether the username matches the username of the particular
     * Student object
     *
     * @param username
     * @return true if username matches. False if username does not match
     */
    public boolean isStudent(String username) {
        return this.username.matches(username);
    }

    /**
     * Enrolls Student in the Section and its associated Course
     * @param newCourse
     * @param enrolledSection 
     */
    public void enrollCourse(Course newCourse, Section enrolledSection) {
        enrolledSection.addStudent(this);
        enrolledCourses.put(newCourse, enrolledSection);
        addCourseSignUpTime(newCourse);
    }
    
    /**
     * Checks if the Student is enrolled in the enrolled Section
     * @param newCourse
     * @param enrolledSection
     * @return 
     */
    public boolean isStudentEnrolledInCourse(Course newCourse, Section enrolledSection){
        if(enrolledSection.containsStudent(this.username)){
            System.out.println("Student already enrolled in course");
            return true;
        }
        return false;
    }
    
    /**
     * Prints the Student's enrolled courses to a table
     * @param model 
     */
    public void printEnrolledCoursesToTable(DefaultTableModel model){
        
        for(Map.Entry<Course, Section> entry : enrolledCourses.entrySet()){
            Course courseKey = entry.getKey();
            Section sectionValue = entry.getValue();
            Object courseRow[] = new Object[5];
            courseRow[0] = courseKey.getDeptName();
            courseRow[1] = sectionValue.getDays();
            courseRow[2] = sectionValue.getTime();
            courseRow[3] = sectionValue.getRoom();
            courseRow[4] = sectionValue.getInstructor();
            model.addRow(courseRow);
        }
        
    }
    
    /**
     * Gets the number of courses the Student is enrolled in
     * @return 
     */
    public int numOfEnrolledCourses() {
        return enrolledCourses.size();
    }
    
    /**
     * Checks if 2 courses have been added. This is so that when trying to add the third course the timer runs
     * @return 
     */
    public boolean runTimerCondition(){
//        return false;
        return enrolledCourses.size() == 2;//2 courses have been added. So when trying to add third course timer runs
    }
    
    /**
     * Sets the row position the Student is in in the Excel file
     * @param row 
     */
    public void setRowPosition(int row){
        this.excelRowPosition = row;
    }
    
    /**
     * Returns the integer position of the Student's username position in Excel
     * Document
     *
     * @return integer position of username position in Excel document
     */
    public int getRowPosition() {
        return excelRowPosition;
    }

    /**
     * Gets the username of the Student
     * @return 
     */
    public String getUsername() {
        return this.username;
    }

}
