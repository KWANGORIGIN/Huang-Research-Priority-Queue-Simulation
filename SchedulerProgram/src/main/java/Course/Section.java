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
    private String dateTime;
    private String room;
    private String instructor;
    //Add ArrayList of Student objects? Maybe in Sections?
    
    //Constructor
    public Section(String sectionName, String dateTime, String room, String instructor){
        this.sectionName = sectionName;
        this.dateTime = dateTime;
        this.room = room;
        this.instructor = instructor;
    }
    
    //Getters
    public String getSectionName(){
        return sectionName;
    }
    
    public String getDateTime(){
        return dateTime;
    }
    
    public String getRoom(){
        return room;
    }
    
    public String getInstructor(){
        return instructor;
    }
    
    
}
