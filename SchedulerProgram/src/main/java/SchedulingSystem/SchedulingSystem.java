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
    
    public static void addCourse(){
        
        
    }
    
    public static void removeCourse(){
        
    }
    
    /**
     * Checks whether the username entered matches that of user already in system
     * @param username
     * @return true if user is already in system. False if user is not in system.
     */
//    public static boolean userExists(String username){
//        for(int count = 0; count < systemUsers.size(); count++){
//            if(systemUsers.get(count).isStudent(username)){
//                return true;
//            }
//        }
//        return false;
//    }
    
    /**
     * Checks whether the entered username is the Admin
     * @param username
     * @return true if username is the adminUsername or false if not
     */
    public static boolean isAdmin(String username){
        return username.equals(adminUsername);
    }
    
    
    
}
