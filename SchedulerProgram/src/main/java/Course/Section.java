/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

import java.io.Serializable;
import java.util.ArrayList;

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
    //Add ArrayList of Student objects? Maybe in Sections?
    
    //Constructor
    public Section(String sectionName, String days, String time, String room, String instructor){
        this.sectionName = sectionName;
        this.days = days;
        this.time = time;
        this.room = room;
        this.instructor = instructor;
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
    
    
}
