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
    private ArrayList<Section> enrolledSections;//maybe try to hash it with enrolledCourses? So that if an enrolledCourse is removed the section is removed as well
    /*
    4/14/20: Create a class that combines Course and Section together so only need one ArrayList to parse?
    */
    
    //Constructor (used in LoginScreen)
    public Student(String username, int rowPosition){
        this.username = username;
        excelRowPosition = rowPosition;
        enrolledCourses = new ArrayList<>();
        enrolledSections = new ArrayList<>();
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
    public boolean enrollCourse(Course newCourse, Section enrolledSection){
//        if(!enrolledCourses.contains(newCourse)){
//            System.out.println("Contains Course: " + enrolledCourses.contains(newCourse));
//            if(!enrolledSections.contains(enrolledSection)){
                enrolledCourses.add(newCourse);
                enrolledSections.add(enrolledSection);
                return true;
//            }
//        }
        //return false;
    }
    
    /**
     * Returns an Course the Student has enrolled in
     * @param listPosition
     * @return An enrolled Course at position listPosition in the ArrayList 
     */
    public Course getEnrolledCourse(int listPosition){
        return enrolledCourses.get(listPosition);
    }
    
    public Section getEnrolledSection(int listPosition){
        return enrolledSections.get(listPosition);
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
    
    public String getUsername(){
        return username;
    }
    
}
