/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

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
    public static void createFile(){
        user.createFile();
        emp.createFile();
    }
    
    public static void readFile(){
        System.out.println("I'm Reading");
        user.readFile();
        emp.readFile();
    }
    
    public static void writeFile(){
        user.writeFile();
        emp.writeFile();
    }
    
   public void DefaultUser(){
       user.createFile();
        user.getUsers().add(new User(1, "Admin", getMD5("123456"), "Luis@gmail.com", 1, 1));
        user.writeFile();
        System.out.println("Default User has been created");
        
    }
  public  void defaultEmploye(){
         Date date = new Date();
         emp.createFile();
         emp.getEmployees().add(new Employe(1, 1, "NO PICTURE", 0, 0, 0, "Luis", "Martinez", "", "M", "santiago", "809-570-7176", "809-502-2278", "44544564", date));
        emp.writeFile();
        System.out.println("Default Employe has been created");
    }

    
    public void DefaultValidation(){
        defaultEmploye();
                DefaultUser();
       
    }
    public static void main(String[] args) throws ParseException {
        
     
  
    } 

}
