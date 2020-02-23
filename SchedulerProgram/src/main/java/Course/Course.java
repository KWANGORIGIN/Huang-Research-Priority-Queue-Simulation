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
    private String courseName;
    ArrayList <Lecture> lectures = new ArrayList();
    private int roomNum;
    private String instructor;
    //private String startingDate;//Might change to another data type in the future  ¯\_(ツ)_/¯
    
    //Constructors
    public Course(String courseName, int roomNum, String instructor){
        this.courseName = courseName;
        this.roomNum = roomNum;
        this.instructor = instructor;
    }
    
    //Getters
    public String getCourseName(){
        return courseName;
    }
    
    public int getRoomNum(){
        return roomNum;
    }
    
    public String getInstructor(){
        return instructor;
    }
    
}
