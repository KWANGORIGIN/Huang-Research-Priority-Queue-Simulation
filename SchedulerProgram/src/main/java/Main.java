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
import Course.*;
import SchedulingSystem.*;
import ShoppingCart.*;
import Login.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Main {
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
            //Initializes a few courses
            

        }catch(ClassNotFoundException classNotFound){
            JOptionPane.showMessageDialog(null, "Error reading scheduling system from file.");
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Unknown error occurred. Scheduling system file possibly corrupted or altered. Please contact administrator.");
            //This exception does occur if changes are made to the SchedulingSystem class and then Main tries to load the previous SchedulingSystem.ser file
            
            //Indicates creation of new Scheduling System
            System.out.println("Creating new Scheduling System...");
        }
        
        //Creates LoginScreen and makes it visible to user
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        
        
        
        
        
        
        
        
        
       
        //Outputs scheduling system to file
        try(FileOutputStream outputFile = new FileOutputStream("SchedulingSystem.ser")){
            try(ObjectOutputStream output = new ObjectOutputStream(outputFile)){
                output.writeObject(schedulingSystem);
                System.out.println("Changes from this session have been saved.");
            }
            
        }catch(FileNotFoundException fileNotFound){
            System.out.println("File not found");
        }catch(IOException ioException){
            System.out.println("Error saving to file.");
        }
        
        
    }
}
