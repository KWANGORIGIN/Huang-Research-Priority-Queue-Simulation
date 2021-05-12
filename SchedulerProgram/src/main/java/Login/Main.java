package Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Wang
 */

import java.util.Scanner;
import SchedulingSystem.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 * Main class for the program that contains the main method.
 * @author Kevin Wang 
 */
public class Main {
    /**
     * Main method for the entire program. Creates a SchedulingSystem object if one doesn't already exist before opening an AdministratorWindow.
     * @param args 
     */
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        //Deserializale and loads in scheduling system from file (if exists)
        SchedulingSystem schedulingSystem = new SchedulingSystem();
        
        try(FileInputStream inputFile = new FileInputStream("SchedulingSystem.ser")){
            try(ObjectInputStream inputObject = new ObjectInputStream(inputFile)){

                schedulingSystem = (SchedulingSystem) inputObject.readObject();
                
            }
        }catch(FileNotFoundException fileNotFound){
            //creates new scheduling system if file not found
            System.out.println("Creating new scheduling system...");
            
 
        }catch(ClassNotFoundException classNotFound){
            JOptionPane.showMessageDialog(null, "Error reading scheduling system from file.");
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Unknown error occurred. Scheduling system file possibly corrupted or altered. Please contact administrator.");
            //This exception does occur if changes are made to the SchedulingSystem class and then Main tries to load the previous SchedulingSystem.ser file
            
            //Indicates creation of new Scheduling System
            System.out.println("Creating new Scheduling System...");
        }
        
        schedulingSystem.printSectionInfo();
        AdministratorWindow adminWindow = new AdministratorWindow(schedulingSystem);
        adminWindow.setVisible(true);
        
    }
}
