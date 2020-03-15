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

/**
 *
 * @author wanga
 */
public class SchedulingSystem implements Serializable {
    public static ArrayList<Course> availableCourses;
    private static ArrayList<Student> systemUsers;
    private static String adminUsername;
    public static int lastInputtedRow;
    
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
    public static void addCourse(Course newCourse){
        availableCourses.add(newCourse);
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
    
    
    
}
