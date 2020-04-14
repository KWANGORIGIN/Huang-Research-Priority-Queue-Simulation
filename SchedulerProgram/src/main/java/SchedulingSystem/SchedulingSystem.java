/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingSystem;
import java.util.ArrayList;
import Course.Course;
import Student.Student;
import java.io.Serializable;
import QueueInfo.Timer.CountdownTimer;

/**
 *
 * @author wanga
 */
public class SchedulingSystem implements Serializable {
    private final ArrayList<Course> availableCourses;
    private static ArrayList<Student> systemUsers;
    private static String adminUsername;
    public static int lastInputtedRow;
    private CountdownTimer timer;//move to Student object?
    
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
    
    public static void removeCourse(){
        
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
    
    public void setTimer(CountdownTimer timer){
        this.timer = timer;
    }
    
    
}
