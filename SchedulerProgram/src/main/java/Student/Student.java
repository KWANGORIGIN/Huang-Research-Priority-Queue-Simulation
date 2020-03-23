/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.io.Serializable;
import java.util.ArrayList;
import Course.*;

/**
 *
 * @author wanga
 */
public class Student implements Serializable{
    private String username;
    private int excelRowPosition;
    private ArrayList<Course> enrolledCourses;
    
    //Constructor (used in LoginScreen)
    public Student(String username, int rowPosition){
        this.username = username;
        excelRowPosition = rowPosition;
        enrolledCourses = new ArrayList<>();
    }
    
    public Student(){
        this.username = "";
        excelRowPosition = -1;
        enrolledCourses = new ArrayList<>();
    }
    
    /**
     * Checks whether the username matches the username of the particular Student object
     * @param username
     * @return true if username matches. False if username does not match
     */
    public boolean isStudent(String username){
        return this.username.matches(username);
    }
    
    //
    public void enrollCourse(){
        
    }
    
    /**
     * Returns an Course the Student has enrolled in
     * @param listPosition
     * @return An enrolled Course at position listPosition in the ArrayList 
     */
    public Course getEnrolledCourse(int listPosition){
        return enrolledCourses.get(listPosition);
    }
    
    public int numOfEnrolledCourses(){
        return enrolledCourses.size();
    }
    
    /**
     * Returns the integer position of the Student's username position in Excel Document
     * @return integer position of username position in Excel document 
     */
    public int getRowPosition(){
        return excelRowPosition;
    }
    
    
}