/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.io.Serializable;
import java.util.ArrayList;
import Course.*;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wanga
 */
public class Student implements Serializable {

    private String username;
    private int excelRowPosition;
    private LinkedHashMap<Course, Section> enrolledCourses;

    //Constructor (used in LoginScreen)
    public Student(String username, int rowPosition) {
        this.username = username;
        excelRowPosition = rowPosition;
        this.enrolledCourses = new LinkedHashMap();
    }

    public Student() {
        this.username = "";
        excelRowPosition = -1;
    }

    /**
     * Checks whether the username matches the username of the particular
     * Student object
     *
     * @param username
     * @return true if username matches. False if username does not match
     */
    public boolean isStudent(String username) {
        return this.username.matches(username);
    }

    public boolean enrollCourse(Course newCourse, Section enrolledSection) {
        if(enrolledSection.containsStudent(username)){
            enrolledCourses.put(newCourse, enrolledSection);
            return true;
        }
        return false;
    }
    
    public DefaultTableModel printEnrolledCoursesToTable(DefaultTableModel model){
        for(Map.Entry<Course, Section> entry : enrolledCourses.entrySet()){
            Course courseKey = entry.getKey();
            Section sectionValue = entry.getValue();
            Object courseRow[] = new Object[4];
            courseRow[0] = courseKey.getDeptName();
            courseRow[1] = sectionValue.getDays() + "          " + sectionValue.getTime();//Change spacing later
            courseRow[2] = sectionValue.getRoom();
            courseRow[3] = sectionValue.getInstructor();
            model.addRow(courseRow);
        }
        return model;
    }
//    /**
//     * Returns an Course the Student has enrolled in
//     *
//     * @param listPosition
//     * @return An enrolled Course at position listPosition in the ArrayList
//     */
//    public Course getEnrolledCourse(int listPosition) {
//        return enrolledCourses.get(listPosition);
//    }

//    public Section getEnrolledSection(int listPosition) {
//        return enrolledSections.get(listPosition);
//    }

    public int numOfEnrolledCourses() {
        return enrolledCourses.size();
    }

    /**
     * Returns the integer position of the Student's username position in Excel
     * Document
     *
     * @return integer position of username position in Excel document
     */
    public int getRowPosition() {
        return excelRowPosition;
    }

    public String getUsername() {
        return username;
    }

}
