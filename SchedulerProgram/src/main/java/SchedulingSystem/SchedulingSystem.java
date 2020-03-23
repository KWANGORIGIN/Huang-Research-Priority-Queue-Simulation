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
        
        //Hard coding in course info for now
        Course tempCourse = new Course("CMPSC 121", "Introduction to Programming Techniques", "Burke 101", "08/31/2020");
        availableCourses.add(tempCourse);
        
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
    
    //Getters
    /**
     * Gets a Course based on its name
     * @param courseName
     * @return Course if Course was found by course name, null if Course was not found
     */
    public static Course getCourse(String courseName){
        /*
        Need to implement string matching in case courseName is structured like
        courseName# with no space between courseName and #
        */
        
        
        for(int count = 0; count < availableCourses.size(); count++){
            if(availableCourses.get(count).getCourseName().matches(courseName)){
                return availableCourses.get(count);
            }
        }
        return null;
    }
    
    
    
}
