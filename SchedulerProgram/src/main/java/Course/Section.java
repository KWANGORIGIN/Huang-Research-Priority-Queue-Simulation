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
public class Section {
    private int classNumber;
    private String sectionName;
    
    
    
    private String dayOfWeek;
    private String instructor;
    private String startingTime;
    private String endingTime;
    private String starting12HourPeriod;
    private String ending12HourPeriod;
    //private int duration;
    private String lectureOrLab;
    
    //Constructor
    Section(int classNumber, String dayOfWeek, String startingTime, String endingTime, String instructor, String starting12HourPeriod, String ending12HourPeriod, String lectureOrLab){
        this.classNumber = classNumber;
        this.dayOfWeek = dayOfWeek;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.instructor = instructor;
        this.starting12HourPeriod = starting12HourPeriod;
        this.ending12HourPeriod = ending12HourPeriod;
        this.lectureOrLab = lectureOrLab;   
    }
    
    
}
