/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import com.restaurant.classes.Comment;
import com.restaurant.classes.Employe;
import com.restaurant.classes.User;
import static com.restaurant.utilities.Hash.getMD5;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Luis
 */
public class Main {
    
    static User user = new User();
    static Employe emp = new Employe();
    static Comment comment = new Comment();
    public static void createFile(){
        /*user.createFile();
        emp.createFile();*/
    }
    
    public static void readFile(){
      /*  System.out.println("I'm Reading");
        user.readFile();
        emp.readFile();*/
    }
    
    public static void writeFile(){
        user.writeFile();
        emp.writeFile();
    }
    
    
    
    public void defaultComment(){
      
        
        
    }

    
    public void DefaultValidation(){
        emp.validateFile();
        user.validateFile();
        comment.validateFile();
    }
    public static void main(String[] args){
        
        Main m = new Main();
        //m.
        
    }

}
