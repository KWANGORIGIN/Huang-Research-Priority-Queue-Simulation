/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Class that defines the Course object. It is primarily a container of Section
 * objects as well as identifying information.
 * @author wanga
 */
public class Course implements Serializable{
    private String courseName;
    private String deptName;
    private ArrayList <Section> sections;
    
    /**
     * Constructor for the Course object
     * 
     * @param deptName String that specifies the department name ex.) CMPSC 121
     * @param courseName String that specifies the course name ex.) Introduction to Programming Techniques
     */
    public Course(String deptName, String courseName){
        this.deptName = deptName;
        this.courseName = courseName;
        this.sections = new ArrayList();
    }
    
    //Setters
    /**
     * Add Section object to this Course object
     * @param newSection Section object to be added to Course
     */
    public void addSection(Section newSection){
        sections.add(newSection);
    }
    
    //Getters
    /**
     * Returns Course name as String ex.) Introduction to Programming Techniques
     * @return Course name as String
     */
    public String getCourseName(){
        return courseName;
    }
    
    /**
     * Returns Department name as String ex.) CMPSC 121
     * @return Department Name as String
     */
    public String getDeptName(){
        return deptName;
    }
    
    /**
     * Get the number of Sections a Course has
     * @return Number of Sections a Course has as an integer
     */
    public int getNumOfSections(){
        return sections.size();
    }
    
    /**
     * Returns Section object based off its position
     * @param sectionNum Integer position of Section in Course
     * @return Returns Section object
     */
    public Section getSection(int sectionNum){
        return sections.get(sectionNum);
    }
    
}
