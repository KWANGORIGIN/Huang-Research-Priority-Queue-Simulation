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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wanga
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
    
    /*
    Set Time Helper Method
    */
    private String setTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    
    public void setLogInTime(){
        this.logInTime = setTime();
    }
    
    public void setCountdownTimerStartedTime(){
        this.countdownTimerStartedTime = setTime();
    }
    
    public void setQueueJumpTime(){
        this.queueJumpTime = setTime();
    }
    
    public void setCountdowntimerEndedTime(){
        this.countdownTimerEndedTime = setTime();
    }
    
    public void addCourseSignUpTime(Course newCourse){
        this.timeCourseSignedUp.put(newCourse, setTime());
    }
    
    public void setLoggedOutTime(){
        this.loggedOutTime = setTime();
    }

    //Constructor (used in LoginScreen)
    public Student(String username, int rowPosition, CountdownTimer timer) {
        this.username = username;
        excelRowPosition = rowPosition;
        this.enrolledCourses = new LinkedHashMap();
        this.timer = timer;
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

    public boolean enrollCourse(Course newCourse, Section enrolledSection) {
        if(enrolledSection.containsStudent(this.username)){
            System.out.println("Student already enrolled in course");
            return false;
        }
        enrolledSection.addStudent(this);
        enrolledCourses.put(newCourse, enrolledSection);
        addCourseSignUpTime(newCourse);
        return true;
    }
    
    public void printEnrolledCoursesToTable(DefaultTableModel model){
        
        for(Map.Entry<Course, Section> entry : enrolledCourses.entrySet()){
            Course courseKey = entry.getKey();
            Section sectionValue = entry.getValue();
            Object courseRow[] = new Object[4];
            courseRow[0] = courseKey.getDeptName();
            courseRow[1] = sectionValue.getDays() + "          " + sectionValue.getTime();//Change spacing later
            courseRow[2] = sectionValue.getRoom();
            courseRow[3] = sectionValue.getInstructor();
            model.addRow(courseRow);
        }
        
    }

    public int numOfEnrolledCourses() {
        return enrolledCourses.size();
    }
    
    public boolean runTimerCondition(){
        return enrolledCourses.size() == 3;
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

    public String getUsername() {
        return username;
    }

}
