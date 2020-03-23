/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;
import java.util.ArrayList;
/**
 *
 * @author wanga
 */
public class Course {
    private String officialName;
    private String courseName;
    ArrayList <Section> lectures = new ArrayList();
    private String location;
    private String startingDate;
    
    //Constructors
    public Course(String courseName, String officialName, String location, String startingDate){
        this.courseName = courseName;
        this.officialName = officialName;
        this.location = location;
        this.startingDate = startingDate;
    }
    
    //Setters
    public void addLecture(){
        
    }
    
    //Getters
    public String getCourseName(){
        return courseName;
    }
    
    public String getOfficialName(){
        return officialName;
    }
    
    public String getLocation(){
        return location;
    }
    
    public String getStartingDate(){
        return startingDate;
    }
    
}
