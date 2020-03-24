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
public class Course implements Serializable{
    private String courseName;
    private String deptName;
    ArrayList <Section> sections = new ArrayList();
    
    //Constructors
    public Course(String deptName, String courseName){
        this.deptName = deptName;
        this.courseName = courseName;
    }
    
    //Setters
    public void addSection(Section newSection){
        sections.add(newSection);
    }
    
    //Getters
    public String getCourseName(){
        return courseName;
    }
    
    public String getDeptName(){
        return deptName;
    }
    
    public int getNumOfSections(){
        return sections.size();
    }
    
    
    
}
