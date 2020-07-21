/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingSystem;
import java.util.ArrayList;
import Course.Course;
import Course.Section;
import Student.Student;
import java.io.Serializable;
import QueueInfo.CountdownTimer;
import ShoppingCart.ShoppingCartWindow;

/**
 *
 * @author wanga
 */
public class SchedulingSystem implements Serializable {
    private final ArrayList<Course> availableCourses;
    private static ArrayList<Student> systemUsers;
    private static String adminUsername;
    public static int lastInputtedRow;//Maybe get rid of? Just write to new row regardless? To avoid overwriting
    private CountdownTimer countdownTimer;
    private Student currentStudent;
    
    
    //No-argument constructor
    public SchedulingSystem(){
        availableCourses = new ArrayList<>();
        systemUsers = new ArrayList<>();
        adminUsername = "administrator";
        lastInputtedRow = 0;
    }
    
    /**
     * Adds new course to the Scheduling System
     * @param newCourse 
     */
    public void addCourse(Course newCourse){
        availableCourses.add(newCourse);
        System.out.println("Successfully added: " + newCourse.getDeptName());
    }
    
    public void removeCourse(){
        
    }
    
    public void printSectionInfo(){
        for(int count = 0; count < availableCourses.size(); count++){
            for(int counter = 0; counter < availableCourses.get(count).getNumOfSections(); counter++){
                availableCourses.get(count).getSection(counter).printSectionInfo();
            }
        }
    }
    
    /**
     * Prints all courses and their respective sections to the console
     */
    public void printCourses(){
        for (Course availableCourse : availableCourses) {
            System.out.println("/********************************");
            System.out.println("COURSE");
            System.out.println("********************************/");
            System.out.println(availableCourse.getDeptName() + ": " + availableCourse.getCourseName());
            for(int sectionNum = 0; sectionNum < availableCourse.getNumOfSections(); sectionNum++){
                System.out.println("/********************************");
                System.out.println("SECTION: " + sectionNum);
                System.out.println("********************************/");
                Section tempSection = availableCourse.getSection(sectionNum);
                System.out.println("Section Name: " + tempSection.getSectionName());
                System.out.println("Section Days of Week: " + tempSection.getDays());
                System.out.println("Section Meeting times: " + tempSection.getTime());
                System.out.println("Section Room: " + tempSection.getRoom());
                System.out.println("Section Instructor: " + tempSection.getInstructor());
            }
        }
    }
    
    /**
     * Checks whether the entered username is the Admin
     * @param username
     * @return true if username is the adminUsername or false if not
     */
    public static boolean isAdmin(String username){
        return username.equals(adminUsername);
    }
    
    //Getters
    /**
     * Gets a Course based on its name
     * @param deptName
     * @return Course if Course was found by department name, null if Course was not found
     */
    public Course getCourse(String deptName){
        for(int count = 0; count < availableCourses.size(); count++){
            if(availableCourses.get(count).getDeptName().matches(deptName)){
                return availableCourses.get(count);
            }
        }
        return null;
    }
    
    public void setTimer(CountdownTimer countdownTimer){
        this.countdownTimer = countdownTimer;
    }
    
    public CountdownTimer getTimer(){
        return countdownTimer;
    }
    
    public void runTimer(ShoppingCartWindow shoppingCart, Student currentStudent){
        countdownTimer.runCountdownTimer(this, currentStudent, shoppingCart);
    }
    
    public void setCurrentStudent(Student student){
        this.currentStudent = student;
    }
    
    public Student getCurrentStudent(){
        return this.currentStudent;
    }
    
    public void exportToExcel(){
        
    }
    
}
