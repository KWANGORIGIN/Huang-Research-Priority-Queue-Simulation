/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingSystem;
import java.util.ArrayList;
import Course.Course;
import User.User;

/**
 *
 * @author wanga
 */
public class SchedulingSystem {
    public static ArrayList<Course> availableCourses;
    private static ArrayList<User> systemUsers;
    
    public SchedulingSystem(){
        availableCourses = new ArrayList<>();
        systemUsers = new ArrayList<>();
    }
    
    
    
}
