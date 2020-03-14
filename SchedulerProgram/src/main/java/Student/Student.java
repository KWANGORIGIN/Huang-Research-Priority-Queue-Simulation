/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author wanga
 */
public class User {
    private String username;
    private int excelRowPosition;
    
    //Constructor (used in LoginScreen)
    User(String username){
        this.username = username;
        excelRowPosition = 0;//Setting as 0 for now
    }
    
    
}
