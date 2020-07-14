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
 *
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
    public Section(String sectionName, String days, String time, String room, String instructor){
        this.sectionName = sectionName;
        this.days = days;
        this.time = time;
        this.room = room;
        this.instructor = instructor;
        this.studentsEnrolled = new HashMap();
    }
    
    //Getters
    public String getSectionName(){
        return sectionName;
    }
    
    public String getDays(){
        return days;
    }
    
    public String getTime(){
        return time;
    }
    
    public String getRoom(){
        return room;
    }
    
    public String getInstructor(){
        return instructor;
    }
    
    public void addStudent(Student newStudent){
        studentsEnrolled.put(newStudent.getUsername(), newStudent);
    }
    
    public boolean containsStudent(String studentUsername){
        return studentsEnrolled.containsKey(studentUsername);
    }
    
    
    
    
}
