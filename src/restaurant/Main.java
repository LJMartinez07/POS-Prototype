/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import com.restaurant.classes.User;
import com.restaurant.utilities.FileActions;
import com.restaurant.views.Login;
import java.util.ArrayList;




/**
 *
 * @author Luis
 */
public class Main {
   
  
    public static void main(String[] args) {
        User anj = new User("admin", "1234");
       
        FileActions file = new FileActions("User.txt");
         ArrayList<User> Usuarios = new ArrayList<User>();
         
         
        file.createFile();
        Usuarios.add(anj);
  
       anj.writeFile(Usuarios);
    
       Login log = new Login();
       
       log.show();
      
        // TODO code application logic here
    }
    
}
