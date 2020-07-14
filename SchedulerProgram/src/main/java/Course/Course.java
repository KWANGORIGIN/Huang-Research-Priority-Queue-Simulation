/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;
import Student.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author wanga
 */
public class Course implements Serializable{
    private String courseName;
    private String deptName;
    private ArrayList <Section> sections;
    
    //Constructors
    public Course(String deptName, String courseName){
        this.deptName = deptName;
        this.courseName = courseName;
        this.sections = new ArrayList();
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
    
    public Section getSection(int sectionNum){
        return sections.get(sectionNum);
    }
    
}
