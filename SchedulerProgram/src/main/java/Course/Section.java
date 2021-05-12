/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

import Student.Student;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Class that defines the Section object. Usually contained within a Course object.
 * @author wanga
 */
public class Section implements Serializable {
    
    private String sectionName;
    private String days;
    private String time;
    private String room;
    private String instructor;
    private HashMap <String, Student> studentsEnrolled;
    
    //Constructor
    /**
     * Constructor for Section object
     * @param sectionName String for name of Section
     * @param days String for days this Section is available
     * @param time String for time this Section is available
     * @param room String for room
     * @param instructor String for instructor
     */
    public Section(String sectionName, String days, String time, String room, String instructor){
        this.sectionName = sectionName;
        this.days = days;
        this.time = time;
        this.room = room;
        this.instructor = instructor;
        this.studentsEnrolled = new HashMap();
    }
    
    //Getters
    /**
     * Get name of Section
     * @return Section name as String
     */
    public String getSectionName(){
        return sectionName;
    }
    
    /**
     * Get days Section is available as String
     * @return Returns days Section is available as String
     */
    public String getDays(){
        return days;
    }
    
    /**
     * Get time Section is available as String
     * @return Returns time Section is available as String
     */
    public String getTime(){
        return time;
    }
    
    /**
     * Get room Section is in as String
     * @return Returns room Section is in as String
     */
    public String getRoom(){
        return room;
    }
    
    /**
     * Get instructor teaching Section as String
     * @return Returns instructor teaching Section as String
     */
    public String getInstructor(){
        return instructor;
    }
    
    /**
     * Add a Student object to this section
     * @param newStudent Student object to be added to Section
     */
    public void addStudent(Student newStudent){
        studentsEnrolled.put(newStudent.getUsername(), newStudent);
    }
    
    /**
     * Checks if Section contains particular Student based off the Student's username
     * @param studentUsername String for the Student that is being checked
     * @return Boolean
     */
    public boolean containsStudent(String studentUsername){
        return studentsEnrolled.containsKey(studentUsername);
    }
    
    /**
     * Prints the number of Students enrolled in the Section. Mostly used for debugging
     */
    public void printSectionInfo(){
        System.out.println("Number of Students enrolled in this section: " + studentsEnrolled.size());
    }
    
    
    
}
